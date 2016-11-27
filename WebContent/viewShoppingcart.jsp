<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="huel.bean.*,java.util.*"%>
    <% List<ShoppingCart> lsc;
   lsc=(List<ShoppingCart>) session.getAttribute("ShoppingCart");
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看购物车</title>
<style type="text/css">
table{
text-align:center;
}
a{
text-decoration:none;
}
</style>

</head>
<body>
<h2 align="center">您的购物车</h2><br><br>
	<form name="form1" action="CartController?action=changeNum" method="post">
	<table width="600" border="0" align="center">
	<tr>
		<th>商品名称</th>
		<th>商品类型</th>
		<th>商品单价</th>
		<th>购买数量</th>
		<th>价格小计</th>
		<th>&nbsp;&nbsp;</th>
	</tr>	
	<%
	    float allCost=0;//计算总金额
		if (lsc== null || lsc.size()==0)
		{
	%>
	<tr>
		<td colspan="4" align="center" height="30">您的购物车目前为空！</td>
	</tr>
	<%
		}
		else {	
			
			for(int i=0;i<lsc.size();i++)
			{
				ShoppingCart product=(ShoppingCart)lsc.get(i);
				allCost+=product.getUnitPrice()*product.getNum();
	%>
	<tr>
				<td><img width="50" height="50" src="images/<%=product.getPic() %>"></td>
				<td><%=product.getType()%></td>
				<td><%=product.getUnitPrice()%></td>
				<td><input type="text" name="num" value=<%=product.getNum() %>></td>
				<td><%=product.getUnitPrice()*product.getNum() %></td>
				<td><a href="CartController?action=removeCart&id=<%=product.getId() %>">删除</a></td>
			</tr>
	<% 
			}	
		}
	%>
	
	<tr height="50">
	     <td align="center"><input type="submit" value="修改数量"></td>
	     <td><font color="red">消费总金额：<%=allCost %></font></td>
	     <td><a href="CartController?action=clearCart">清空购物车</a></td>
	     <td><a href="AccountController?action=getAccountCode">结账</a></td>
	     <td><a href="homepage.jsp">继续购物</a></td>
	</tr>
</table>
</form>
</body>
</html>