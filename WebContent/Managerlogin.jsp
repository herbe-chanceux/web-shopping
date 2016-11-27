<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录页面</title>
</head>
<body background="images/h2.png" >
<div style=position:absolute;right:10%;top:0%><img src=images\hh1.gif width=240 height=240></div>

<br><br><br><br><br><br><br>
<h1><center>       管    理   员   后   台   登   陆</center></h1>
<br><br>
<form name="form2" method="post">
<table align="center">
    <tr><td>用户名：<input type="text" name="Staff_Name" value="${param.Staff_Name}"/></td></tr>
   <tr><td> 密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="Staff_Password" value="${param.Staff_Password}"/> 
</td></tr></table><br>
<table align="center">
    <input type="image" src="images/G1.png" width="50" height="20"
   onclick="form2.action='ManagerinfoController?action=login'"/>
  <input type="button" value="返回" onClick="javascript:history.go(-1)"/>
   <div id="mes">${info} 
   </div></table>
 </form>  
</body>
</html>