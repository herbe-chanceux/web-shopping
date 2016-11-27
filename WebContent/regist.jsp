 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册页面</title>
<style type="text/css">
<!--
.pp{font-size:50px;font-family:华文行楷}
.pq{font-size:30px;font-family:华文行楷}


</style>
</head>
<body bgcolor="#f6e3e9">
 <h2 align="center"><p class="pp">---用户信息注册---</p></h2><hr>
<form action="userinfoController?action=regist" method="post">
  <table align="center">
   <tr><td><p class="pq">用户名：</td><td><input type="text" name="username"></td></tr>
   <tr><td><p class="pq">密码：</td><td><input type="password" name="password"></td></tr> 
   <tr><td><p class="pq">确认密码：</td><td><input type="password" name="repassword"></td></tr>
   <tr><td><p class="pq">性别：</td>
       <td><input type="radio" name="sex" checked="checked" value="男">男
           <input type="radio" name="sex" value="女">女
       </td>
   </tr>
   <tr><td><p class="pq">电话：</td><td><input type="text" name="tel"></td></tr>
   <tr><td><p class="pq">邮箱：</td><td><input type="text" name="email"></td></tr>
  </table>
  <table align="center">
  <br><br>
    <tr><td><input type="submit" value="注册" >
            <input type="reset" value="重置">
            <input type="button" value="返回" onClick="javascript:history.go(-1)"/></td></tr>
  </table>
    
</form>
</body>
</html>