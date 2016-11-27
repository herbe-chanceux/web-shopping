<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="huel.bean.*,huel.controller.*,huel.dao.*,huel.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>头部页面</title>
<style type=text/css>
<!--
body
{background-color:#f6e3e9}
-->
</style>
</head>
<body  >
<div style=position:absolute;left:2%;top:83%>
<a href="login.jsp" target=_top>登录</a> <a href="regist.jsp" target=_top>注册</a> 
</div>

<img src="images/top.png" height="70" width="100%">

<div style=position:absolute;right:14%;top:83%><font color="#000000" size="3">
<a href="viewShoppingcart.jsp" target="main">查看购物车</a></font> 
</div>
<div style=position:absolute;right:7.5%;top:83%><font color="#000000" size="3">
<a href="AccountController?action=showAccount" target="main">查看订单</a></font>
</div>
<div style=position:absolute;right:1%;top:81.5%><font color="#000000" size="3">
<a href="login.jsp" target=_top>安全退出</a></font></div>
</body>
</html>