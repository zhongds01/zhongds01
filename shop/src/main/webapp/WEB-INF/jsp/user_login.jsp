<%--
  Created by IntelliJ IDEA.
  User: ZDS
  Date: 2019/4/19
  Time: 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <script src="/js/vue-2.5.22.min..js"></script>
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <style type="text/css">
        .form-horizontal{
            background: #fff;
            padding-bottom: 40px;
            border-radius: 15px;
            text-align: center;
        }
        .form-horizontal .heading{
            display: block;
            font-size: 35px;
            font-weight: 700;
            padding: 35px 0;
            border-bottom: 1px solid #f0f0f0;
            margin-bottom: 30px;
        }
        .form-horizontal .form-group{
            padding: 0 40px;
            margin: 0 0 25px 0;
            position: relative;
        }
        .form-horizontal .form-control{
            background: #f0f0f0;
            border: none;
            border-radius: 20px;
            box-shadow: none;
            padding: 0 20px 0 45px;
            height: 40px;
            transition: all 0.3s ease 0s;
        }
        .form-horizontal .form-control:focus{
            background: #e0e0e0;
            box-shadow: none;
            outline: 0 none;
        }
        .form-horizontal .form-group i{
            position: absolute;
            top: 12px;
            left: 60px;
            font-size: 17px;
            color: #c8c8c8;
            transition : all 0.5s ease 0s;
        }
        .form-horizontal .form-control:focus + i{
            color: #00b4ef;
        }
        .form-horizontal .fa-question-circle{
            display: inline-block;
            position: absolute;
            top: 12px;
            right: 60px;
            font-size: 20px;
            color: #808080;
            transition: all 0.5s ease 0s;
        }
        .form-horizontal .fa-question-circle:hover{
            color: #000;
        }
        .form-horizontal .btn{
            float: left;
            font-size: 14px;
            color: #fff;
            background: #00b4ef;
            border-radius: 30px;
            padding: 10px 25px;
            border: none;
            text-transform: capitalize;
            transition: all 0.5s ease 0s;
        }
        @media only screen and (max-width: 479px){
            .form-horizontal .form-group{
                padding: 0 25px;
            }
            .form-horizontal .form-group i{
                left: 45px;
            }
            .form-horizontal .btn{
                padding: 10px 20px;
            }
        }
    </style>
</head>
<body>
<div class="container" id="app">
    <div class="row">
        <div class="col-sm-offset-3 col-sm-6">
            <form class="form-horizontal">
                <span class="heading">用户登录</span>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="用户名" v-model="custName">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" placeholder="密　码" v-model="custPwd">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <%--<div class="main-checkbox">
                        <input type="checkbox" value="None" id="checkbox1" name="check"/>
                        <label for="checkbox1"></label>
                    </div>
                    <span class="text">Remember me</span>--%>
                    <button class="btn btn-default" @click="login(custName,custPwd)">登录</button>
                        <a href="/toRegister.action" style="margin-left:310px;font-size: 15px">注册</a>
                </div>
            </form>
        </div>
    </div>
</div>
<div style="background-color: black" class="navbar-fixed-bottom">
    <h4 align="center">Tel:13260906627</h4>
    <h4 align="center">Email:zhongds01@163.com</h4>
    <h4 align="center">Copyright © 2019 zhongds All Rights Reserved</h4>
</div>
<script>
    new Vue({
        el:'#app',
        data:{
            custName:'',
            custPwd:''
        },
        methods:{
            login:function (custName,custPwd) {
                $.ajax({
                    type:"post",
                    url:"/loginCheck.action",
                    data:{"custName":custName,"custPwd":custPwd},
                    dataType:"json",
                    success:function(data){
                        if (data.msg==="ok"){
                            location.href="/toMain.action";
                        }else {
                            alert("用户名或密码错误！");
                            location.reload();
                        }
                    },
                    error:function(data){
                        console.log(data.msg);
                    }
                });
            }
        }
    });
</script>
</body>
</html>
