
<%@ page contentType="text/html;charset=UTF-8" %>
<%--导入jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>详细内容</title>
    <%--导入jquery--%>
    <script src="../static/js/jquery.min.js"></script>
    <%--导入Popper.js，这是bootstrap需要的js库--%>
    <script type="text/javascript" src="../static/umd/popper.min.js"></script>
    <%--jquerysession.js--%>
    <script src="../static/js/jquerysession.js"></script>
    <%--bootstrap的js库--%>
    <script src="../static/js/bootstrap.min.js"></script>
    <script src="../static/js/bootstrap.bundle.min.js"></script>
    <%--bootstrap的样式库--%>
    <link rel="stylesheet" href="../static/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../static/css/postdetail.css">
    <link rel="stylesheet" type="text/css" href="../static/css/sweetalert.css">
    <script type="text/javascript" src="../static/js/sweetalert-dev.js"></script>
    <link rel="stylesheet" type="text/css" href="../static/css/toastr.css">
    <script type="text/javascript" src="../static/js/toastr.min.js"></script>
</head>

<c:set var="userAccInfoDTO" scope="session" value="${userAccInfoDTO}" />
<c:set var="detailPostsDTO" scope="request" value="${postsDTO}"/>
<c:set var="postsComments" scope="request" value="${postsComments}"/>
<body>
<div style="width: 100%;height: 1500px;max-height: 5000px;display: block">
    <header style="background: #009933;height: 3px"></header>
    <header style="background: #fafafa;height: 67px">
        <div class="header-content">
            <div class="label-website-name">
                <label style="margin-left: 25px">NCU校园技术论坛</label>
            </div>
            <div class="opts" >
                <div class="link-home">
                    <a  id="returnHome" class="text-decoration-none" style="height: 100%;line-height: 34px;color: #009a61;font-weight: bolder">首页</a>
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
                            <a class="dropdown-item" href="bbs/postPage?type=0">普通帖</a>
                            <a class="dropdown-item" href="bbs/postPage?type=1">问答帖</a>
                        </div>
                    </div>
                    <!--管理员才有这两个功能-->
                    <c:if test="${userAccInfoDTO.accType==1}">
                        <div class="link" id="userManage">
                            <a href="bbs/userManage" class="text-decoration-none" style="height: 100%;line-height: 34px;color: #009a61;">用户管理</a>
                        </div>
                        <div class="link" id="notesManage">
                            <a href="bbs/postsManage" class="text-decoration-none" style="height: 100%;line-height: 34px;color: #009a61;">帖子管理</a>
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
                            <a class="dropdown-item" href="bbs/userInfoPage?userName=${userAccInfoDTO.userName}">账户信息</a>
                            <a class="dropdown-item"  id="signOut">退出登录</a>
                        </div>
                        <label style="margin-left: 25px">欢迎您，${userAccInfoDTO.userName}</label>
                    </div>
                </c:if>
                <c:if test="${userAccInfoDTO==null}">
                    <div class="signIn-btn">
                        <!--
                              未登录时显示登录及注册按钮，登陆后用户头像以及欢迎信息
                        -->
                        <button type="button" class="btn btn-light" id="#signIn"
                                data-toggle="modal" data-target="#myModal" style="height: 34px;width: 82px;font-size: 14px;color: #009933;margin-top: 16.5px">立即登录</button>
                        <button type="button" class="btn btn-success" id="register" style="height: 34px;width: 82px;font-size: 14px;margin-top: 16.5px;margin-left: 20px">免费注册</button>
                    </div>
                    <!-- 用户登录以及注册的对话框 -->
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="modalLabel">用户登录</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="signIn-content" id="signIn-content">
                                        <form style="margin-left: 25px;margin-top: 5%">
                                            <div class="form-group">
                                                <label class="form-control-label" style="font-weight: bolder;" >登录账号</label>
                                                <input type="email" placeholder="请输入账号" class="form-control" style="width: 400px" id="loginAcc">
                                                    <%--校验信息提示--%>
                                                <label class="form-control-label" style="font-size: 12px;color: red" id="check-loginAcc-tip"></label>
                                            </div>
                                                <%--进度旋转条--%>
                                            <div class="spinner-border text-success" role="status" style="display: none" id="loading-sp-1">
                                                <span class="sr-only">Loading...</span>
                                            </div>
                                            <div class="form-group" style="margin-top: 25px">
                                                <label class="form-control-label" style="font-weight: bolder">登录密码</label>
                                                <button  type="button" class="btn btn-link" id="resetPwd" style="margin-left: 235px">忘记密码？</button>
                                                <input type="password" placeholder="请输入密码" class="form-control" style="width: 400px" id="password">
                                                    <%--校验信息提示--%>
                                                <label class="form-control-label" style="font-size: 12px;color: red" id="check-password-tip"></label>
                                            </div>
                                            <div class="form-group" style="margin-top: 25px">
                                                <button type="button" class="btn btn-primary" style="width: 400px" id="signIn-btn">登 录</button>
                                                <button type="button" class="btn btn-success" style="width: 400px;margin-top: 20px" id="registerAcc-btn">注 册 账 号</button>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="register-content" id="register-content">
                                        <form style="margin-left: 25px;margin-top: 2%">
                                            <div class="form-group">
                                                <label class="form-control-label" style="font-weight: bolder;" >用户名</label>
                                                <input type="text" placeholder="请输入用户名" class="form-control" style="width: 400px" id="userName">
                                            </div>
                                            <div class="form-group">
                                                <label class="form-control-label" style="font-weight: bolder;" >联系方式</label>
                                                <input type="text" placeholder="请输入联系方式" class="form-control" style="width: 400px" id="contact">
                                            </div>
                                            <div class="form-group">
                                                <label class="form-control-label" style="font-weight: bolder;" >工作性质</label>
                                                    <%--进度旋转条--%>
                                                <div class="spinner-border text-success" role="status" style="display: none" id="loading-sp-2">
                                                    <span class="sr-only">Loading...</span>
                                                </div>
                                                <select class="form-control" style="width: 400px" id="jobCategory">
                                                    <option>学生</option>
                                                    <option>IT/互联网</option>
                                                    <option>教育</option>
                                                    <option>金融</option>
                                                    <option>艺术/设计</option>
                                                    <option>服务业</option>
                                                    <option>交通运输</option>
                                                    <option>其他</option>
                                                </select>
                                            </div>
                                            <div class="form-group" >
                                                <label class="form-control-label" style="font-weight: bolder">注册邮箱</label>
                                                <input type="text" placeholder="请输入邮箱地址" class="form-control" style="width: 400px" id="email">
                                            </div>
                                            <div class="form-group">
                                                <label class="form-control-label" style="font-weight: bolder">登录密码</label>
                                                <input type="password" placeholder="请输入不少于六位的密码" class="form-control" style="width: 400px" id="register-password">
                                            </div>
                                            <div class="form-group" >
                                                <button type="button" class="btn btn-primary" style="width: 400px" id="register-btn">注 册</button>
                                                <button type="button" class="btn btn-success" style="width: 400px;margin-top: 10px" id="returnToSignIn-btn">返 回 登 录</button>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="resetPwd-content" id="resetPwd-content">
                                        <form style="margin-left: 25px;margin-top: 2%">
                                            <div class="form-group">
                                                <label class="form-control-label" style="font-weight: bolder;" >您的用户名</label>
                                                <input type="text" placeholder="请输入用户名" class="form-control" style="width: 400px" id="userName-reset">
                                            </div>
                                            <div class="form-group">
                                                <label class="form-control-label" style="font-weight: bolder;" >您的注册邮箱</label>
                                                <input type="text" placeholder="请输入联系方式" class="form-control" style="width: 400px" id="email-reset">
                                            </div>
                                            <div class="form-group">
                                                <label class="form-control-label" style="font-weight: bolder">设置新的密码</label>
                                                <input type="password" placeholder="请输入不少于六位的密码" class="form-control" style="width: 400px" id="password-reset">
                                            </div>
                                            <div class="form-group" >
                                                <button type="button" class="btn btn-primary" style="width: 400px" id="confirm-reset">重置密码</button>
                                                <button type="button" class="btn btn-success" style="width: 400px;margin-top: 10px" id="returnToSignIn-btn-reset">返 回 登 录</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
    </header>
    <header style="background: #CCCCCC;height: 1px"></header>
    <div class="main-container">
        <div class="user-info">
            <div class="avatar-img">
                <img src="../static/images/user-64.png" class="avatar-img">
            </div>
            <div class="user-name">
                <a class="text-decoration-none" href="userInfoPage?userName=${detailPostsDTO.postUser}"> ${detailPostsDTO.postUser}</a>
            </div>
        </div>
        <div class="title-info">${detailPostsDTO.title}</div>
        <div class="post-content">
            ${detailPostsDTO.content}
        </div>
        <div style="height: 20px"></div>
    </div>
    <div style="width: 70%;height: 200px;margin-left: 15%;background: #FFFFFF;">
        <div style="width: 100%;height: 50px"></div>
        <div class="date-info">发布于 ${detailPostsDTO.postDate}</div>
        <div class="opts-content">
            <%--这4项分别记录帖子点赞数值，已及当前用户的点赞标记，帖子的精品标记和置顶标记--%>
            <label id="thumbNum" hidden>${detailPostsDTO.thumbNum}</label>
            <input id="thumbFlag" value="${detailPostsDTO.userThumbFlag}" hidden>
            <input id="markFlag" value="${detailPostsDTO.boutiqueFlag}" hidden>
            <input id="topFlag" value="${detailPostsDTO.topFlag}" hidden>
            <%--帖子ID--%>
            <input id="postId" value="${detailPostsDTO.postsId}" hidden>
            <%--管理员身份显示所有按钮--%>
            <c:if test="${userAccInfoDTO!=null&&userAccInfoDTO.accType==1}">
                <%--按钮的文本需要动态渲染--%>
                <button type="button" class="btn btn-success" id="thumb"
                        style="height: 38px;width: 92px;font-size: 16px;margin-left: 60px;"></button>
                <button type="button" class="btn btn-success" id="mark"
                        style="height: 38px;width: 92px;font-size: 16px;margin-left: 20px"></button>
                <button type="button" class="btn btn-success" id="top"
                        style="height: 38px;width: 92px;font-size: 16px;margin-left: 20px"></button>
            </c:if>
            <%--普通用户只显示点赞按钮，对于游客不显示--%>
            <c:if test="${userAccInfoDTO!=null&&userAccInfoDTO.accType==0}">
                <button type="button" class="btn btn-success" id="thumb"
                        style="height: 38px;width: 92px;font-size: 16px;margin-left: 150px;"></button>
            </c:if>
        </div>
    </div>
    <div class="comment-num" id="comment-num">
    </div>
    <div class="comment-container">
        <div class="comment-card-body" id="comment-body">
            <div class="comment-edit">
                <div class="avatar">
                    <img src="../static/images/user-64.png" class="avatar">
                </div>
                <div class="comment-edit-input">
                    <input type="text" placeholder="撰写评论..." class="form-control" style="width: 100%" id="edit-comment">
                </div>
                <div class="commit-btn">
                    <button type="button" class="btn btn-success" id="commit-comment"
                            style="height: 38px;width: 92px;font-size: 16px;margin-top: 5px">提交评论</button>
                </div>
            </div>
            <%--<div class='comment-content'>
                <div class='avatar' style='margin-top: -5px'>
                    <img src='../static/images/user-64.png' class='avatar'>
                </div>
                <div class='comment-text-container'>
                    <div class='commentator-name' style='line-height: 55px'>
                        <a class='text-decoration-none' href='userInfoPage?userName=${postsComment.replyUser}'><strong >${postsComment.replyUser}：</strong></a>
                    </div>
                    <div class='content-text'>
                        <p>${postsComment.replyContent}</p>
                    </div>
                </div>
                <div class='reply-date'>
                    评论于 ${postsComment.replyDate}
                </div>
            </div>--%>
        </div>
    </div>
    <div style="width: 100%;height: 100px"></div>
</div>
</body>
<script type="text/javascript" src="../static/js/postdetail.js"></script>
</html>
