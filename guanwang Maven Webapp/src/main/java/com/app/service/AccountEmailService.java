package com.app.service;

import com.app.util.AccountEmailException;

public interface AccountEmailService {
	 //根据接收地址，邮件主题，邮件内容发送HTML格式的邮件  
    void sendMail( String to, String subject, String htmlText ) throws AccountEmailException;  
}
