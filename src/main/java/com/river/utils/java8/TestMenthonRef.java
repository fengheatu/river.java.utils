package com.river.utils.java8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 * @author he.feng
 * @2018/6/20
 * @desc  方法引用：
 *                若Lambda 体中的内容有方法已经实现了，我们可以使用‘方法引用’
 *                （可以理解为是Lambda表达式的另一种表现形式）
 *        主要有三种语法格式：
 *        对象::实例方法
 *        类::静态方法
 *        类::实例方法
 */
public class TestMenthonRef {

    @Test
    public void test1() {
        Consumer<String> consumer = (x) -> System.out.println(x);

        PrintStream ps = System.out;
        Consumer<String> consumer1 = ps::println;

        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("dafafaffa");

    }

    @Test
    public void test3() {
        BiPredicate<String,String> bp = String::equals;
        System.out.println(bp.test("aaaa","afafa"));
    }
}
