package com.app.service.Impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.app.service.AccountEmailService;
import com.app.util.AccountEmailException;

public class AccountEmailServiceImpl implements AccountEmailService{

	private JavaMailSender javaMailSender;  
    private String systemEmail;  
	public void sendMail(String to, String subject, String htmlText)
			throws AccountEmailException {
		// TODO Auto-generated method stub
		try{  
            MimeMessage msg = javaMailSender.createMimeMessage();  
            MimeMessageHelper msgHelper = new MimeMessageHelper( msg );  
  
            msgHelper.setFrom( systemEmail );       //设置发送地址  
            msgHelper.setTo( to );          //设置收件地址  
            msgHelper.setSubject( subject );        //设置主题  
            msgHelper.setText( htmlText, true );    //设置邮件内容为html格式  
  
            javaMailSender.send( msg );         //使用JavaMailSender发送邮件  
        }  
        catch ( MessagingException e ){  
            throw new AccountEmailException( "Faild to send mail.", e );  
        }  
	}
	public JavaMailSender getJavaMailSender()  
    {  
        return javaMailSender;  
    }  
  
    public void setJavaMailSender( JavaMailSender javaMailSender )  
    {  
        this.javaMailSender = javaMailSender;  
    }  
  
    public String getSystemEmail()  
    {  
        return systemEmail;  
    }  
  
    public void setSystemEmail( String systemEmail )  
    {  
        this.systemEmail = systemEmail;  
    }  

}
