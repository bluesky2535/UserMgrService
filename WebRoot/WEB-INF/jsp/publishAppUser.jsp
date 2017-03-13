<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'registuser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>

    <form action="appuser_regist.action" method="post" id="appuser_registform">
   用户名： <input type="text"  name="vname" /><br>
   密码：    <input type="password"  name="vpassword"/><br>
   电话：   <input type="text"  name="vtel"/><br>
  积分：   <input type="text"  name="dpoint"/><br>
 地址一：   <input type="text"  name="vaddress1"/><br>
  地址二：  <input type="text"  name="vaddress2"/><br>
 地址三：   <input type="text"  name="vaddress3"/><br>
  地址四：  <input type="text"  name="vaddress4"/><br>
  地址五：  <input type="text"  name="vaddress5"/><br>
  地址六：  <input type="text"  name="vaddress6"/><br>
    </form>
  </body>
</html>
