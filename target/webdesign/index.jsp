
<%@ page contentType="text/html;charset=UTF-8" %>
<%--导入jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>NCU论坛系统</title>
    <%--导入jquery--%>
    <script src="static/js/jquery.min.js"></script>
    <%--导入Popper.js，这是bootstrap需要的js库--%>
    <script type="text/javascript" src="static/umd/popper.min.js"></script>
    <%--jquerysession.js--%>
    <script src="static/js/jquerysession.js"></script>
    <%--bootstrap的js库--%>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/bootstrap.bundle.min.js"></script>
    <%--bootstrap的样式库--%>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <%--cdn导入--%>
    <%--导入bootstrap的js文件--%>
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.15.0/umd/popper.min.js"
            integrity="sha384-L2pyEeut/H3mtgCBaUNw7KWzp5n9+4pDQiExs933/5QfaTh8YStYFFkOzSoXjlTb" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>--%>
    <%--引入bootstrap样式库--%>
    <%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>
    <%--使用第三方Alert的提示框样式--%>
    <link rel="stylesheet" type="text/css" href="static/css/toastr.css">
    <script type="text/javascript" src="static/js/toastr.min.js"></script>
    <link rel="stylesheet" type="text/css" href="static/css/sweetalert.css">
    <script type="text/javascript" src="static/js/sweetalert-dev.js"></script>
    <%--导入自定义样式表--%>
    <link rel="stylesheet" type="text/css" href="static/css/index.css">
</head>

<%--页面渲染时，设置并接收后端传来的数据--%>
<%--用户信息及账号信息数据传输对象--%>
<c:set var="userAccInfoDTO" scope="session" value="${userAccInfoDTO}"/>
<%--所有的帖子数据传输对象--%>
<c:set var="allPostsDTO" scope="request" value="${allPostsDTO}" />
<%--
    置顶帖数据传输对象
    这里理论是可以用所有帖子数据来渲染置顶帖的
    但当数据量很大时，那样会影响页面渲染或加载速度（因为有判断）
    所有在后端进行该项数据的获取传过来直接渲染
    --%>
<c:set var="topPostsDTO" scope="request" value="${topPostsDTO}"/>

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
                    <a href="bbs" class="text-decoration-none" style="height: 100%;line-height: 34px;color: #009a61;font-weight: bolder">首页</a>
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
                            <a><img src="static/images/login_logo.png" class="avatar-img"/></a>
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
    <%--主模块，左右边界+帖子内容--%>
    <div class="main">
        <div class="left-side">
            <div class="opts-side">
                <button type="button" class="btn btn-light" name="left-side-btn" id="all-notes" style="width: 100%;font-size: 14px;color:#999999;border: 0;text-align: left">所有帖子</button>
                <button type="button" class="btn btn-light" name="left-side-btn" id="my-post" style="width: 100%;margin-top: 15px;font-size: 14px;color:#999999;border: 0;text-align: left">问答帖</button>
                <button type="button" class="btn btn-light" name="left-side-btn" id="boutique-notes" style="width: 100%;margin-top: 15px;font-size: 14px;color:#999999;border: 0;text-align: left">精品帖</button>
            </div>
            <label style="font-size: 14px">技术频道----</label>
            <div class="kind">
                <div class="kind-opt" style="margin-top: 0">
                    <button type="button" value="前端" class="btn btn-light" name="left-side-btn" style="width: 100%;margin-top: 10px;font-size: 14px;color:#999999;border: 0;text-align: left">
                        <img src="static/images/js.png" style="margin-right: 10px;height: 20px">前端
                    </button>
                </div>
                <div class="kind-opt">
                    <button type="button" value="后端" class="btn btn-light" name="left-side-btn" style="width: 100%;margin-top: 10px;font-size: 14px;color:#999999;border: 0;text-align: left">
                        <img src="static/images/db.png" style="margin-right: 10px;height: 20px">后端
                    </button>
                </div>
                <div class="kind-opt">
                    <button type="button" value="ios" class="btn btn-light" name="left-side-btn" style="width: 100%;margin-top: 10px;font-size: 14px;color:#999999;border: 0;text-align: left">
                        <img src="static/images/ios.png" style="margin-right: 10px;height: 20px">ios
                    </button>
                </div>
                <div class="kind-opt">
                    <button type="button" value="安卓" class="btn btn-light" name="left-side-btn" style="width: 100%;margin-top: 10px;font-size: 14px;color:#999999;border: 0;text-align: left">
                        <img src="static/images/ad.png" style="margin-right: 10px;height: 20px">安卓
                    </button>
                </div>
                <div class="kind-opt">
                    <button type="button" value="小程序" class="btn btn-light" name="left-side-btn" style="width: 100%;margin-top: 10px;font-size: 14px;color:#999999;border: 0;text-align: left">
                        <img src="static/images/sp.png" style="margin-right: 10px;height: 20px">小程序
                    </button>
                </div>
                <div class="kind-opt">
                    <button type="button" value="云计算" class="btn btn-light" name="left-side-btn" style="width: 100%;margin-top: 10px;font-size: 14px;color:#999999;border: 0;text-align: left">
                        <img src="static/images/cloud.png" style="margin-right: 10px;height: 20px">云计算
                    </button>
                </div>
                <div class="kind-opt">
                    <button type="button" value="工具" class="btn btn-light" name="left-side-btn" style="width: 100%;margin-top: 10px;font-size: 14px;color:#999999;border: 0;text-align: left">
                        <img src="static/images/tool.png" style="margin-right: 10px;height: 20px">工具
                    </button>
                </div>
                <div class="kind-opt">
                    <button type="button" value="AI" class="btn btn-light" name="left-side-btn" style="width: 100%;margin-top: 10px;font-size: 14px;color:#999999;border: 0;text-align: left">
                        <img src="static/images/ai.png" style="margin-right: 10px;height: 20px">AI
                    </button>
                </div>
                <div class="kind-opt">
                    <button type="button" value="安全" class="btn btn-light" name="left-side-btn" style="width: 100%;margin-top: 10px;font-size: 14px;color:#999999;border: 0;text-align: left">
                        <img src="static/images/safe.png" style="margin-right: 10px;height: 20px">安全
                    </button>
                </div>
                <div class="kind-opt">
                    <button type="button" value="其他专题" class="btn btn-light" name="left-side-btn" style="width: 100%;margin-top: 10px;font-size: 14px;color:#999999;border: 0;text-align: left">
                        <img src="static/images/no.png" style="margin-right: 10px;height: 20px">其他专题
                    </button>
                </div>
            </div>
        </div>
        <div class="center-content">
            <!--顶部轮播-->
            <div class="slide-show">
                <div id="carouselExampleInterval" class="carousel slide" data-ride="carousel" style="height: 100%;width: 100%;border-radius: 20px;">
                    <div class="carousel-inner">
                        <div class="carousel-item active" data-interval="10000">
                            <img src="static/images/1212.png"  alt="..." style="width: 100%;height: 150px;">
                        </div>
                        <div class="carousel-item" data-interval="2000">
                            <img src="static/images/2020.jpg" style="width: 100%;height: 150px;" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="static/images/regs.png" style="width: 100%;height: 150px;" alt="...">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleInterval" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleInterval" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
            <!-- 页码选择,帖子内容不为空时显示-->
            <c:if test="${allPostsDTO!=null}">
                <div class="page-select" id="page-select">
                    <div style="width: 80px;font-size: 14px;display: inline-block">分页选择：</div>
                    <div style="width: 580px;height: 50px;margin-left: 1px;display: inline-block">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Previous" id="previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <li class="page-item active" id="headPage"><a class="page-link" href="#" >1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item"><a class="page-link" href="#">4</a></li>
                                <li class="page-item" id="tailPage"><a class="page-link" href="#">5</a></li>
                                <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Next" id="next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </c:if>
            <!--帖子内容-->
            <div class="card-body" id="card-body">
                <c:if test="${allPostsDTO==null}">
                    <div  style='text-align: center;width: 100%;margin-top: 50px'>论坛还没有任何用户发表帖子呢，快去抢沙发吧！</div>
                </c:if>
                <c:if test="${allPostsDTO!=null}">
                    <c:forEach items="${allPostsDTO}" var="post">
                        <div class="note-card">
                            <div class="note-tile"><h4 style="color: #212121">${post.title}</h4></div>
                            <div class="note-content">${post.content}</div>
                            <div class="note-opt">
                                <!--该隐藏的输入框用于存放帖子的id-->
                                <input value="${post.postId}" hidden>
                                <!--点赞按钮，只有注册的用户才可以为帖子点赞-->
                                <button type="button" class="btn btn-light"  name="thumb" style="width: 36px;height:36px;font-size: 14px;font-weight:bolder;border: 0;text-align: center;
                        border-radius: 50%;-moz-border-radius: 50%;-webkit-border-radius: 50%; color: #009a61">赞</button>
                                ●&nbsp;<span style="color: #009a61;font-weight: bolder;font-size: 14px">${post.thumbNum}</span>
                                <!--此处显示发帖用户的用户名-->
                                <button type="button" class="btn btn-light"  style="width: 20%;font-size: 14px;color:#999999;border: 0;text-align: center;background: #FFFFFF;margin-left: 10px">${post.postUser}</button>
                                <!--此处显示发帖时间-->
                                <button type="button" class="btn btn-light"  style="width: 30%;font-size: 14px;color:#999999;border: 0;text-align: left;background: #FFFFFF;margin-left: 10px">${post.postDate}</button>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
        <div class="right-side">
            <div class="adv-img">
                <a href="https://www.bt.cn"><img src="static/images/bt.png"  style="width: 100%;height: 136px"></a>
            </div>
            <div style="width: 100%;height: 20px;font-size: 12px;text-align: center">图片广告位，现在折价中哦......</div>
            <div style="width: 100%;height: 30px;font-size: 17px;color: #009a61;font-weight: bolder;margin-top: 50px;text-align: center">----------置顶帖----------</div>
            <!--被置顶的帖-->
            <c:if test="${topPostsDTO!=null}">
                <c:forEach items="${topPostsDTO}" var="topPost">
                    <div class="boutique-recommend">
                        <div style="width: 100%;height: 32px;display: block">
                            <span style="font-size: 17px;font-weight: bold">${topPost.title}</span>
                        </div>
                        <div style="width: 100%;height: 1.5px;background: #999999"></div>
                        <div class="top-post-content">
                            ${topPost.content}
                        </div>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${topPostsDTO==null}">
                <div style="width: 100%;text-align: center;margin-top: 5%">暂无置顶帖哦</div>
            </c:if>
        </div>
    </div>
    <footer class="footer-content">
        <label style="font-size: 14px;line-height: 120px;color: #999999">CopyRight   @南昌大学信息工程学院-Wan HaoDong
            &nbsp;&nbsp;&nbsp;&nbsp;2017级信息学院WEB程序设计期末作业项目</label>
    </footer>
</div>
</body>
<%--导入自定义js文件--%>
<script src="static/js/index.js"></script>
<%--<script type="text/javascript">
    var allPostsData=[];
</script>--%>
</html>
