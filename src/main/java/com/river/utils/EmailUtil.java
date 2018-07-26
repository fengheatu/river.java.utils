package com.river.utils;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

/**
 * @author he.feng
 * @2018/7/11
 * @desc
 */
public class EmailUtil {


    /**
     * 创建session
     * @return
     */
    public static Session createSession(String host,final String userName,final String password){
        Properties properties = new Properties();
        properties.setProperty("mail.host",host);
        properties.setProperty("mail.smtp.auth","true");

        //创建验证器
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName,password);
            }
        };

        return Session.getInstance(properties,authenticator);
    }


    /**
     * 发送指定的邮件
     *
     * @param mail
     */
    public static void send(Session session, final Mail mail) throws MessagingException,
            IOException {

        // 创建邮件对象
        MimeMessage msg = new MimeMessage(session);
        // 设置发件人
        msg.setFrom(new InternetAddress(mail.getFrom()));
        // 设置收件人
        msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(mail.getToAddress()));

        // 设置抄送
        String cc = mail.getCcAddress();
        if (!cc.isEmpty()) {
            msg.addRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
        }

        // 设置暗送
        String bcc = mail.getBccAddress();
        if (!bcc.isEmpty()) {
            msg.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc));
        }

        // 设置主题
        msg.setSubject(mail.getSubject());

        // 创建部件集对象
        MimeMultipart parts = new MimeMultipart();

        // 创建一个部件
        MimeBodyPart part = new MimeBodyPart();
        // 设置邮件文本内容
        part.setContent(mail.getContent(), "text/html;charset=utf-8");
        // 把部件添加到部件集中
        parts.addBodyPart(part);

        // 给邮件设置内容
        msg.setContent(parts);
        // 发邮件
        Transport.send(msg);
    }


}