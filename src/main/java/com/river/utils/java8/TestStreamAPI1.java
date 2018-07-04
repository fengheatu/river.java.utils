package com.river.utils.java8;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author he.feng
 * @2018/6/20
 * @desc
 */
public class TestStreamAPI1 {

    private static List<Employee> employees = new ArrayList<>();

    @Before
    public void before() {
        employees.add(new Employee("zhangsan", 22, 7777.0));
        employees.add(new Employee("lisi", 35, 8888.0));
        employees.add(new Employee("wangwu", 22, 7777.0));
    }


    /**
     * 创建Stream
     */
    @Test
    public void test1() {
        //1、可以通过Collection 系列集合提供的stream 或者 parallelStream()

        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2通过Arrays中的静态方法stream() 获取

        String[] strings = {};
        Stream<String> stream1 = Arrays.stream(strings);

        //3通过Stream 类中的of() 方法

        Stream<String> stream2 = Stream.of("aaa", "bbbb", "cccc");

        //4创建无线流
        //迭代
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2);
        stream3.limit(10).forEach(System.out::println);
    }


    /**
     * 中间操作
     * filter  过滤
     * limit   切片
     * skip(n) 跳过
     * distinct 帅选 去除重复元素，，，
     */
    @Test
    public void test2() {
        Stream<Employee> stream = employees.stream()
                .filter((e) -> {
                    System.out.println("中间操作");
                    return e.getAge() > 18;
                });

        stream.forEach(System.out::println);

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("----------------------------------");

        List<String> list = Arrays.asList("aaa","bbbbb","cccc");
        list.stream().map((e) -> e.toUpperCase()).forEach(System.out::println);

        System.out.println("----------------------------------");
        Stream<Character> sm = list.stream().flatMap((e) -> filterCharacter(e));
        sm.forEach(System.out::println);


    }

    public Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for(Character character : str.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }

    /**
     * 排序
     * sorted()  自然排序（comparable)
     * sorted(compatator com)
     */
    @Test
    public void test3() {
        Stream<Employee> stream = employees.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge().equals(e2.getAge())) {
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        return e1.getAge().compareTo(e2.getAge());
                    }
                });
        List<Employee> collect = stream.collect(Collectors.toList());
        System.out.println(collect);
    }


    /**
     * 查找与匹配
     * allMatch -- 检查是否匹配所有元素
     * anyMatch -- 检查是否至少匹配一个元素
     * noneMatch -- 检查是否没有匹配所有元素
     * findFirst -- 返回第一个元素
     * findAny -- 返回当前流中的任意元素
     * count -- 返回流中元素的总个数
     * max
     * min
     *
     */
    @Test
    public void test4() {

    }


    /**
     * 规约：
     * reduce(T identity,BinaryOperator) -- 可以将流中元素反复结合起来，得到一个新值
     */
    @Test
    public void test5() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        Integer sum = list.stream().reduce(0,(x,y) -> x + y);
        System.out.println(sum);
    }


    /**
     * 收集：
     * collect -- 将流转换成其他形式
     */
    @Test
    public void test6() {
        HashSet<String> collect = employees.stream()
                .map(Employee::getName)
                .limit(2)
                .collect(Collectors.toCollection(HashSet::new));

        System.out.println(collect);
    }


    /**
     * 汇总
     */
    @Test
    public void test7() {
        Long count = employees.stream()
                .collect(Collectors.counting());
        System.out.println(count);

        System.out.println("-----------------------------");

        Double avg = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));

        System.out.println(avg);

        System.out.println("-----------------------------");

        Double sum = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);

        System.out.println("-----------------------------");

        Optional<Employee> max = employees.stream()
                .collect(Collectors.maxBy((x, y) -> Double.compare(x.getSalary(), y.getSalary())));

        System.out.println(max.get());
        System.out.println("-----------------------------");

        Optional<Double> min = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());
    }

    /**
     * 分组
     */
    @Test
    public void test8() {
        Map<Integer, List<Employee>> listMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge));
        System.out.println(listMap);
    }


    /**
     * 分区
     */
    @Test
    public void test9() {
        Map<Boolean, List<Employee>> collect = employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000));
        System.out.println(collect);
    }

    /**
     * 收集
     */
    @Test
    public void test10() {
        DoubleSummaryStatistics collect = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println(collect.getAverage());
        System.out.println(collect.getCount());
        System.out.println(collect.getMax());
        System.out.println(collect.getMin());
        System.out.println(collect.getSum());
    }

    /**
     *连接
     */
    @Test
    public void test11() {
        String collect = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(collect);

    }
}
