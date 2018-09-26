package com.alipay.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import com.alipay.config.AlipayConfig;
import com.alipay.sign.RSA;

/* *
 *类名：AlipayNotify
 *功能：支付宝通知处理类
 *详细：处理支付宝各接口通知返回
 *版本：3.3
 *日期：2012-08-17
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考
 *class name:AlipayNotify
 *Function:The class Alipay use to handle notification
 *Detail:Handle the notification of Alipay interfaces
 *version:3.3
 *modify date:2012-08-17
 *instructions:
 *This code below is a sample demo for merchants to do test.Merchants can refer to the integration documents and write your own code to fit your website.Not necessarily to use this code.  
 *Alipay provide this code for you to study and research on Alipay interface, just for your reference.

 *************************注意*************************
 *调试通知返回时，可查看或改写log日志的写入TXT里的数据，来检查通知返回是否正常
 
 *************************Attention*************************
 *When debugging notification feedback，you can check or modify the text included into log to see whether the feedback is normal 
 */
public class AlipayNotify {

    /**
     * 支付宝消息验证地址
	 *The URL of verification of Alipay notification.
     */
	//沙箱网关异步消息验证地址
	//The verification URL of Alipay notification,sandbox environment.
	private static final String HTTPS_VERIFY_URL = "https://openapi.alipaydev.com/gateway.do?service=notify_verify&";
	//线上网关异步消息验证地址，如商户使用的生产环境，请换成下面的生产环境的地址
	//The verification URL of Alipay notification,production environment.(pls use the below line instead if you were in production environment)
    //private static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";

	
	

    /**
     * 验证消息是否是支付宝发出的合法消息
	 * Verify whether it's a legal notification sent from Alipay
     * @param params 通知返回来的参数数组The params sent back from notification
     * @return 验证结果The result of verification
     */
    public static boolean verify(Map<String, String> params) {

        //判断responsetTxt是否为true，isSign是否为true
        //responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
        //isSign不是true，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
	    //judgue whether responsetTxt and isSign is true
        //if responsetTxt is not true,the cause might be related to sever setting,merchant account and expiration time of notify_id(one minute).
        //if isSign is not true，the cause might be related to sign,charset and format of request str(eg:request with custom parameter etc.) 
    	String responseTxt = "false";
		if(params.get("notify_id") != null) {
			String notify_id = params.get("notify_id");
			responseTxt = verifyResponse(notify_id);
		}
	    String sign = "";
	    if(params.get("sign") != null) {sign = params.get("sign");}
	    boolean isSign = getSignVeryfy(params, sign);

        //写日志记录（若要调试，请取消下面两行注释）
		//write the log(pls uncomment the below two lines if you would like to debug)
        //String sWord = "responseTxt=" + responseTxt + "\n isSign=" + isSign + "\n 返回回来的参数：" + AlipayCore.createLinkString(params);
	    //AlipayCore.logResult(sWord);

        if (isSign && responseTxt.equals("true")) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean verifyReturn(Map<String, String> params) {
	    String sign = "";
	    if(params.get("sign") != null) {sign = params.get("sign");}
	    boolean isSign = getSignVeryfy(params, sign);

        //写日志记录（若要调试，请取消下面两行注释）
		//write the log(pls uncomment the below two lines if you would like to debug)
        //String sWord = "responseTxt=" + responseTxt + "\n isSign=" + isSign + "\n 返回回来的参数：" + AlipayCore.createLinkString(params);
	    //AlipayCore.logResult(sWord);

        return isSign;
    }

    /**
     * 根据反馈回来的信息，生成签名结果
	 * Generate sign from feedback
     * @param Params 通知返回来的参数数组the params from the feedback notification
     * @param sign 比对的签名结果the sign to be compared
     * @return 生成的签名结果the result of verification
     */
	private static boolean getSignVeryfy(Map<String, String> Params, String sign) {
    	//过滤空值、sign与sign_type参数
		//Filter parameters with null value ,sign and sign_type
    	Map<String, String> sParaNew = AlipayCore.paraFilter(Params);
        //获取待签名字符串
		//Generate the pre-sign string
        String preSignStr = AlipayCore.createLinkString(sParaNew);
        //获得签名验证结果
		//get the result of verification
        boolean isSign = false;
        if(AlipayConfig.sign_type.equals("RSA") ) {
        	isSign = RSA.verify(preSignStr, sign, AlipayConfig.private_key, AlipayConfig.input_charset);
        }
        return isSign;
    }

    /**
    * 获取远程服务器ATN结果,验证返回URL
	* Get the remote server ATN result,return URL
    * @param notify_id 通知校验IDThe ID for a particular notification. 
    * @return 服务器ATN结果Sever ATN result
    * 验证结果集：
	* Verification result:
    * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
	* invalid Pls check whether the partner and key are null from notification 
    * true 返回正确信息
	* true return the right info
    * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
	* false pls check the firewall or the server block certain port,also pls note the expiration time is 1 minute
    */
    private static String verifyResponse(String notify_id) {
        //获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求
		//Get the remote server ATN result,verify whether it's from Alipay

        String partner = AlipayConfig.partner;
        String veryfy_url = HTTPS_VERIFY_URL + "partner=" + partner + "&notify_id=" + notify_id;

        return checkUrl(veryfy_url);
    }

    /**
    * 获取远程服务器ATN结果
	* Get the remote server ATN result
    * @param urlvalue 指定URL路径地址specified URL value
    * @return 服务器ATN结果Sever ATN result
    * 验证结果集：
	* Verification result:
    * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
	* invalid Pls check whether the partner and key are null from notification 
    * true 返回正确信息
	* true return the right info
    * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
	* false pls check the firewall or the server block certain port,also pls note the expiration time is 1 minute
    */
    private static String checkUrl(String urlvalue) {
        String inputLine = "";

        try {
            URL url = new URL(urlvalue);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection
                .getInputStream()));
            inputLine = in.readLine().toString();
        } catch (Exception e) {
            e.printStackTrace();
            inputLine = "";
        }

        return inputLine;
    }
}
