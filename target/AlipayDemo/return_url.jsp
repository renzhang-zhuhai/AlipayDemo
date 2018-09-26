<%
/* *
 功能：支付宝页面跳转同步通知页面
 版本：3.2
 日期：2011-03-17
 说明：
 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

 //***********页面功能说明***********
 该页面可在本机电脑测试
 可放入HTML等美化页面的代码、商户业务逻辑程序代码
 TRADE_FINISHED(表示交易已经成功结束，并不能再对该交易做后续操作);
 TRADE_CLOSED(在指定时间段内未完成付款时关闭的交易；在交易完成全额退款成功时的交易);
 *function:The sync notification page Alipay page redirect to
 *version: 3.2
 *date: 2011-03-17
 *instruction:
 *This code below is a sample demo for merchants to do test.Merchants can refer to the integration documents and write your own code to fit your website.Not necessarily to use this code.  
 *Alipay provide this code for you to study and research on Alipay interface, just for your reference.

  *************************function description*************************
 * This page can be tested locally.
 * You can add HTML code and so forth to beautify the page.You can add program code of your business logic  too.
 TRADE_FINISHED(The payment has been made succeed.No more opperations can be done on this transanction);
 TRADE_CLOSED(Transaction closed without payment;transanction full refunded after transanction succeed. );
 //********************************
 * */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.alipay.util.*"%>
<%@ page import="com.alipay.config.*"%>
<html>
  <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>The sync notification page Alipay page redirect to</title>
		<!--Alipay page forwarding sync notification page-->
  </head>
  <body>
<%
	//获取支付宝GET过来的反馈信息
	//Get the response message from Alipay servers.
	Map<String,String> params = new HashMap<String,String>();
	Map requestParams = request.getParameterMap();
	for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
		String name = (String) iter.next();
		String[] values = (String[]) requestParams.get(name);
		String valueStr = "";
		for (int i = 0; i < values.length; i++) {
			valueStr = (i == values.length - 1) ? valueStr + values[i]
					: valueStr + values[i] + ",";
		}
		//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
		//Use below code to solve garbled words issue.If mysign is not equal to sign,you can also try to use this code to transform
		valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
		params.put(name, valueStr.replace(' ', '+'));//解决加号变空格的问题（sync verification,the code used for resolving the issue "The RSA signature returned is not urlencoded"）
		//params.put(name, valueStr);
	}
	
	//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
	//Get the returned parameters from notification.You can refer to alipay's notification parameters list in integration documents.
	//商户订单号

	//out_trade_no
	String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

	//支付宝交易号

	//trade_no
	String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

	//交易状态
	//trade_status
	String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

	//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
	//Get the returned parameters from notification.You can refer to alipay's notification parameters list in integration documents.
	
	//计算得出通知验证结果
	//Calculate and get results of notification verification
	boolean verify_result = AlipayNotify.verifyReturn(params);
	
	if(verify_result){//验证成功verification has succeeded
		//////////////////////////////////////////////////////////////////////////////////////////
		//请在这里加上商户的业务逻辑程序代码
		//Please add yourprogram code here according to your business logic.
		//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
		//——Please write program according to your business logic.(The below code is for your reference.)
		if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
			//判断该笔订单是否在商户网站中已经做过处理
			//Check whether the order has been processed in the partner's website.
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
			//If it has not been processed,query the detail of the order in order system of your website according to the order number (out_trade_no) and perform program code of your business logic.
				//如果有做过处理，不执行商户的业务程序
			//If the order has been processed in the partner's website,do not perform your program code of business logic.
		}
		
		//该页面可做页面美工编辑This page can be beautified with editor.
		out.println("success<br />");
		//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
		//Please write program according to your business logic.(The above code is only for reference.)  
		//////////////////////////////////////////////////////////////////////////////////////////
	}else{
		//该页面可做页面美工编辑This page can be beautified with editor.
		out.println("fail");
	}
%>
  </body>
</html>