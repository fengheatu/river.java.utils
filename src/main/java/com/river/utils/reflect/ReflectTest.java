package com.river.utils.reflect;

import org.junit.Test;

/**
 * @author he.feng
 * @2018/7/11
 * @desc
 */
public class ReflectTest {

    @Test
    public void test1() {
        OfficeRun officeWork = new OfficeWork();
        ClassUtil.printClassMessage(officeWork);

    }
}
