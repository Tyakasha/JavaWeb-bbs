<%@ page contentType="text/html;charset=UTF-8" %>
<%--导入jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户信息</title>
    <%--引入bootstrap样式库--%>
    <%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>
    <%--引入bootstrap的js库（包括jquery和其他第三方js库）--%>
    <%--
               跳转之后因为加了父级路径bbs
               因此这里再导入静态资源时要使用相对路径不能再用绝对路径
               否则会导入不了（404）
    --%>
    <script src="../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../static/umd/popper.min.js"></script>
    <%--jquerysession.js--%>
    <script src="../static/js/jquerysession.js"></script>
    <script src="../static/js/bootstrap.min.js"></script>
    <script src="../static/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="../static/css/bootstrap.min.css">
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.15.0/umd/popper.min.js"
            integrity="sha384-L2pyEeut/H3mtgCBaUNw7KWzp5n9+4pDQiExs933/5QfaTh8YStYFFkOzSoXjlTb" crossorigin="anonymous"></script>--%>
    <%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>--%>
    <%--使用第三方Alert的提示框样式--%>
    <link rel="stylesheet" type="text/css" href="../static/css/toastr.css">
    <script type="text/javascript" src="../static/js/toastr.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../static/css/sweetalert.css">
    <script type="text/javascript" src="../static/js/sweetalert-dev.js"></script>
    <%--导入自定义样式表--%>
    <link rel="stylesheet" type="text/css" href="../static/css/userpage.css">
</head>

<c:set var="userAccInfoDTO" scope="session" value="${userAccInfoDTO}"/>
<c:set var="userInfoPageDTO" scope="request" value="${userInfoPageDTO}" />
<c:set var="myPostsDTO" scope="request" value="${myPostsDTO}" />
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
                        <%--
                                 用户信息所在的path是：/bbs/userInfoPage 是个二级路径
                                 而用户管理和帖子管理的path也是二级路径，所以同级且父级路径相同的
                                 情况下，href只写最后一级就好,不能加 / 加了就表示绝对路径了
                        --%>
                        <div class="link" id="userManage">
                            <a href="userManage" class="text-decoration-none" style="height: 100%;line-height: 34px;color: #009a61;">用户管理</a>
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
                            <a class="dropdown-item" href="#">账户信息</a>
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
    <div class="info">
        <div class="info-container">
            <div class="img-container-outer">
                <div class="img-container">
                    <img src="../static/images/user-256.png"  class="avatar-pos">
                </div>
                <%--
                        用户只有登录时并且是查看自己信息时
                        才显示详细信息，未登录查看或被其他用户查看
                        都只显示用户名被点赞数已经注册时间
                --%>
                <c:if test="${userAccInfoDTO!=null&&(userInfoPageDTO.userName==userAccInfoDTO.userName)}">
                    <div class="point-info">账户积分：${userInfoPageDTO.points}</div>
                </c:if>
            </div>
            <div class="content-container" style="margin-left: 20px">
                <div class="username-content">
                    <label id="info-userName">${userInfoPageDTO.userName}</label>&nbsp;&nbsp;&nbsp;
                    <div style="height: 100%;width: 280px;display: inline-block;margin-left: -40px" id="userName-block">
                        <input type="text" class="form-control" style="width: 150px;height: 35px;display: inline-block;font-size: 14px" id="userName-input">
                        <button type="button" class="btn btn-success" style="width: 50px;height: 35px;display: inline-block;font-size: 12px;margin-top: 3px"
                                id="save-edit-userName">保存</button>
                        <button type="button" class="btn btn-secondary" style="width: 50px;height: 35px;display: inline-block;font-size: 12px;margin-top: 3px"
                                id="cancel-edit-userName">取消</button>
                    </div>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <%--用户自己才有权利编辑自己的信息--%>
                    <c:if test="${userAccInfoDTO!=null&&(userInfoPageDTO.userName==userAccInfoDTO.userName)}">
                        <a  href="#" class="text-decoration-none"  style="font-size: 12px;" id="edit-userName">编辑</a>
                    </c:if>
                </div>
                <c:if test="${userAccInfoDTO!=null&&(userInfoPageDTO.userName==userAccInfoDTO.userName)}">
                    <div class="opts-content">
                        账户类型&nbsp;&nbsp;&nbsp;${userInfoPageDTO.accType}
                    </div>
                    <div class="opts-content">
                        邮箱&nbsp;&nbsp;&nbsp;${userInfoPageDTO.email}
                    </div>
                    <div class="opts-content">
                        工作性质&nbsp;&nbsp;&nbsp;
                        <label id="info-jobInfo">${userInfoPageDTO.jobCategory}</label>
                        <div style="height: 100%;width: 280px;display: inline-block" id="jobInfo-block">
                            <select class="form-control" style="width: 150px;height: 100%;display: inline-block;font-size: 13px" id="sel-job">
                                <option>学生</option>
                                <option>IT/互联网</option>
                                <option>教育</option>
                                <option>金融</option>
                                <option>艺术/设计</option>
                                <option>服务业</option>
                                <option>交通运输</option>
                                <option>其他</option>
                            </select>
                            <button type="button" class="btn btn-success" style="width: 50px;height: 100%;display: inline-block;font-size: 12px;margin-top: -6px"
                                    id="save-edit-jobInfo">保存</button>
                            <button type="button" class="btn btn-secondary" style="width: 50px;height: 100%;display: inline-block;font-size: 12px;margin-top: -6px"
                                    id="cancel-edit-jobInfo">取消</button>
                        </div>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a  href="#" class="text-decoration-none"  style="font-size: 12px" id="edit-jobInfo">编辑</a>
                    </div>
                    <div class="opts-content">
                        联系电话&nbsp;&nbsp;&nbsp;
                        <label id="info-phoneNum">${userInfoPageDTO.phoneNum}</label>
                        <div style="height: 100%;width: 280px;display: inline-block" id="phoneNum-block">
                            <input type="text" class="form-control" style="width: 150px;height: 100%;display: inline-block" id="phoneNum">
                            <button type="button" class="btn btn-success" style="width: 50px;height: 100%;display: inline-block;font-size: 12px;margin-top: -6px"
                                    id="save-edit-phoneNum">保存</button>
                            <button type="button" class="btn btn-secondary" style="width: 50px;height: 100%;display: inline-block;font-size: 12px;margin-top: -6px"
                                    id="cancel-edit-phoneNum">取消</button>
                        </div>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a  href="#" class="text-decoration-none"  style="font-size: 12px" id="edit-phoneNum">编辑</a>
                    </div>
                </c:if>
            </div>
            <div class="content-container" style="background: #EEEEEE">
                <div style="background: #E3E3E3;height: 35px;width: 100%;border-radius: 5px" >
                    <div class="round-dots-content" style="background: #FF5F57;margin-left: 10px;margin-top: 10px"></div>
                    <div class="round-dots-content" style="background: #FFBD2E"></div>
                    <div class="round-dots-content" style="background: #28CA42"></div>
                </div>
                <div class="public-content" >
                    被点赞数 ${userInfoPageDTO.beenThumbNum}
                </div>
                <div class="public-content-other">
                    注册于 ${userInfoPageDTO.registerDate}
                </div>
            </div>
        </div>
    </div>
    <div class="main-container">
        <div class="left-side">
            <div class="opts-content-left" style="margin-top: 30px">
                <button type="button" value="myPosts" class="btn btn-light" id="myPost-btn" name="left-side-btn" style="width: 100%;margin-top: 10px;font-size: 14px;color:#575757;border: 0;text-align: left">
                    <%--登录录了且两用户名相等说明看的是自己的信息--%>
                    <c:if test="${userAccInfoDTO!=null&&(userAccInfoDTO.userName==userInfoPageDTO.userName)}">
                        我发布的
                    </c:if>
                    <%--未登录时或两用户名不相等时说名看的是别人的信息--%>
                    <c:if test="${userAccInfoDTO==null||(userAccInfoDTO.userName!=userInfoPageDTO.userName)}">
                        他发布的
                    </c:if>
                </button>
            </div>
            <div class="opts-content-left">
                <button type="button" value="myAnswerPosts" class="btn btn-light" name="left-side-btn" style="width: 100%;margin-top: 10px;font-size: 14px;color:#575757;border: 0;text-align: left">
                    <%--登录录了且两用户名相等说明看的是自己的信息--%>
                    <c:if test="${userAccInfoDTO!=null}">
                        <c:if test="${userAccInfoDTO.userName==userInfoPageDTO.userName}">
                            我回答的
                        </c:if>
                    </c:if>
                    <%--未登录时或两用户名不相等时说名看的是别人的信息--%>
                    <c:if test="${userAccInfoDTO==null||(userAccInfoDTO.userName!=userInfoPageDTO.userName)}">
                        他回答的
                    </c:if>
                </button>
            </div>
            <div class="opts-content-left">
                <button type="button" value="myQuestionPosts" class="btn btn-light" name="left-side-btn" style="width: 100%;margin-top: 10px;font-size: 14px;color:#575757;border: 0;text-align: left">
                    <%--登录录了且两用户名相等说明看的是自己的信息--%>
                    <c:if test="${userAccInfoDTO!=null&&(userAccInfoDTO.userName==userInfoPageDTO.userName)}">
                        我提问的
                    </c:if>
                    <%--未登录时或两用户名不相等时说名看的是别人的信息--%>
                    <c:if test="${userAccInfoDTO==null||(userAccInfoDTO.userName!=userInfoPageDTO.userName)}">
                        他提问的
                    </c:if>
                </button>
            </div>
            <div class="opts-content-left">
                <button type="button" value="beenThumbedPosts" class="btn btn-light" name="left-side-btn" style="width: 100%;margin-top: 10px;font-size: 14px;color:#575757;border: 0;text-align: left">
                    <%--登录录了且两用户名相等说明看的是自己的信息--%>
                    <c:if test="${userAccInfoDTO!=null&&(userAccInfoDTO.userName==userInfoPageDTO.userName)}">
                        我的被赞帖
                    </c:if>
                    <%--未登录时或两用户名不相等时说名看的是别人的信息--%>
                    <c:if test="${userAccInfoDTO==null||(userAccInfoDTO.userName!=userInfoPageDTO.userName)}">
                        他的被赞帖
                    </c:if>
                </button>
            </div>
        </div>
        <div class="right-side">
            <div class="menu-title" id="menu-title"></div>
            <div  id="posts-info-container">
                <c:if test="${myPostsDTO!=null}">
                    <c:forEach items="${myPostsDTO}" var="myPost">
                        <div class='lists-group'>
                            <div class='top-line' style='width: 100%;height: 1.5px;background: #999999;'></div>
                            <input value='${myPost.postsId}' hidden>
                            <div class='content-lists'>
                                <div style='background: #FCF8E3' class='thumb-num'>获赞 ${myPost.thumbNum}</div>
                                <div class='posts-info'>${myPost.title}</div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${myPostsDTO==null}">
                    <div style='width: 80%;height: 100px;line-height: 100px;font-size: 15px;font-weight: bolder;text-align: center'>
                        您当前还没有发布过任何帖子哦~
                    </div>
                </c:if>
            </div>
        </div>
    </div>
    <footer class="footer-content">
        <label style="font-size: 14px;line-height: 120px;color: #999999">CopyRight   @南昌大学信息工程学院-Wan HaoDong
            &nbsp;&nbsp;&nbsp;&nbsp;2017级信息学院WEB程序设计期末作业项目</label>
    </footer>
</div>
</body>
<script type="text/javascript" src="../static/js/userpage.js"></script>
</html>