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
<title>My JSP 'publishUI.jsp' starting page</title>
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
	<form action="advertisement_modify.action" method="post"
		enctype="multipart/form-data" id="advertisement_updateform">
		<table style="position: absolute; top:50px;">
			<input type="hidden" value="${advertisement.vadid}" name="vadid" />
			<tr>
				<th>广告名：</th>
				<td><input name="vadname" value="${advertisement.vadname}"
					class="easyui-validatebox" data-options="required:true"></td>
			</tr>
			<tr>
				<th>原有图片：</th>
				<td><img
					src="${pageContext.request.contextPath}/${advertisement.vpath }" /></td>
			</tr>
			<tr>
				<th>若您无需更改图片，则不需要选择文件：</th>
				<td><input type="file" name="upload"></td>
			</tr>
			<tr>
				<th>图片链接：</th>
				<td><input name="vhrefpath" value="${advertisement.vhrefpath}"
					class="easyui-validatebox"
					data-options="required:true,validType:'url'"></td>
			</tr>
		</table>
	</form>

</body>
</html>
