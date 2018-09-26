
package com.alipay.util;

import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

/* *
 *类名：UtilDate
 *功能：自定义订单类
 *详细：工具类，可以用作获取系统日期、订单编号等
 *版本：3.3
 *日期：2012-08-17
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 *File name:UtilDate
 *Function:custom order file
 *Detail:This can be used as a tool to get order time and trade number etc.
 *version:3.3
 *modify date:2012-08-17
 *instructions:
 *This code below is a sample demo for merchants to do test.Merchants can refer to the integration documents and write your own code to fit your website.Not necessarily to use this code.  
 *Alipay provide this code for you to study and research on Alipay interface, just for your reference.
 */
public class UtilDate {
	
    /** 年月日时分秒(无下划线)Year month day hour minutes seconds yyyyMMddHHmmss */
    public static final String dtLong                  = "yyyyMMddHHmmss";
    
    /** 完整时间Full time yyyy-MM-dd HH:mm:ss */
    public static final String simple                  = "yyyy-MM-dd HH:mm:ss";
    
    /** 年月日(无下划线)Year month day yyyyMMdd */
    public static final String dtShort                 = "yyyyMMdd";
	
    
    /**
     * 返回系统当前时间(精确到毫秒),作为一个唯一的订单编号
	 * Return the current time of your system(accurate to seconds),as the unique transaction ID 
     * @return
     *      以yyyyMMddHHmmss为格式的当前系统时间
	 *      the current system time in the format of yyyyMMddHHmmss
     */
	public  static String getOrderNum(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat(dtLong);
		return df.format(date);
	}
	
	/**
	 * 获取系统当前日期(精确到毫秒)，格式：yyyy-MM-dd HH:mm:ss
	 * get the current system time(accurate to seconds),format:yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public  static String getDateFormatter(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat(simple);
		return df.format(date);
	}
	
	/**
	 * 获取系统当期年月日(精确到天)，格式：yyyyMMdd
	 * get the current system time(accurate to day),format:yyyyMMdd
	 * @return
	 */
	public static String getDate(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat(dtShort);
		return df.format(date);
	}
	
	/**
	 * 产生随机的三位数
	 * Generate random three-digit number
	 * @return
	 */
	public static String getThree(){
		Random rad=new Random();
		return rad.nextInt(1000)+"";
	}
	
}
