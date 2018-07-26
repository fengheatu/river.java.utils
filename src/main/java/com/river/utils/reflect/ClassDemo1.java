package com.river.utils.reflect;

/**
 * @author he.feng
 * @2018/7/11
 * @desc
 */
public class ClassDemo1 {

    public static void main(String[] args) throws Exception {

        //任何一个类都是Class的实例对象，这个实例对象有三种表示方式

        //第一种 ->>实际在告诉我们任何一个类都有一个隐含的静态成员变量class
        Class c1 = Foo.class;

        //第二种
        Foo foo = new Foo();
        Class c2 = foo.getClass();

        System.out.println(c1 == c2);

        //第三种
        Class c3  = Class.forName("com.river.utils.reflect.Foo");
        System.out.println(c3 == c2);

        Foo foo1 = (Foo) c3.newInstance();
        foo1.print();
    }


}

class Foo{

    public void print() {
        System.out.println("adadfsafaf");
    }
}
