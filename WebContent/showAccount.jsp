<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* " import="huel.dao.*" import="huel.controller.*" 
    import="huel.bean.*" import="huel.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看订单界面</title>
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
	<h2 align="center">我的订单表:</h2>
	<%
	List<Account> la=new ArrayList<Account>();
	la=(List<Account>)session.getAttribute("ordertable");
	Account a=new Account();
	System.out.println("**********"+la.size());
	%>
	<table width="800" height="50" border="2" align="center">
	<tr><th>序号</th><th>用户id</th><th>订单号</th><th>状态</th><th></th></tr>
	<%
	if(a!=null){
	for(int i=0;i<la.size();i++){
		a=la.get(i);
		System.out.println("**********"+a.getAccountcode());
	%>
	<tr><td><%=i+1%></td><td><%=a.getUserid() %></td><td><%=a.getAccountcode() %></td><td><%=a.getExecute() %></td><td><a href="AccountController?action=showAccount2&accountcode=<%=a.getAccountcode() %>" target=main>订单详情</a></td></tr>
	<%} }%>
	</table>
</body>
</html>