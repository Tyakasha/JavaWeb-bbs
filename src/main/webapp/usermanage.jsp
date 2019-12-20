
<%@ page contentType="text/html;charset=UTF-8" %>
<%--导入jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理</title>
    <%--引入bootstrap的js库（包括jquery和其他第三方js库）--%>
    <script src="../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../static/umd/popper.min.js"></script>
    <script src="../static/js/bootstrap.min.js"></script>
    <script src="../static/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="../static/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../static/css/sweetalert.css">
    <script type="text/javascript" src="../static/js/sweetalert-dev.js"></script>
    <link rel="stylesheet" type="text/css" href="../static/css/usermanage.css">
</head>

<c:set var="userManageInfoDTO" scope="request" value="${userManagePageDTO}"  />
<body>
<div style="display: block;width: 100%;min-height: 1800px;max-height: 5000px;height: 1800px">
    <header style="background: #009933;height: 3px"></header>
    <header style="background: #fafafa;height: 67px">
        <div class="header-content">
            <div class="label-website-name">
                <label style="margin-left: 25px">NCU校园技术论坛</label>
            </div>
            <div class="opts" >
                <div class="link-home">
                    <a id="returnHome" class="text-decoration-none" style="height: 100%;line-height: 34px;color: #009a61;font-weight: bolder;cursor: pointer">首页</a>
                </div>
                <c:if test="${userAccInfoDTO!=null}">
                    <div class="link-create"  id="createNote">
                        <!--<a href="#" class="text-decoration-none" style="height: 100%;line-height: 34px;color: #333333;font-weight: bolder">创建</a>-->
                        <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink-create"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
                           style="background: transparent;height: 100%;color: #009a61;font-weight: bolder;border: 0;margin-top: -1.5px">
                            创建
                        </a>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink-create">
                            <a class="dropdown-item" href="#">普通帖</a>
                            <a class="dropdown-item" href="#">问答帖</a>
                        </div>
                    </div>
                    <!--管理员才有这两个功能-->
                    <c:if test="${userAccInfoDTO.accType==1}">
                        <div class="link" id="userManage">
                            <a href="javascript:window.location.reload()" class="text-decoration-none" style="height: 100%;line-height: 34px;color: #009a61;">用户管理</a>
                        </div>
                        <div class="link" id="notesManage">
                            <a href="postsManage" class="text-decoration-none" style="height: 100%;line-height: 34px;color: #009a61;">帖子管理</a>
                        </div>
                    </c:if>
                </c:if>
            </div>
            <div class="signIn-area">
                <c:if test="${userAccInfoDTO!=null}">
                    <div class="welcome-tip" >
                        <div  id="dropdownMenuLink-user" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="margin-top: 5%">
                            <a><img src="../static/images/login_logo.png" class="avatar-img"/></a>
                        </div>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink-user" >
                            <a class="dropdown-item" href="userInfoPage?userName=${userAccInfoDTO.userName}">账户信息</a>
                            <a class="dropdown-item"  id="signOut">退出登录</a>
                        </div>
                        <label style="margin-left: 25px">欢迎您，${userAccInfoDTO.userName}</label>
                    </div>
                </c:if>
            </div>
        </div>
    </header>
    <header style="background: #CCCCCC;height: 1px"></header>
    <div class="main-container">
        <table class="table table-hover" style="text-align: center">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">用户名</th>
                <th scope="col">注册邮箱</th>
                <th scope="col">注册时间</th>
                <th scope="col">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${userManageInfoDTO}" var="userInfo">
                <tr>
                    <th scope="row">${userInfo.rowNum}</th>
                    <td>${userInfo.userName}</td>
                    <td>${userInfo.loginAcc}</td>
                    <td>${userInfo.registerDate}</td>
                    <%--已经是管理员不需要再授权--%>
                    <c:if test="${userInfo.accType==1}">
                        <td>
                            <button type="button" class="btn btn-warning" style="width: 120px" name="authorize" disabled>管理员授权</button>
                        </td>
                    </c:if>
                    <c:if test="${userInfo.accType==0}">
                        <td>
                            <button type="button" class="btn btn-warning" style="width: 120px" name="authorize">管理员授权</button>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
<script type="text/javascript" src="../static/js/usermanage.js"></script>
</html>
