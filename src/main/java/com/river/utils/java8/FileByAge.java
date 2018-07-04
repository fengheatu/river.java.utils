package com.river.utils.java8;

/**
 * @author he.feng
 * @2018/6/19
 * @desc
 */
public class FileByAge implements MyFile<Employee> {
    @Override
    public Boolean filter(Employee employee) {
        return employee.getAge() > 20;
    }
}
