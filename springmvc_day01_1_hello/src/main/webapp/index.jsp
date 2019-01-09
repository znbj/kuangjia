<%--
  Created by IntelliJ IDEA.
  User: znbs
  Date: 2018/10/21
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/user/hello?name=zh">hello1</a>
<a href="${pageContext.request.contextPath}/user/hello?name=zh">hello2</a>
</body>
</html>
