package com.river.utils.java8;

/**
 * @author he.feng
 * @2018/6/15
 * @desc
 */
public interface Person {

    default String getName(String name) {
        return name;
    }
}
