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

	<form action="announce_modify.action" method="post"
		enctype="multipart/form-data" id="announce_updateform">
		<input name="vanid" value="${announce.vanid}" type="hidden" />
		<table style="position:relative; top:50px;left:50px">

			<tr>
				<th>标题：</th>
				<td><input name="vtitlename" value="${announce.vtitlename }"
					class="easyui-validatebox" data-options="required:true" /></td>
			</tr>
			<tr>
				<th>原有图片：</th>
				<td><img
					src="${pageContext.request.contextPath}/${announce.vimgpath }"
					 /></td>
			</tr>
			<tr>
				<th>若您无需更改图片，则不需要选择文件：</th>
				<td><input type="file" name="upload" /></td>
			</tr>
			<tr>
				<th>公告文本：</th>
				<td><textarea rows="8" cols="14" name="vtext"
						class="easyui-validatebox" data-options="required:true">${announce.vtext}</textarea></td>
			</tr>
			<tr>
				<th>公告级别：</th>
				<td><select name="grade"><option value="0">普通</option>
						<option value="1">重要</option></select></td>
			</tr>

		</table>
	</form>

</body>
</html>
