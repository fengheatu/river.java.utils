package com.river.utils;

import org.junit.Test;

/**
 * @author he.feng
 * @2018/5/23
 * @desc
 */
public class TestUtil {

    @Test
    public void fun() {
        QRCodeUtil.createQRCodeToPath(null,null,null,"https://www.baidu.com","D:");
    }
}
