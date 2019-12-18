<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>跳转测试页</title>
</head>
<c:set var="type" scope="request" value="${type}" />
<body>
<h1>我是跳转测试页</h1>
<c:if test="${type==1}">
    <h1>type是1</h1>
</c:if>
<a   class="text-decoration-none" style="height: 100%;line-height: 34px;color: #009a61;font-weight: bolder" onclick="x()">返回首页</a>
</body>
<script>
    function x() {
        var url=window.location.pathname;
        var end = url.lastIndexOf("/");
        url = url.substring(0,end);
        window.location.href=url;
    }
</script>
</html>