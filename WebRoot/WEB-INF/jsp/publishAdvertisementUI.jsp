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

<title>My JSP 'publishAdvertisementUI.jsp' starting page</title>

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
	<form action="advertisement_publish.action" method="post"
		enctype="multipart/form-data" id="advertisement_publishform">
		<table style="position: absolute; top:50px">
			<tr style="height:50px">
				<th>广告名：</th>
				<td><input name="vadname" id="pubform_ad_vadname"
					class="easyui-validatebox" data-options="required:true"></td>
			</tr>
			<tr style="height:50px">
				<th>选择图片：</th>
				<td><a href="javascript:void(0)" id="advertisement_publishform_tooltip" ><input name="upload" type="file" style="width: 150px"
					id="pubform_ad_upload" class="easyui-validatebox"
					data-options="required:true"></a></td>
			</tr>
			<tr style="height:50px">
				<th>图片链接：</th>
				<td><input name="vhrefpath" id="pubform_ad_vhrefpath" value="http://"
					class="easyui-validatebox"
					data-options="required:true,validType:'url'"></td>
			</tr>
		</table>
	</form>
</body>
</html>
