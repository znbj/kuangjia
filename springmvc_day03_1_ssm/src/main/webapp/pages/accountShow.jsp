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
<table class="table table-hover">
    <caption>信息展示</caption>
    <caption>
        <a href="${pageContext.request.contextPath}/pages/account-add.jsp" class="btn btn-default btn-sm">新建</a>
    </caption>
    <thead>
    <tr>
        <th>id</th>
        <th>用户名</th>
        <th>余额</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${accountList}" var="account">
        <tr>
            <td>${account.id}</td>
            <td>${account.username}</td>
            <td>${account.money}</td>
            <td>
                <a href="${pageContext.request.contextPath}/account/delById?id=${account.id}"  class="btn btn-default btn-sm">删除</a>
                <a href="${pageContext.request.contextPath}/account/updateUI?id=${account.id}" class="btn btn-default btn-sm">修改</a>
            </td>
        </tr>



    </c:forEach>




    </tbody>
</table>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</html>
