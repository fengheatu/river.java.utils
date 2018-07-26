package com.river.utils.reflect;

import org.junit.Test;

/**
 * @author he.feng
 * @2018/7/11
 * @desc
 */
public class OfficeTest {

    public static void run(String name) throws Exception {
        Class c1 = Class.forName(name);
        OfficeRun officeRun = (OfficeRun) c1.newInstance();
        officeRun.run();
    }

    @Test
    public void test1() throws Exception {
        run("com.river.utils.reflect.OfficeWork");
        run("com.river.utils.reflect.OfficeExcel");
    }
}
