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

<title>My JSP 'registuser.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body>
	<div>
		<form action="sysuser_regist.action" method="post"
			id="sysuser_registform">
			<table style="position:absolute;top:50px;left:50px">
				<tr style="height:50px">
					<th>用户名：</th>
					<td><input type="text" name="vsuname"
						class="easyui-validatebox" data-options="required:true" value="" /></td>
				</tr>
				<tr>
					<th>密码：</th>
					<td><input type="password" name="vpassword"
						class="easyui-validatebox" data-options="required:true" value="" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
