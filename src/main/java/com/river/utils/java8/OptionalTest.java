package com.river.utils.java8;

import org.junit.Test;

import java.util.Optional;

/**
 * @author he.feng
 * @2018/6/20
 * @desc
 */
public class OptionalTest {

    @Test
    public void test1() {
        Optional<Employee> optional = Optional.of(new Employee());

        Employee employee = optional.get();
        System.out.println(employee);

        Optional<Employee> optional1 = Optional.empty();
        System.out.println(optional.get());
    }
}
