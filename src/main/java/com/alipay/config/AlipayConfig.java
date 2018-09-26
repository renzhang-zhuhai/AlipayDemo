package com.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.4
 *修改日期：2016-03-08
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 *configuration file for basic configuration
 *version:3.4
 *modify date:2016-03-08
 *instructions
 *This code below is a sample demo for merchants to do test.Merchants can refer to the integration documents and write your own code to fit your website.Not necessarily to use this code.  
 *Alipay provide this code for you to study and research on Alipay interface, just for your reference.
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
//↓↓↓↓↓↓↓↓↓↓Please configure your basic information here↓↓↓↓↓↓↓↓↓↓

	// 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://globalprod.alipay.com/order/myOrder.htm
	// 下面的值默认是一个沙箱测试账号，您可参考下面网址申请自己的沙箱测试账号：https://global.alipay.com/help/integration/23
    //partner ID,It's a 16-bit string start with "2088".Login in https://globalprod.alipay.com/order/myOrder.htm to see your partner ID.
   //Below is a default pid of sandbox account for your reference,pls apply your own sandbox account here:https://global.alipay.com/help/integration/23
     
	// 商户的私钥
	// merchant's private key
	public static String partner = "2088621891276675";//Cross-border Online Payment(PC) --ok
	

	  
	public static String private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQC8gZtwHZUoP7XCh4JpdqmpyNStUhVs/u3527LcBVLwHLbizlyN8GOOuMBYvgQdMXfvmhqk6BZI8z6Os/JYDjFnp3cBf0NbKb12w/3GNGaIWF0LKSCwmyUVnVyR2XAOU5WR9PhU7Gc7dAJB9YnFXSJfbLu3ljC30mdaI7oyDWtFJXTIR1sNZycNEJIiKAIvzF14UlfGIFTtIwOmE5UxtT/HWwTS8twe7rTylwnxrbJ3BY4Ekz4hbkt6gSFC0wsG0SigK0dF2Vx1Muo49Ben3q04n6feb7RRzMZj6kVJHP/nnH4t9uKHckH3uXMOUH20kLs1CYEgo/OLZ5iVzYwUCIjBAgMBAAECggEBAJxt7YCHfAyvefTZIPbF2xujJiJCWLdfgjpy/6Un4eCR446pcxLyppt8Y1oBLUbQk1fJCU1Jr5yQBpzDZVt/Q65hwRcD9fBD3g8dq418VI3WzjeBxLfpt0eNk5EQ4LVy1U8O+7j1iOFEbs8vpEmc9PY9NDWwM/OHbe7WcSAyFI+GjcnGUAz8Pw/hCm10BnEUy9MrIOfyQTIT/DCy/aN78L1sSSlCnj3nBIiPRVdm7uSKlnFB/iYnvdJ9qOcclC80/M3mL3zuLUJmMepz8BujzFhui+6e2+CQ1R1gr8DVmrmCnRpuS7SX2wxbfD9Igr+8PIcZh3Vxk9hG/7X8XZU0xZUCgYEA5UeotTLBy48RgA8oG6USb10AqfDBSexjaPATztEhzwxKWS7CXlZHomfZcJnBdI2vkR4nApaWbujXi68F7v+bogIoucM+m9YisJqd3QCKWDUeXnYya6ryYDkHng5CGNea4SUZ+It1yOHqpG8R3GmzwfGgCJwOYiOrVIxQg0sYT8sCgYEA0nmBtrHpzeUXsUJieV9aa/7m63p18owsnd3BTx0oL6qXAYVz269U3AZ/fjBzqoD+iIQKaSd8DFOzFhM1S/xlWJYUE2aR8viplC1JAQaOXfJj5epZ/sjh+ED9wHoNUFj04xPG6q1CvR8sMKU873CcMTYXJO7BKOp5Lw1yYRks4CMCgYARRaGu7MDunbt6wymJU5kc7IulQa696+HdQOCtHtIGL+3V5BDeXG+PC3W05tBNAHNuYjAcIM36Uu4R5sByrazCupjozY2E3c/FMBCeWnERjgbYpNzNgZY6q3EodfiCuJNBTLM1JwRberFba8aTrR7OiG4+18q5l+hLOTrDeT++mwKBgQDAvzd0CNA1lxQwZ7vorNMQzZnJkhdLrOT7GWZ7PhdcN5wcb4tfZtyOtoCxHkv+nCz89fbWv6sRWuFJWQPY92YUTzRJZAhKe0BJC4OspcVg8aZcmlYaRvrxrwry5pMkvqJdBfKHXW4d5dtBHUGFgRn40zE0yFUqVDfwSB80HqsDAwKBgQCHGfNqoilQeYfSX9hXgN0hTMidEX2znNbZ1Pc64lx1uXRTGppX95Qt6mrTbUo7zkoXkMlgWVMHG3NJerjyUMHYzB0OF6aDrn75SaF6p5j1rHX4/FXJHBvFxD6qB+IGASIbrsiGkB6p8t+Q6O8rS7MRjLbkirLHrWF/eSbZV/0ivg==";
	//

    //Alipay's public key,below is Alipay's public key of sandbox environment
	//Pls use the Alipay's public key of production environment instead if you are in production environment
	//public static String ali_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
	
	
	

	// 服务器异步通知页面路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//Page for receiving asynchronous Notification. It should be accessable from outer net.No custom parameters like '?id=123' permitted.
	//public static String notify_url = "http://MerchantSite/create_forex_trade-JAVA-UTF-8-RSA-new/notify_url.jsp";
	  public static String notify_url = "https://8step.name/alipay/notify/";//test
	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //Page for synchronous notification.It should be accessable from outer net.No custom parameters like '?id=123' permitted.
	//public static String return_url = "http://www.alipay.com";
	public static String return_url = "https://8step.name/en/payment/success/?return=66bad2e3-0ed4-4546-a25b-40a8f4f66954";//test
	// 签名方式
	//sign_type
	public static String sign_type = "RSA";
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	//Create a TXT log folder path,pls refer to the logResult(String sWord) function in the AlipayCore.java file.
	public static String log_path = "C:\\";
		
	// 字符编码格式 目前支持 gbk 或 utf-8
	// input_charset   gbk and utf-8 are supported now.
	public static String input_charset = "utf-8";
		

	// 调用的接口名，无需修改
	//Service name of the interface.No need to modify.
	public static String service = "create_forex_trade";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
//↑↑↑↑↑↑↑↑↑↑Please configure your basic information here↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑		
}

