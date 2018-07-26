package com.river.utils.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author he.feng
 * @2018/7/11
 * @desc
 */
public class ClassUtil {


    public static void printClassMessage(Object obj) {
        //要获取类的信息，首先要获取类的类类型
        //传递的是哪个子类的对象，c 就是该子类的类类型
        Class c = obj.getClass();

        //获取类的名称
        System.out.println("类的名称：" + c.getName());
        System.out.println("类的名称：" + c.getSimpleName());


        /**
         * Method类 方法对象
         *
         * 一个成员方法就是一个Method对象
         * getMethod()    public 级别方法
         * getDeclaredMethod()   所有自己声明的方法
         */

        Method[] methods = c.getDeclaredMethods();
        for(Method method :methods){

            //得到返回值类型
            Class returnType = method.getReturnType();
            System.out.print(returnType.getName() + " ");
            //获得方法名
            System.out.print(method.getName() + " ");

            //获取参数类型
            Class[] paramType = method.getParameterTypes();
            for(Class cl : paramType) {
                System.out.print(cl.getName() + " ");
            }
            System.out.println();
        }


        //获取成员变量的类类型
        Field[] fs = c.getDeclaredFields();
        for(Field field : fs) {
            //得到成员变量的类类型
            Class fieldType = field.getType();
            String typeName = fieldType.getTypeName();
            //得到成员变量的名称
            String fieldNmae = field.getName();
            System.out.println(typeName + " " + fieldNmae);
        }


        //获取构造函数的信息
        /**
         * getConstructors()  public 级别
         * getDeclaredConstructors() 得到所有的构造函数
         */

        Constructor[] constructors = c.getDeclaredConstructors();
        for(Constructor constructor : constructors) {
            System.out.println(constructor.getName() + "(");
            Class[] paramTypes = constructor.getParameterTypes();
            for(Class c2 : paramTypes) {
                System.out.print(c2.getName()+ ",");
            }
            System.out.println(")");
        }

    }

}
