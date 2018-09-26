/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2005 All Rights Reserved.
 */
package com.alipay.util.httpClient;

/* *
 *类名：HttpResultType
 *功能：表示Http返回的结果字符方式
 *详细：表示Http返回的结果字符方式
 *版本：3.3
 *日期：2012-08-17
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 *File name:HttpResultType
 *Function:represent the format of http return
 *Detail:represent the format of http return
 *version:3.3
 *modify date:2012-08-17
 *instructions:
 *This code below is a sample demo for merchants to do test.Merchants can refer to the integration documents and write your own code to fit your website.Not necessarily to use this code.  
 *Alipay provide this code for you to study and research on Alipay interface, just for your reference.
 */
public enum HttpResultType {
    /**
     * 字符串方式
	 * String format
     */
    STRING,

    /**
     * 字节数组方式
	 * Bytes format
     */
    BYTES
}
