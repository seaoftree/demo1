package com.example.demo1.generic;

class Demo {
    public static void main(String[] args) {
        Show<String> show = new Show<>();
        //show.print1(new Integer(1));// 不能编译
        show.print2(new Integer(1));// 可以编译
    }
}

/**
 * Description:方法返回值前的<E>的左右是告诉编译器，当前的方法的值传入类型可以和类初始化的泛型类不同，也就是该方法的泛型类可以自定义，不需要跟类初始化的泛型类相同
 * Author:LiuGan
 * Create time:2021/12/28
 */
public class Show<T> {
    public void print1(T t) {
        System.out.println(t);
    }

    /**
     * print1中的泛型与show对象的泛型相同，都是String，因此不能传入Integer类型的参数。
     * 而print2方法自定义了一个泛型E，因此方法参数类型不受对象泛型类型限制，这样定义的话这个方法是可以传入任意类型的参数的。
     *
     * @param t
     * @param <E>
     */
    public <E> void print2(E t) { //方法的泛型优先级高于类的泛型
        System.out.println(t);
    }
}
