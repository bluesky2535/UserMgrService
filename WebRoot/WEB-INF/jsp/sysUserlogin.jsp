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

<title>My JSP 'SysUserlogin.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style>
body {
	FONT-FAMILY: 微软雅黑;
}
</style>
</HEAD>
<BODY leftMargin=0 topMargin=0
	marginheight="0" marginwidth="0">
	<DIV style="PADDING-TOP: 80px" align=center valign="middle">
		<FORM method="post" name=loginform action="sysuser_login.action">
			<DIV align=center>
				<TABLE
					style="BORDER-BOTTOM: #ecfafb 6px solid; BORDER-LEFT: #ecfafb 6px solid; BORDER-TOP: #ecfafb 6px solid; BORDER-RIGHT: #ecfafb 6px solid"
					border=0 cellSpacing=0 cellPadding=0 width=700
					 height=380>
					<TBODY>
						<TR>
							<TD
								style="FILTER: alpha(opacity=80); LINE-HEIGHT: 200%; MARGIN-TOP: 0px; FONT-FAMILY: 微软雅黑; MARGIN-BOTTOM: 0px; COLOR: #ffffff; FONT-SIZE: 24pt; FONT-WEIGHT: bold"
								bgColor=#005a8f height=120 align=middle>通惠集团APP后台管理系统</TD>
						</TR>
						<TR>
							<TD style="FILTER: Alpha(opacity=50); BACKGROUND: #ffffff"
								height=55 align=middle>
								<TABLE style="POSITION: relative" id=table1 border=0
									cellSpacing=0 cellPadding=4 width="100%">
									<TBODY>
										<TR>
											<TD align=right>登录账号：<INPUT
												style="WIDTH: 100px; HEIGHT: 25px; FONT-SIZE: 12pt"
												id=username tabIndex=1 name="vsuname"> 密码：<INPUT
												style="WIDTH: 100px; HEIGHT: 25px; FONT-SIZE: 12pt"
												tabIndex=2 type="password" name="vpassword" id="pwd"
												autocomplete="off"></TD>
											<TD><INPUT id=submit tabIndex=5
												onclick="return checkform()" border=0
												src="jsp_images/btn_login.png" type=image name=submit></TD>
											<TD></TD>
											<TD width="10%">${requestScope.loginFail}</TD>
										</TR>
									</TBODY>
								</TABLE>
							</TD>
						</TR>
						<TR>
							<TD width=401></TD>
						</TR>
					</TBODY>
				</TABLE>
				<P style="LINE-HEIGHT: 250%; MARGIN-TOP: 0px; MARGIN-BOTTOM: 0px">
					<FONT style="FONT-SIZE: 9pt">©2016 用友网络科技. Powered by
						yonyou. </FONT>
				</P>
			</DIV>
		</FORM>
	</DIV>
	<SCRIPT language=javascript>

		function checkform() {
			if (loginform.username.value == '') {
				alert('请输入登陆账号！');
				loginform.username.focus();
				return false;
			}
			if (loginform.pwd.value == '') {
				alert('请输入登陆密码！');
				loginform.pwd.focus();
				return false;
			}
		}
	
	</SCRIPT>
</BODY>
</HTML>