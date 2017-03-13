<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link href="appcss/mui.min.css" rel="stylesheet" />
</head>

<body>
	<script src="appjs/mui.min.js"></script>

	<script type="text/javascript">
		$(function() {
			//alert();
			var gallery = mui('.mui-slider');
			gallery.slider({
				interval : 1000
			//自动轮播周期，若为0则不自动播放，默认为0；
			});
		});
	</script>
	<div class="mui-slider">
		<div class="mui-slider-group mui-slider-loop">
			<!--支持循环，需要重复图片节点-->
			<c:forEach items="${advertisements}" var="advertisement">
				<div class="mui-slider-item">
					<a href="${advertisement.vhrefpath }"><img src="${advertisement.vpath}" /></a>
				</div>
				</c:forEach>
		</div>
	</div>
</body>

</html>
