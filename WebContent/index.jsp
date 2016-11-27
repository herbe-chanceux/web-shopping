<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="huel.bean.*,huel.controller.*,huel.dao.*,huel.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主页面</title>
</head>
<frameset rows="100,*">
   <frame src="top.jsp" name="top" scrolling="no">
   <frameset rows="40,*">
   <frame src="middle.jsp" name="middle" scrolling="no">
   <frame src="main.jsp" name="main" scrolling="yes" >
       
   </frameset>
</frameset>
</html>