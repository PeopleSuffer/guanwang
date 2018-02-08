package com.app.util;

import java.io.InputStreamReader;
import java.util.Properties;

public class Application {

    
    public static String mwyRequestPath = get("mwyRequestPath");	//梦网云请求路径
    public static String mwyUserId = get("mwyUserId");				//梦网云用户名
    public static String mwyPassword = get("mwyPassword");			//梦网云密码
    public static String mwyIpAddress1 = get("mwyIpAddress1");		//主IP信息
    public static String mwyIpAddress2 = get("mwyIpAddress2");		//备用IP1
    public static String mwyIpAddress3 = get("mwyIpAddress3");		//备用IP2
    public static String mwyIpAddress4 = get("mwyIpAddress4");		//备用IP3
    
    public static String serverUrl = get("serverUrl");//服务器地址
    
    public static String wxAPPID = get("wxAPPID"); //微信appid
    public static String wxAPPSECRET = get("wxAPPSECRET");	//微信appsecret
    public static String wxBackUrl = get("wxBackUrl");		//微信回调地址
    private static Properties props;

    private static String get(String key) {
        if (props == null) {
            try {
                props = new Properties();
                InputStreamReader inputStream = new InputStreamReader(Application.class.getClassLoader().getResourceAsStream("application.properties"),
                                                                      "UTF-8");
                props.load(inputStream);
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return props.getProperty(key);
    }

}
