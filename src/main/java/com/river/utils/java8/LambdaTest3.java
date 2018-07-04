package com.river.utils.java8;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author he.feng
 * @2018/6/20
 * @desc  Java 8 内置的四大核心函数式接口
 *
 * Consumer<T> :消费型接口
 *     void accept(T t);
 *
 * Supplier<T>:供给型接口
 *      T get();
 *
 * Function<T,R> : 函数型接口
 *      R apply(T t)
 *
 * Predicate<T> : 断言型接口
 *     boolean test(T T)
 *
 */
public class LambdaTest3 {


    /**
     *
     * Consumer<T> :消费型接口
     *     void accept(T t);
     */
    @Test
    public void test1() {
        happy(10000,(m) -> System.out.println(m));
    }

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }


    /**
     * Supplier<T>:供给型接口
     *  *      T get();
     */
    @Test
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        System.out.println(numList);
    }

    public List<Integer> getNumList(Integer num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< num;i++) {
            Integer n = supplier.get();
            list.add(n);
        }

        return list;
    }

    /**
     * Function<T,R> : 函数型接口
     *  *      R apply(T t)
     */
    @Test
    public void test3() {
        String newStr = strHandler("dafdsafsafdasf",(s) -> StringUtils.upperCase(s));
        System.out.println(newStr);
    }

    public String strHandler(String str, Function<String,String> function) {
        return function.apply(str);
    }


    /**
     *  Predicate<T> : 断言型接口
     *  *     boolean test(T T)
     */
    @Test
    public void test4() {
        List<String> list = Arrays.asList("Hello","dafafda","sd","daadd");
        List<String> strings = filterStr(list, (s) -> s.length() > 3);
        System.out.println(strings);
    }

    public List<String> filterStr(List<String> list, Predicate<String> predicate){
        List<String> strings = new ArrayList<>();

        for (String string : list) {
            if (predicate.test(string)) {
                strings.add(string);
            }
        }

        return strings;
    }
}
