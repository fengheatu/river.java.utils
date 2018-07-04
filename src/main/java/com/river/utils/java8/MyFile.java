package com.river.utils.java8;

/**
 * @author he.feng
 * @2018/6/19
 * @desc
 */
@FunctionalInterface
public interface MyFile<T> {

    Boolean filter(T t);
}
