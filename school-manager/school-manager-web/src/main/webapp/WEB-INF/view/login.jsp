<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/1/2
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员登录-WeAdmin Frame型后台管理系统-WeAdmin 1.0</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="shortcut icon" href="./favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="./static/css/font.css">
    <link rel="stylesheet" href="./static/css/weadmin.css">
    <script src="../lib/jquery/jquery-3.3.1.min.js" ></script>
    <script src="./lib/layui/layui.js" charset="utf-8"></script>

</head>
<body class="login-bg">

<div class="login">
    <div class="message">网校-管理登录</div>
    <div id="darkbannerwrap"></div>

    <form method="post" class="layui-form">
        <input name="username" placeholder="用户名" type="text" lay-verify="required" class="layui-input">
        <hr class="hr15">
        <input name="password" lay-verify="required" placeholder="密码" type="password" class="layui-input">
        <hr class="hr15">
        <div>
            <div style="float: left; width: 70%;"><input name="code" lay-verify="required" placeholder="验证码" type="text" class="layui-input"></div>
            <div style="float: left; width: 30%;"><img class="codeImage" src="${baseUrl}sys/util/codeImage?1" style="width: 100%; height: 50px;"></div>
        </div>

        <hr class="hr15">
        <input class="loginin" value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20">
    </form>
</div>

<script type="text/javascript">

    layui.extend({
        admin: '{/}./static/js/admin'
    });
    layui.use(['form', 'admin'], function () {
        var form = layui.form
            , admin = layui.admin;
        // layer.msg('玩命卖萌中', function(){
        //   //关闭后的操作
        //   });
        //监听提交
        form.on('submit(login)', function (data) {
            // alert(888)

            var index = layer.msg('登录中...', {
                icon: 16
                , shade: 0.01
            });

            $.ajax({
                url: '${baseUrl}sys/user/login',
                type: 'POST', //GET
                async: true,    //或false,是否异步
                data: {
                    username: data.field.username,
                    password: data.field.password,
                    code:data.field.code
                },
                timeout: 5000,    //超时时间
                dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
                beforeSend: function (xhr) {
                    console.log(xhr)
                    console.log('发送前')
                },
                success: function (data, textStatus, jqXHR) {
                    if(data.code === 0){
                        layer.msg('登陆成功', {
                            icon: 6,
                            end:function () {
                                localStorage.setItem('token', data.data);
                                location.href = './index.html';
                            }
                        });
                    }else{
                        layer.msg(data.msg, {
                            icon: 5
                        });
                    }


                },
                error: function (xhr, textStatus) {
                    layer.msg('错误', {
                        icon: 4
                    });
                }
            });

            return false;
        });
    });

    $('.codeImage').click(function () {
        refreshImage();
    });

    function refreshImage() {
        $('.codeImage').attr('src', '${baseUrl}sys/util/codeImage?_=' + Math.random());
    }
</script>
<!-- 底部结束 -->
</body>
</html>