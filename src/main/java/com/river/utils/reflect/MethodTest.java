package com.river.utils.reflect;

import java.lang.reflect.Method;

/**
 * @author he.feng
 * @2018/7/11
 * @desc
 */
public class MethodTest {

    public static void main(String[] args) throws Exception {
        A a = new A();
        Class c = a.getClass();

        Method m = c.getMethod("print",new Class[]{int.class,int.class});
        Object o = m.invoke(a, new Object[]{20,10});
    }

}


class A {
    public void print(int a,int b) {
        System.out.println(a + b);
    }
}