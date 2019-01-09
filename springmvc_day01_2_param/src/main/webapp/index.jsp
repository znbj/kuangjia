<%--
  Created by IntelliJ IDEA.
  User: znbs
  Date: 2018/10/21
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@  page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/test">test</a>
<br>
<form action="/testParam">
    <input type="text" name="name">姓名<br>
    <input type="submit">
</form>
<br>
<form action="/testPojo">
    <input type="text" name="name">姓名<br>
    <input type="text" name="sex">性别<br>
    <input type="text" name="age">年龄<br>
    <input type="submit">
</form>
<br>
<form action="/testDate">
    <input type="text" name="name">姓名<br>
    <input type="text" name="sex">性别<br>
    <input type="text" name="age">年龄<br>
    <input type="text" name="birthday">生日<br>
    <input type="submit">
</form>


</body>
</html>
