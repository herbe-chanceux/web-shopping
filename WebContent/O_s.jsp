<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" import="huel.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单查询</title>
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
  <table bgcolor="orange">
     <tr><td>订单信息的查询</td></tr>
  </table>
  
<%
   Connection conn=null;
   conn=DbConnect.getDBconnection();
   String sql="select * from account";
   PreparedStatement pstmt=conn.prepareStatement(sql);
   ResultSet rs=pstmt.executeQuery();
   rs.last();%>
   <table width="70%" border="1" align="center">
      <tr bgcolor="gray" height="30" >
         <th>编号</th><th>用户ID号</th><th>订单号</th><th>订货日期</th>
      </tr>
             
   <% 
   rs.beforeFirst();
      while(rs.next()){
   %> 
    <tr> 
        <td><%=rs.getInt("id")%></td>
        <td><%=rs.getInt("userid")%></td>
        <td><%=rs.getString("accountcode")%></td>
        <td><%=rs.getString("accountdate")%></td>
   </tr>
       <%
       }
       %>
  </table>
</center>
   <%
   DbConnect.closeDB(conn,pstmt,null);
   %>
</body>
</html>