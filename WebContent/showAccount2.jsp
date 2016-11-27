<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* " import="huel.dao.*" import="huel.controller.*" 
    import="huel.bean.*" import="huel.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详情页面</title>
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
	<h2 align="center">详情订单表:</h2>
	<%
	List<AccountProducts> lap=new ArrayList<AccountProducts>();
	lap=(List<AccountProducts>)session.getAttribute("ordertable2");
	AccountProducts ap=new AccountProducts();
	System.out.println("**********"+lap.size());
	
	
    Productinfo p=new Productinfo();
    System.out.println("....+++____-kkkkkkkkkkkk。");
	p=(Productinfo)session.getAttribute("findByID");
	
	System.out.println("....+++____-----》》》。"+p);
	%>
	<%
	if(ap!=null){
	for(int i=0;i<lap.size();i++){
		ap=lap.get(i);
		//session.setAttribute("pid", ap.getProductid());
		System.out.println("**********"+ap.getAccountcode());
	%>
	<table width="800" height="50" border="2" align="center"><br>
	<tr align="left"><%=ap.getAccountdate() %>&nbsp;&nbsp;&nbsp;&nbsp;订单号：<%=ap.getAccountcode() %>  </tr>
	<tr><td>序号</td><th>商品ID</th><th>商品图片</th><th>数量</th><th>价格</th></tr>
	<tr><td><%=i+1%></td><td><%=ap.getProductid() %></td><td><img width="200" height="200" src="images/<%=p.getPic()%>"></td><td><%=ap.getNum() %></td><th><%=p.getUnitPrice() %></th></tr>
	
	<%} }%>
	</table>
</body>
</html>