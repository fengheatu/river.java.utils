package com.river.utils.java8;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @author he.feng
 * @2018/6/19
 * @desc
 */
public class LambdaTest {

    private  static List<Employee> employees = new ArrayList<>();

    @Before
    public void before() {
        employees.add(new Employee("zhangsan",22,7777.0));
        employees.add(new Employee("lisi",35,8888.0));
        employees.add(new Employee("wangwu",22,7777.0));
    }

    public static List<Employee> filterEmployee(List<Employee> employees,MyFile<Employee> myFile) {
        List<Employee> newList = new ArrayList<>();
        for (Employee employee : employees) {
            if(myFile.filter(employee)) {
                newList.add(employee);
            }
        }
        return  newList;
    }

    @Test
    public void test1() {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(comparator);
    }

    @Test
    public void test2() {
        Comparator<Integer> com  = (x,y) -> Integer.compare(x,y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    @Test
    public void test3() {
        List<Employee> list = filterEmployee(employees,(e) -> e.getAge() > 30);
        list.forEach(System.out::println);
    }

    @Test
    public void test4() {
        List<Employee> list =  filterEmployee(employees, new MyFile<Employee>() {
            @Override
            public Boolean filter(Employee employee) {
                return employee.getAge() > 30;
            }
        });

        for(Employee employee : list) {
            System.out.println(employee);
        }
    }


    @Test
    public void test5() {
        employees.stream()
                .filter((e) -> e.getAge() > 30)
                .forEach(System.out::println);
    }

    @Test
    public void test6()  {
        employees.stream().map(Employee::getName)
        .forEach(System.out::println);
    }

    @Test
    public void test7() {
        Collections.sort(employees,(e1,e2) -> {
            if(e1.getAge().equals(e2.getAge())) {
                return e1.getName().compareTo(e2.getName());
            }else {
                return -e1.getAge().compareTo(e2.getAge());
            }
        });

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

}
