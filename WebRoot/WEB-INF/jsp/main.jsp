<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>My JSP 'sysloginSuccess.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/admin.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css" />

</head>
<body class="easyui-layout" style="width:100%;height:100%;">
	<div
		data-options="region:'north',title:'header',
split:false,noheader:true"
		style="height:60px;background:#666;">
		<div class="logo">通惠APP后台管理</div>
		<div class="logout">
			您好，${sessionScope.sysUser.vsuname} | <a href="sysuser_quit.action">
				退出</a>
		</div>
	</div>

	<!--左边菜单  -->
	<div
		data-options="region:'west',iconCls:'icon-house',title:'后台管理',split:false ,border:false,collapsible:false"
		style="width:150px;">
		<div id="west_accordion" class="easyui-accordion"
			data-options="fit:true,border:false">

			<div title="系统管理员" data-options="iconCls:'icon-admin',selected:true"
				style="padding:10px;">
				<a id="west_accordion_xtglylb"></a>
			</div>
			<div title="用户信息" data-options="iconCls:'icon-user',selected:true"
				style="padding:10px;">
				<a id="west_accordion_yhxxlb"></a>
			</div>
			<div title="广告管理" data-options="iconCls:'icon-advertisement'"
				style="overflow:auto;padding:10px;">
				<a id="west_accordion_ggxxlb"></a>
			</div>
			<div title="公告管理" data-options="iconCls:'icon-announce'"
				style="padding:10px;">
				<a id="west_accordion_announcelb"></a>
			</div>
			<div title="优惠管理" data-options="iconCls:'icon-bargain'"
				style="padding:10px;"></div>
		</div>
	</div>

	<!--中心  -->
	<div data-options="region:'center',border:false">
		<div id="center_tabs" class="easyui-tabs" data-options="fit:true">
			<div title="主页" data-options="closable:false,iconCls:'icon-house'"
				style="padding:0px;display:none;text-align:center;">
				<div style="height:100%;background-image: url(jsp_images/light.png)">
					<h1 style="top:600px">欢迎来到管理界面</h1>
				</div>
			</div>
		</div>
	</div>
	<div
		data-options="region:'south',title:'footer',split:false,noheader:true,border:false,"
		style="height:25px;line-height:30px;text-align:center;">©2016
		用友网络科技. Powered by yonyou.</div>
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/customjs/jquery.form.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/customjs/main.js"></script>

</body>

</html>
