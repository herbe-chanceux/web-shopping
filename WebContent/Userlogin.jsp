<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录页面</title>
<style type="text/css">
<!--
.pp{font-size:50px;font-family:华文行楷}
.pq{font-size:30px;font-family:华文行楷}


</style>
</head>
<body bgcolor="#f6e3e9">
 <h2 align="center"><p class="pp">---欢迎您登录---</p></h2><hr>
<form name="form1" method="post">
  <table align="center" >
<tr><td><p class="pq">用户名：
       <input type="text" name="username" value="${param.username}"/></p></td></tr>
  <tr><td><p class="pq">密&nbsp;&nbsp;&nbsp;&nbsp;码：
       <input type="password" name="password" value="${param.password}"/></p></td></tr>        
   <tr><td><p class="pq">验证码:&nbsp;&nbsp;&nbsp;
    <input type="text" name="checkcode"/> 
   <img border="0" src="checkcode"/> 
   <input type="submit" value="换一张" onclick="form1.action='changecheckcode'"/> </p></td></tr></table>
   <table align="center" >
    <tr><td><input type="image" src="images/login.png" width="70" height="25" 
   onclick="form1.action='userinfoController?action=login'"/>&nbsp;&nbsp; 
  <input type="button" value="返回" onClick="javascript:history.go(-1)"/>
   <div id="mes">${info}</div></td></tr>  
</table>
</form>
</body>
</html>