
/*
* 返回首页
* */
$("#returnHome").click(function () {
    var url=window.location.pathname;
    var end = url.lastIndexOf("/");
    url = url.substring(0,end);
    window.location.href=url;
});

/*
* 因为按钮每行都要生成所以用name来绑定点击事件
* */
$("button[name='authorize']").click(function () {
    const userName=$(this).parent().prev().prev().prev().text();
    const loginAcc=$(this).parent().prev().prev().text();
    swal({
        title: "你确定对用户"+userName+"授权吗?",
        text: "授权成功后，该用户将拥有管理员权限",
        icon: "warning",
        buttons: true,
        showCancelButton: true,
        showConfirmButton: true,
        cancelButtonText: "取消",
        confirmButtonText:"确认",
        closeOnConfirm: false
    },function (isConfirm) {
        if (isConfirm){
            /*
            * 发送ajax请求到后台进行处理
            * */
            $.ajax({
                method:"post",
                url:"bbs/admin/authorize",
                data:{
                    loginAcc:loginAcc
                },
                dataType:"json",
                success:function (callback) {
                    if (callback.successFlag){
                        swal("授权成功","用户"+userName+"已成为管理员","","success");
                    }else{
                        swal("授权失败","T-T好像出bug了呢...","","error");
                    }
                },
                error:function () {
                    swal("服务异常","遇到了未知错误呢....o(╥﹏╥)....哇~难受","error");
                }
            });

        }
    });
});