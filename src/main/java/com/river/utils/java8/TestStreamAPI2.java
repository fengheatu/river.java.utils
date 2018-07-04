package com.river.utils.java8;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author he.feng
 * @2018/6/20
 * @desc
 */
public class TestStreamAPI2 {

    private static List<Employee> employees = new ArrayList<>();

    @Before
    public void before() {
        employees.add(new Employee("zhangsan", 22, 7777.0));
        employees.add(new Employee("lisi", 35, 8888.0));
        employees.add(new Employee("wangwu", 22, 7777.0));
    }

    /**
     * 1、给定一个数字列表，如何返回一个有每个数平方构成的列表呢
     */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        List<Integer> collect = list.stream()
                .map((x) -> x * x)
                .collect(Collectors.toList());
        System.out.println(collect);
    }


    /**
     * 怎样用map和reduce 方法数一数流中有多少个Employee
     */
    @Test
    public void test2() {
        Integer reduce = employees.stream()
                .map((e) -> 1)
                .reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}
