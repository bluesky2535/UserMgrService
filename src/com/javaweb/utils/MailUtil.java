package com.javaweb.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送工具类
 * @author 
 *
 */
public class MailUtil {
	/**
	 * 发送邮件的方法
	 * @param to	:收件人
	 * @param code	:激活码
	 */
	public static void sendMail(String to,String code){
		/**
		 * 1.获得一个Session对象.
		 * 2.创建一个代表邮件的对象Message.
		 * 3.发送邮件Transport
		 */
		// 1.获得连接对象
		Properties props = new Properties();
		 props.setProperty("mail.smtp.auth", "true");
         props.setProperty("mail.host", "smtp.sina.cn");
         props.setProperty("mail.transport.protocol", "smtp");
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("18829289434@sina.cn", "1234567890");
			}
			
		});
		// 2.创建邮件对象:
		Message message = new MimeMessage(session);
		// 设置发件人:
		try {
			message.setFrom(new InternetAddress("18829289434@sina.cn"));
			// 设置收件人:
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			// 抄送 CC   密送BCC
			// 设置标题
			message.setSubject("来自开心网官方激活邮件");
			// 设置邮件正文:
			
			message.setContent("<h1>开心官方激活邮件!点下面链接完成激活操作!</h1><h3><a href='http://222.24.59.141:9999/HappyNet/user_active?activecode="+code+"'>点击即可激活账户激活码为："+code+"</a></h3>", "text/html;charset=UTF-8");
			// 3.发送邮件:
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		sendMail("1161936195@qq.com","11111111111111");
	}
}
