<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.* " import="huel.dao.*" import="huel.controller.*" 
    import="huel.bean.*" import="huel.util.*" import="huel.tool.*"%>
 <% 

 List<Productinfo> ll=(List<Productinfo>) request.getAttribute("findByType");
 Integer pageCount=(Integer)request.getAttribute("pageCount");
 Integer start=(Integer)request.getAttribute("start");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页界面</title>
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
<table width="800" height="700" border="2" align="center">
<tr bgcolor="pink" height="30">
<th width="170" >图片</th>
<th width="80">类型</th> 
<th width="300">简介</th>
<th width="150">操作</th>
</tr>

<% 
     for(Productinfo p:ll){
 %>
<tr>
<td><!-- <img width="200" height="200" src="images/<%=p.getPic()%>"> -->
    <img width="200" height="200" src="images/<%=p.getPic()%>">
</td>
   <td><b>类型:</b><%=p.getType()%>  <br></td>
   <%pageContext.setAttribute("Type", p.getType()) ;%>
     <td align="left"><b>名字:</b><%=p.getName()%>  <br> 
       <b>单价:</b><%=p.getUnitPrice()%>  <br> 
       <b>促销价:</b><%=p.getPromotionPrice()%>  <br> 
       <b>语言:</b><%=p.getLanguage()%>  <br> 
       <b>导演:</b><%=p.getDirector()%>  <br> 
       <b>演员:</b><%=p.getActor()%>  <br> 
       <b>介绍:</b><%=p.getInstruction()%> <br> 
       <b>日期:</b><%=p.getDate()%><br> 
       <b>数量:</b><%=p.getNumber()%></td> 
    <td><a href="CartController?action=add&id=<%=p.getId() %>">加入购物车</a><br><br>
    <a href="downLoad?filename=1.png"> 文件下载</a>
     </td> 
</tr>  
<%
} 
%> 
</table>  
 <div align="center">
<a href="ProductController?action=findByType&Type=<%=pageContext.getAttribute("Type")%>&start=1">首页</a>
<%
for(int i=1;i<=pageCount;i++)
{
	  if(start==i){
		  %><%=i %>
	<%} 
	  else{
			  %>
			  <a href="ProductController?action=findByType&Type=<%=pageContext.getAttribute("Type")%>&start=<%=i%>"><%=i %></a>
			  <% 
		  }	  
}  
%>

<a href="ProductController?action=findByType&Type=<%=pageContext.getAttribute("Type")%>&start=<%=pageCount%>">尾页</a>
</div>
</body>
</html>