<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
</head>
<body background="images/h2.png">
<body>
<h2 align="center">添加商品</h2>
<form action="ProductController?action=addProduct" method="post">
<center>
<table border="0" width="238" height="252">
   <tr><td>类型</td><td><input type="text" name="Type"></td></tr>
   <tr><td>名称</td><td><input type="text" name="Name"></td></tr>
   <tr><td>原价</td><td><input type="text" name="UnitPrice"></td></tr>
   <tr><td>促销价</td><td><input type="text" name="PromotionPrice"></td></tr>
   <tr align="center">
      <td colspan="2">
          <input type="submit" value="提交">&nbsp;&nbsp;&nbsp;
          <input type="reset" value="取消">
      </td>
   </tr>
</table>
</center>

</form>
</body>
</html>