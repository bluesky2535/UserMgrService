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

<title>My JSP 'modifyUI.jsp' starting page</title>

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
	<form action="appuser_modify.action" method="post" id="appuser_updateform">
    ID:	<input value="${appUser.vauid }" name="vauid" readonly="readonly" ><br>
	姓名：<input value="${appUser.vname }" name="vname"><br>
	密码：<input value="${appUser.vpassword }" name="vpassword"><br>
	电话：<input value="${appUser.vtel }" name="vtel"><br>
	积分：<input value="${appUser.dpoint }" name="dpoint"><br>
	卡号：<input value="${appUser.vcard }" name="vcard"><br>
	地址一：<input value="${appUser.vaddress1 }" name="vaddress1"><br>
	地址二：<input value="${appUser.vaddress2 }" name="vaddress2"><br>
	地址三：<input value="${appUser.vaddress3 }" name="vaddress3"><br>
	地址四：<input value="${appUser.vaddress4 }" name="vaddress4"><br>
	地址五：<input value="${appUser.vaddress5 }" name="vaddress5"><br>
	地址六：<input value="${appUser.vaddress6 }" name="vaddress6"><br>
	</form>
	<br>
</body>
</html>
