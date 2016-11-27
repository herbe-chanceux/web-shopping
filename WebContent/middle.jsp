<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导航条</title>
</head>
<body bgcolor="#ABDDDD">
<table  width="988" height="0" border="0" cellspacing="0" cellpadding="0" bgcolor="">
<tr align="center">
    <td><a href="homepage.jsp" target="main">首页</a>
    <td><a href="ProductController?action=findByType&Type=1" target="main">电影</a></td>
    <td><a href="ProductController?action=findByType&Type=3" target="main">音乐</a></td>
    <td><a href="ProductController?action=findByType&Type=2" target="main">动漫</a></td>
    <td><a href="ProductController?action=findByType&Type=4" target="main">教育</a></td>
     <td><a href="ProductController?action=findByType&Type=5" target="main">戏剧</a></td>
    <td><a href="ProductController?action=findByType&Type=6" target="main">其它</a></td>
</tr></table>
</body>
</html>