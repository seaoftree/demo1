package com.example.demo1.Java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("a","b","A","B");
        str.sort(String :: compareToIgnoreCase);
        str.sort(Comparator.comparing(String::toString).reversed());

    }
    @Test
    public void testReduce(){
        List<Integer> integers = Arrays.asList(1, 2, 3, null, 5, 6, 7, 8, 9);
        Optional<Integer> reduce = integers.stream()
                .filter(Objects::nonNull)
                .reduce(Integer::sum);  //这段代码暗含一个装箱的成本，每个Integer都必须拆箱成一个原始类型才可以进行求和
        System.out.println(reduce.orElse(null));

        int sum = integers.stream().filter(Objects::nonNull).mapToInt(o -> o).sum(); //映射成数值流
        System.out.println(sum);

        IntStream intStream = integers.stream().filter(Objects::nonNull).mapToInt(o -> o);
        Stream<Integer> boxed = intStream.boxed();//转换成对象流
    }

    @Test
    public void testRange(){
        IntStream intStream1 = IntStream.rangeClosed(1, 100).filter(o -> o % 2 == 0);//闭集
        IntStream intStream2 = IntStream.range(1, 100).filter(o -> o % 2 == 0);//开集
        System.out.println(intStream1.count());
        System.out.println(intStream2.count());
    }

    @Test
    public void testFlatMap(){
        String [] arraysOfWord = {"hello","null"};
        String collect = Arrays.stream(arraysOfWord)
                .map(o -> o.split(""))
                .flatMap(Arrays::stream)//扁平流
                .distinct()
                .collect(Collectors.joining(","));
        System.out.println(collect);

    }

    @Test
    public void testMatch(){
        List<String> strings = Arrays.asList("hello", "sky", "sea");
        Optional<String> any = strings.stream()
                .filter(Objects::nonNull)
                .limit(2)
                .findAny();
        System.out.println(any.orElse(null));
    }

    @Test
    public void testIterate(){
//        Stream.iterate(0,o -> o + 2)  //创建无限流的方法一
//                .limit(100)
//                .forEach(System.out::println);

        Stream.iterate((new int[]{0,1}),o -> new int[]{o[1],o[0] + o[1]})
                .limit(20)
                .forEach(o -> System.out.println(o[0] + "   " + o[1]));
    }
}
