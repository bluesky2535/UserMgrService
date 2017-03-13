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

	<form action="announce_publish.action" method="post"
		enctype="multipart/form-data" id="announce_publishform">
		<table style="position: absolute; left:60px">
			<tr>
				<th>标题：</th>
				<td><input name="vtitlename" class="easyui-validatebox"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<th>公告图片：</th>
				<td><input type="file" name="upload" class="easyui-validatebox"
					data-options="required:true"></td>
			</tr>
			<tr>
				<th>公告文本：</th>
				<td><textarea rows="5" cols="5" name="vtext"
						class="easyui-validatebox" data-options="required:true"></textarea>
				</td>
			</tr>
			<tr>
				<th>公告级别：</th>
				<td><select name="grade" class="easyui-validatebox"
					data-options="required:true"><option value="0">普通</option>
						<option value="1">重要</option></select></td>
			</tr>
		</table>

	</form>

</body>
</html>
