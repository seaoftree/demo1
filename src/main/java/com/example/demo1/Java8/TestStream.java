package com.example.demo1.Java8;

import ch.qos.logback.core.joran.conditional.ElseAction;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("a", "b", "A", "B");
        str.sort(String::compareToIgnoreCase);
        str.sort(Comparator.comparing(String::toString).reversed());

    }

    @Test
    public void testReduce() {
        List<Integer> integers = Arrays.asList(1, 2, 3, null, 5, 6, 7, 8, 9);
        Optional<Integer> reduce = integers.stream()
                .filter(Objects::nonNull)
                //这段代码暗含一个装箱的成本，每个Integer都必须拆箱成一个原始类型才可以进行求和
                .reduce(Integer::sum);
        System.out.println(reduce.orElse(null));

        //映射成数值流
        int sum = integers.stream().filter(Objects::nonNull).mapToInt(o -> o).sum();
        System.out.println(sum);

        IntStream intStream = integers.stream().filter(Objects::nonNull).mapToInt(o -> o);
        //转换成对象流
        Stream<Integer> boxed = intStream.boxed();
    }

    @Test
    public void testRange() {
        //闭集
        IntStream intStream1 = IntStream.rangeClosed(1, 100).filter(o -> o % 2 == 0);
        //开集
        IntStream intStream2 = IntStream.range(1, 100).filter(o -> o % 2 == 0);
        System.out.println(intStream1.count());
        System.out.println(intStream2.count());
    }

    @Test
    public void testFlatMap() {
        String[] arraysOfWord = {"hello", "null"};
        String collect = Arrays.stream(arraysOfWord)
                .map(o -> o.split(""))
                //扁平流
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.joining(","));
        System.out.println(collect);

    }

    @Test
    public void testMatch() {
        List<String> strings = Arrays.asList("hello", "sky", "sea");
        Optional<String> any = strings.stream()
                .filter(Objects::nonNull)
                .limit(2)
                .findAny();
        System.out.println(any.orElse(null));
    }

    @Test
    public void testIterate() {
        //创建无限流的方法一
        Stream.iterate(0, o -> o + 2)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("--------------------------------------------");
        Stream.iterate((new int[]{0, 1}), o -> new int[]{o[1], o[0] + o[1]})
                .limit(5)
                .forEach(o -> System.out.println(o[0] + "   " + o[1]));

        System.out.println("--------------------------------------------");
        //创建无限流的方法二
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

    @Test
    public void testCollect() {
        Person sea = new Person(20, "sea");
        Person sky = new Person(30, "sky");
        Person tree = new Person(40, "tree");
        Person wall = new Person(40, "ops");
        List<Person> people = Arrays.asList(sea, sky, tree, wall);

        String collect3 = people.stream().map(Person::getName)
                .distinct()
                .collect(Collectors.joining(","));
        System.out.println(collect3);
        System.out.println("--------------------------------------------");

        //多级分组
        Map<Integer, Map<String, List<Person>>> collect = people.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.groupingBy(o -> {
                            if (o.getName().length() > 3) {
                                return "longName";
                            } else {
                                return "shortName";
                            }
                        }
                )));
        System.out.println(collect);

        System.out.println("--------------------------------------------");
        Map<Integer, Long> collect2 = people.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
        System.out.println(collect2);

        System.out.println("--------------------------------------------");
        long count = people.stream().map(Person::getAge).reduce(Integer::sum).get();
        System.out.println(count);

        System.out.println("--------------------------------------------");
        Optional<Person> collect1 = people.stream().min(Comparator.comparingInt(Person::getAge));
        System.out.println(collect1.get());

        System.out.println("--------------------------------------------");
        String names = people.stream().map(Person::getName).collect(Collectors.joining(", "));
        System.out.println(names);
    }

    @Test
    public void testParallel() {

        //自动装箱反而会使并行的执行性能变差
        long startTime = System.currentTimeMillis();
        Long reduce = Stream.iterate(1L, i -> i + 1)
                .limit(1000)
                .parallel()
                .reduce(0L, Long::sum);
        long endTime = System.currentTimeMillis();
        System.out.println("parallel_time:" + (endTime - startTime) + "ms" + "   result:" + reduce);

        long startTime1 = System.currentTimeMillis();
        Long reduce1 = Stream.iterate(1L, i -> i + 1)
                .limit(1000)
                .reduce(0L, Long::sum);
        long endTime1 = System.currentTimeMillis();
        System.out.println("time:" + (endTime1 - startTime1) + "ms" + "   result:" + reduce1);

        //自动装箱反而会使并行的执行性能变差,但是下面的验证也不能说明并行流的有效性，有点奇怪。。。
        System.out.println("--------------------------------------------");
        long startTime2 = System.currentTimeMillis();
        long reduce2 = LongStream.rangeClosed(1, 1000000).parallel().reduce(0L, Long::sum);
        long endTime2 = System.currentTimeMillis();
        System.out.println("parallel_time:" + (endTime2 - startTime2) + "ms" + "   result:" + reduce2);

        long startTime3 = System.currentTimeMillis();
        long reduce3 = LongStream.rangeClosed(1, 1000000).reduce(0L, Long::sum);
        long endTime3 = System.currentTimeMillis();
        System.out.println("time:" + (endTime3 - startTime3) + "ms" + "   result:" + reduce3);

        Runnable runnable = () -> System.out.println("hello");
        Thread thread = new Thread(runnable);
        thread.start();

    }
}
