<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="huel.tool.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传</title>
</head>
<body background="images/h2.png">
<body>
<center><br><br><br>
<h3>选择上传的文件</h3>

<form method="post" action="Upload" enctype="multipart/form-data">
<input type="file" name="file1" contenteditable="false" onclick="info.innerHTML=''"/><br><br>
<input type="submit" value="上传">
</form>
<div id="info">${message }</div>
</center>

</body>
</html>