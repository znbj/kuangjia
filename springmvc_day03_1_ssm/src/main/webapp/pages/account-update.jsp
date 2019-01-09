<%--
  Created by IntelliJ IDEA.
  User: znbs
  Date: 2018/10/24
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>展示</title>
    <!-- 引入CSS样式 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/account/update" method="post">
    <div>
        <input type="hidden" name="id" value="${account.id}">
    </div>
    <div class="form-group">
        <label for="firstname"  class="col-sm-2 control-label">名字</label>
        <div class="col-sm-10">
            <input type="text" name="username" class="form-control" id="firstname"
                   placeholder="${account.username}">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname"  class="col-sm-2 control-label">余额</label>
        <div class="col-sm-10">
            <input type="text" name="money" class="form-control" id="lastname"
                   placeholder="${account.money}">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">修改</button>
        </div>
    </div>
</form>


</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</html>
