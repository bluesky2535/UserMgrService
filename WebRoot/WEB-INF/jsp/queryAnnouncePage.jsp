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

<title>My JSP 'announceList.jsp' starting page</title>

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
	<%-- 	<h1>公告管理界面</h1>
	<a href="announce_publishUI">去发布公告</a>
	<table border="solid">
		<tr>
			<th>公告标题</th>
			<th>公告文本</th>
			<th>公告图片</th>
			<th>公告创建人</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${announces}" var="announce">
			<tr>
				<td>${announce.vtitlename }</td>
				<td>${announce.vtext}</td>
				<td><img alt=""
					src="${pageContext.request.contextPath}/${announce.vimgpath}"></td>
				<td>${announce.vcreator.vsuname }</td>
				<td><a href="announce_modifyUI?vanid=${announce.vanid}">修改</a>|||
				<a href="announce_delete?vanid=${announce.vanid }">删除</a>|||</td>
			</tr>
			<br>
			<tr>
		</c:forEach>
	</table> --%>
	<table id="center_datagrid_announcelb"></table>
	<div id="addAnnounce" style="display: none;"></div>
	<div style="position: relative;">
	<div id="editAnnounce" style="display: none;"></div>
	</div>
	<script type="text/javascript"
		src="<%=basePath%>js/customjs/announcelb.js"></script>
</body>
</html>
