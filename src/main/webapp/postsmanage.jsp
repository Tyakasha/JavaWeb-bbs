
<%@ page contentType="text/html;charset=UTF-8" %>
<%--导入jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>帖子管理</title>
    <script src="../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../static/umd/popper.min.js"></script>
    <script src="../static/js/bootstrap.min.js"></script>
    <script src="../static/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="../static/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="../static/css/postsmanage.css" >
    <link rel="stylesheet" type="text/css" href="../static/css/sweetalert.css">
    <script type="text/javascript" src="../static/js/sweetalert-dev.js"></script>
</head>

<c:set var="postsManagePageDTO" scope="request" value="${postsManagePageDTO}" />
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
                            <a href="userManage" class="text-decoration-none" style="height: 100%;line-height: 34px;color: #009a61;">用户管理</a>
                        </div>
                        <div class="link" id="notesManage">
                            <a href="javascript:window.location.reload()" class="text-decoration-none" style="height: 100%;line-height: 34px;color: #009a61;">帖子管理</a>
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
        <c:if test="${postsManagePageDTO!=null}">
            <c:forEach items="${postsManagePageDTO}" var="postsInfo">
                <div class="list-group">
                    <div style="background: #999999;width: 100%;height: 1.5px"></div>
                    <div class="content-group">
                        <div class="tag-content">
                            <div class="tag">
                                ${postsInfo.tag}
                            </div>
                            <div class="tag">
                                点赞 · ${postsInfo.thumbNum}
                            </div>
                        </div>
                        <div class="post-content">
                            <div class="post-title">
                                ${postsInfo.title}
                                <span class="title-span">${postsInfo.postUser} 发布于 ${postsInfo.postDate}</span>
                            </div>
                            <div class="post-info">
                                ${postsInfo.content}
                            </div>
                        </div>
                        <div class="opts-content">
                                <%--用来绑定帖子id--%>
                            <input value="${postsInfo.postsId}" hidden>
                            <button type="button" class="btn btn-primary" name="seeDetail" style="display: inline-block;width: 70%;margin-left: 15%;margin-top: 15px">查看详细</button>
                            <button type="button" class="btn btn-danger" name="deletePost" style="display: inline-block;width: 70%;margin-left: 15%;margin-top: 15px">删除该帖</button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
        <c:if test="${postsManagePageDTO==null}">
            <div style="width: 90%;margin-left: 5%;margin-top: 50px;text-align: center">论坛暂未有用户发布过帖子</div>
        </c:if>
    </div>
</div>
</body>
<script type="text/javascript" src="../static/js/postsmanage.js"></script>
</html>
