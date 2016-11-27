<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" import="huel.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品查询</title>
<style type="text/css">
table{
  text-align:center;
}
a{
text-decoration:none;
}
</style>
</head>
<body background="images/h2.png">
<center>
  <h1 align="center">商品信息查询</h1> 
  <h3 align="right"><a href="G_s_insert.jsp">+添加商品</a></h3>
  <h3 align="right"><a href="G_s_delete.jsp">-删除商品</a></h3>
<%
   Connection conn=null;
   conn=DbConnect.getDBconnection();
   String sql="select * from product";
   PreparedStatement pstmt=conn.prepareStatement(sql);
   ResultSet rs=pstmt.executeQuery();
   rs.last();%>
   <table width="70%" border="1" align="center">
      <tr bgcolor="gray">
         <th>编号</th><th>类型</th><th>名称</th><th>原价</th><th>促销价</th>
      </tr>
             
   <% 
   rs.beforeFirst();
      while(rs.next()){
   %> 
    <tr> 
         <td><%=rs.getString("Id")%></td>
         <td><%=rs.getString("Type")%></td>
         <td><%=rs.getString("Name")%></td>
         <td><%=rs.getFloat("UnitPrice")%></td>
         <td><%=rs.getFloat("PromotionPrice")%></td>
   </tr>
       <%
       }
       %>
  </table></div>
</center>
   <%
   DbConnect.closeDB(conn,pstmt,null);
   %>
  
</body>
</html>