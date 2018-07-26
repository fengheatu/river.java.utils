package com.river.utils;

import org.junit.Test;

import javax.mail.Session;
import java.rmi.server.ExportException;

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




    @Test
    public void fun2() throws Exception {
        Session session = EmailUtil.createSession("smtp.163.com", "fengheatu", "0809177River");
        Mail mail = new Mail();
        mail.setFrom("fengheatu@163.com");
        mail.addToAddress("771331349@qq.com");
        mail.addToAddress("he.feng@pangmaobao.com");
        mail.setSubject("你个菜鸡");
        mail.setContent("你个小菜鸡");
        EmailUtil.send(session,mail);
    }
}
