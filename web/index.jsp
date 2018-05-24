<%--
  Created by IntelliJ IDEA.
  User: 谭伟林
  Date: 2018/3/6
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>Test Json</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8>
    <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
</head>

<body>
<form action="getUsers" method="get">
  <input type="submit" value="点击获取JSON数据"/>
</form>
</body>
</html>
