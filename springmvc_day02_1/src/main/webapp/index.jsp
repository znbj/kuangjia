<%--
  Created by IntelliJ IDEA.
  User: znbs
  Date: 2018/10/22
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@  page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/user/test">test</a>
<br>
<form action="${pageContext.request.contextPath}/user/testUpdate" method="post">
    姓名:<input type="text" name="name"><br>
    地址:<input type="text" name="address"><br>
    <input type="submit" value="更改">
</form>
<form action="${pageContext.request.contextPath}/rest/operate/6" method="get">
    <input type="submit" value="查询">
</form>
<form action="${pageContext.request.contextPath}/rest/operate/66" method="post">
    <input type="submit" value="保存">
</form>
<form action="${pageContext.request.contextPath}/rest/operate/6" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="修改">
</form>
<form action="${pageContext.request.contextPath}/rest/operate/6" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="删除">
</form>
<br>
<button  onclick="test()">点击</button>
<script type="text/javascript" src="${pageContext.request.contextPath}js/jquery.min.js"></script>
<script type="text/javascript">
    
    function test() {
       $.ajax({
            url:"${pageContext.request.contextPath}/user/testjson",

           dataType:"json",
           type:"post",
           data:{"name":"zhangan"},
           success:function(data){
            alert(data.name);
            alert(data.age);
            alert(data.address);
           }
       })
    }
    
    
</script>
</body>
</html>
