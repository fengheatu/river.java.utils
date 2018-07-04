package com.river.utils.java8;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author he.feng
 * @2018/6/19
 * @desc
 */
public class LambdaTest2 {

    @Test
    public void test1() {
        Runnable runnable = () -> System.out.println("aaaaaaaaaaaa");
        runnable.run();
    }


    @Test
    public void test2() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("小菜鸡");
    }

    @Test
    public void test3() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("函数式接口");
            return x.compareTo(y);
        };

        System.out.println(comparator.compare(2,4));
    }
    @Test
    public  void test4() {
        System.out.println(operation(200,(x) -> x * x));
    }

    public Integer operation(Integer num,MyOperation myOperation) {
        return myOperation.getValue(num);
    }


    @Test
    public void test5() {
        String s = strHandler("asfjkdasfasjfasdfa", (str -> StringUtils.upperCase(str)));
        System.out.println(s);
    }

    public String strHandler(String str,UpperStr upperStr) {
        return upperStr.getValues(str);
    }
}
