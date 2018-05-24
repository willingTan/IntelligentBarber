<%--
  Created by IntelliJ IDEA.
  User: 谭伟林
  Date: 2018/3/26
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'upload2.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<p>上传文件，重命名<p/> <br>
<form action="saveimage" method="post" enctype="multipart/form-data">
    上传图片<input type="file" name="imgs"/></br>
    图片说明<input type="text" name="node"/></br>
    <input type="submit" value="上传"/></br>
</form>
</body>
</html>