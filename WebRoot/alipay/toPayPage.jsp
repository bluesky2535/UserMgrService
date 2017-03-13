<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'toPayPage.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
		 <form id="alipaysubmit" name="alipaysubmit"
		action="https://mapi.alipay.com/gateway.do?_input_charset=utf-8"
		method="get">
		<input type="hidden" name="sign"/>
		<input type="hidden" name="_input_charset"       />
			<input type="hidden" name="subject"        />
			<input type="hidden" name="total_fee"     />
			<input type="hidden" name="sign_type"  />
			<input type="hidden" name="service"  />
			<input type="hidden"name="notify_url" />
			<input type="hidden" name="partner"  />
			<input type="hidden" name="seller_id"  />
			<input type="hidden" name="out_trade_no"  />
			<input type="hidden" name="payment_type"  />
			<input type="hidden" name="return_url"  />
			<input type="submit" value="确认" style="display:none;">
	</form> 
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script>
		$(function() {
			var i = JSON.stringify(${payjson});
			var obj = jQuery.parseJSON(i);
			console.log(obj.subject);
			$("input[name='sign']").attr("value", obj.sign);
			$("input[name='_input_charset']").attr("value", obj._input_charset);
			$("input[name='subject']").attr("value", obj.subject);
			$("input[name='total_fee']").attr("value", obj.total_fee);
			$("input[name='sign_type']").attr("value", obj.sign_type);
			$("input[name='service']").attr("value", obj.service);
			$("input[name='notify_url']").attr("value", obj.notify_url);
			$("input[name='partner']").attr("value", obj.partner);
			$("input[name='seller_id']").attr("value", obj.seller_id);
			$("input[name='out_trade_no']").attr("value", obj.out_trade_no);
			$("input[name='payment_type']").attr("value", obj.payment_type);
			$("input[name='return_url']").attr("value", obj.return_url);
			document.forms['alipaysubmit'].submit();
		});

		/* $("input[name='sign']").attr("value", "m8a1S90Nkfsy48DTdI2S20ZDJyfLWu6OP0zJEP4EbZY9TH+qq/UyHrbNsPOeG3R2VWj9JMOV5PhRzMyPZPMWSpK5bcuK5j+epG6N6Pi2/WxwccfFEj6/kBRCzAq13rITKBbgS2QfpZ/WQ1O9CVr2c22bxmGZxvwpHFluD0dKOXw=");
			document.forms['alipaysubmit'].submit(); */
	</script>
</body>
</html>
