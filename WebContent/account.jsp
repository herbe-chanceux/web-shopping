<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="huel.bean.*,java.util.*"%>
<% List<ShoppingCart> lsc=(List<ShoppingCart>)request.getAttribute("ShoppingCart");
   Userinfo u=(Userinfo)session.getAttribute("Userinfo");
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单页面</title>
<style type="text/css">
table{
text-align:center;
}
a{
text-decoration:none;
}
</style>
</head>
<body bgcolor="#f6e3e9">
<br><br>
	<h1 align="center">我的订单:</h1><br><br>
	<form action="AccountController?action=saveAccount" method="post">
	<table align="center">

		<tr><td>订单号：</td><td><input type="text" name="accountCode" readonly value="<%=request.getAttribute("accountCode") %>"></td></tr>
		<tr><td>用户名：</td><td><input type="text" name="username" readonly value="<%=u.getUsername() %>"/></td></tr>
		<tr><td>Email: </td><td><input type="text" name="email" readonly value="<%=u.getEmail() %>" /></td></tr>
		<tr><td>用户地址: </td><td><input type="text" name="address" /></td></tr>	
	    <tr><td>邮编：</td><td><input type="text" name="postcode"  /></td></tr>	
	    <tr><td>联系电话：</td><td><input type="text" name="tel"  readonly value="<%=u.getTel()%>"/></td></tr>	
	    </table>
	    <table align="center">
        <tr><td><input type="submit" value="结账"/>
                <input type="button" value="返回" onClick="javascript:history.go(-1)"/>
        </td></tr>
</table>
</form>
</body>
</html>