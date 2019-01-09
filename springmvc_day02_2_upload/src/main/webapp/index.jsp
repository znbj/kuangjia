<%--
  Created by IntelliJ IDEA.
  User: znbs
  Date: 2018/10/23
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/fileUpload1" method="post" enctype="multipart/form-data">
    名称<input type="text" name="pickName"><br>
    文件<input type="file" name="uploadFile"><br>
    <input type="submit" value="上传"><br>
</form>
</body>
</html>
