package com.example.demo1.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author a58
 * 泛型具有"向下兼容性"（自定义）
 */
public class GenericTest {
    public static void main(String[] args) {
        //可以向zoo里面插入Animal以及它的子类
        List<Animal> zoo = new ArrayList<>();
        zoo.add(new Dog());
        zoo.add(new DogSon());
        zoo.add(new Animal());
        /*zoo.add(new Person());*/
        //注意取出的时候可以用Animal进行接收
        Animal animal = zoo.get(0);


        //? extends Animal表示 这是一个Animal泛型的子类泛型。可以是Animal,Dog等
        //可以确定的是从zoo1里面取出来的对象一定是可以转型成Animal的，但是不能向里面存放东西（因为泛型不确定）
        List<? extends Animal> zoo1 = new ArrayList<>();
//        zoo1.add(new Dog());
//        zoo1.add(new Animal());
//        zoo1.add(new DogSon());
        zoo1 = zoo;
        Animal animal1 = zoo1.get(0);


        //? super Animal 表示 这是一个Animal泛型或者其父类型泛型，可能是Animal，Object
        //由于泛型的向下兼容，可以向里面插入Animal以及Animal的子类，
        //但是取出来是有风险的，因为取出来不确定是Animal还是Object
        List<? super Animal> zoo2 = new ArrayList<>();
        zoo2.add(new Animal());
        zoo2.add(new Dog());
        zoo2.add(new DogSon());
//        zoo2 = zoo;
//        zoo2.add(new Object());
        Object object = zoo2.get(0);//会有风险，因为会导致信息丢失


        //泛型通配符? 代表任意泛型
        //既然?代表任意泛型，那么换句话说，这个容器什么泛型都有可能
        //所以只能以Object的形式取出来
        //并且不能往里面放对象，因为不知道到底是一个什么泛型的容器
        List<?> zoo3 = new ArrayList<>();
//        zoo3.add(new Dog());
//        zoo3.add(new Object());
        zoo3 = zoo;
        Object o = zoo3.get(0);


        //子父类泛型不能相互转换
        List<Dog> zoo4 = new ArrayList<>();
//        zoo = zoo4; //子类泛型转父类泛型，不可
//        zoo4 = zoo; //父类泛型转子类泛型，不可

        //测试静态方法的泛型使用
        List<Integer> list1 = getList(1);
        List<String>  list2 = getList("sea");
        List<Dog>     list  = getList(new Dog());
        Dog           dog   = list.get(0);

    }

    public static <K> List<K> getList(K element) {
        List<K> ans = new ArrayList<>();
        ans.add(element);
        return ans;
    }
}
