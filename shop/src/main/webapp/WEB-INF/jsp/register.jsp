<%--
  Created by IntelliJ IDEA.
  User: ZDS
  Date: 2019/4/19
  Time: 1:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <!-- 引入Bootstrap核心样式文件 -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入jQuery核心js文件 -->
    <script src="../../js/jquery-3.3.1.min.js"></script>
    <!-- 引入BootStrap核心js文件 -->
    <script src="../../js/bootstrap.min.js"></script>
    <script	src="../../js/vue-2.5.22.min..js"></script>
    <script src="../../js/axios-0.18.0.min.js"></script>
</head>
<body background="../../img/5.jpg">
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <h1 style="text-align: center">Welcome Register</h1>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-sm-3"></div>
        <div class="col-md-5 column">
            <form class="form-horizontal" role="form" action="/customRegister.action" method="post">
                <div class="form-group">
                    <label for="inputCustName" class="col-sm-3 control-label">用户名</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" id="inputCustName" name="custName" />
                    </div>
                    <div id="warnMsg1" style="display: none;margin-left: 150px;font-size: 20px">ok</div>
                </div>
                <%--<div id="warnMsg" style="display: none;margin-left: 150px;margin-bottom: 11px"></div>--%>
                <div class="form-group">
                    <label for="inputPassword" class="col-sm-3 control-label">密码</label>
                    <div class="col-sm-7">
                        <input type="password" class="form-control" name="custPwd" id="inputPassword" />
                    </div>
                    <div id="warnMsg2" style="display: none;margin-left: 150px;font-size: 20px">ok</div>
                </div>
                <div class="form-group">
                    <label for="repeatPassword" class="col-sm-3 control-label">确认密码</label>
                    <div class="col-sm-7">
                        <input type="password" class="form-control" id="repeatPassword" />
                    </div>
                    <div id="warnMsg3" style="display: none;margin-left: 150px;font-size: 20px">ok</div>
                </div>
                <div class="form-group">
                    <label for="inputSex" class="col-sm-3 control-label">性别</label>
                    <div class="col-sm-7">
                        <select name="custSex" id="inputSex" class="form-control">
                            <option>男</option>
                            <option>女</option>
                        </select>
                    </div>
                    <div id="warnMsg4" style="display: none;margin-left: 150px;font-size: 20px">ok</div>
                </div>
                <div class="form-group">
                    <label for="inputPhone" class="col-sm-3 control-label">电话</label>
                    <div class="col-sm-7">
                        <input type="number" class="form-control" name="custTel" id="inputPhone" />
                    </div>
                    <div id="warnMsg5" style="display: none;margin-left: 150px;font-size: 20px">ok</div>
                </div>
                <div class="form-group">
                    <label for="inputEmail" class="col-sm-3 control-label">邮箱</label>
                    <div class="col-sm-7">
                        <input type="email" class="form-control" name="custEmail" id="inputEmail" />
                    </div>
                    <div id="warnMsg6" style="display: none;margin-left: 150px;font-size: 20px">ok</div>
                </div>
                <div class="form-group">
                    <label for="inputAddress" class="col-sm-3 control-label">地址</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="custAddress" id="inputAddress" />
                    </div>
                    <div id="warnMsg7" style="display: none;margin-left: 150px;font-size: 20px">ok</div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-7">
                        <button id="inputSubmit" type="submit" class="btn btn-default" style="width: 256px">注册</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-sm-3"></div>
    </div>
</div>
</body>
<script>
    $(function(){
        $("#inputCustName").blur(function () {
            var custName = $("#inputCustName").val();
            if (custName===""||custName===null){
                $("#warnMsg1").html("<span class='glyphicon  glyphicon-remove'>用户名不能为空</span>");
                $("#warnMsg1").show();
            }else{
                $.ajax({
                    type:"post",
                    url:"/checkName.action",
                    data:{custName:custName},
                    dataType:"json",
                    success:function(data){
                        if (data.msg==="error"){
                            $("#warnMsg1").html("<span class='glyphicon  glyphicon-ok'>用户名可以使用</span>");
                            $("#warnMsg1").show();
                        }else{
                            $("#warnMsg1").html("<span class='glyphicon  glyphicon-remove'>用户名已存在</span>");
                            $("#warnMsg1").show();
                        }
                    },
                });
            }
        });
        $("#inputPassword").blur(function () {
            var password = $("#inputPassword").val();
            if (!(password===""||password===null)){
                $("#warnMsg2").html("<span class='glyphicon  glyphicon-ok'></span>");
                $("#warnMsg2").show();
            }else{
                $("#warnMsg2").html("<span class='glyphicon  glyphicon-remove'></span>");
                $("#warnMsg2").show();
            }
        });
        $("#repeatPassword").blur(function () {
            var password = $("#inputPassword").val();
            var repeatpassword = $("#repeatPassword").val();
            if (password!=""&&password!=null&&password===repeatpassword){
                $("#warnMsg3").html("<span class='glyphicon  glyphicon-ok'></span>");
                $("#warnMsg3").show();
            }else{
                $("#warnMsg3").html("<span class='glyphicon  glyphicon-remove'></span>");
                $("#warnMsg3").show();
            }
        });
        $("#inputSex").blur(function () {
            $("#warnMsg4").html("<span class='glyphicon  glyphicon-ok'></span>");
            $("#warnMsg4").show();
        });
        $("#inputPhone").blur(function () {
            var custPhone = $("#inputPhone").val();
            if (!(/^1[34578]\d{9}$/.test(custPhone))){
                $("#warnMsg5").html("<span class='glyphicon  glyphicon-remove'></span>");
                $("#warnMsg5").show();
            }else{
                $("#warnMsg5").html("<span class='glyphicon  glyphicon-ok'></span>");
                $("#warnMsg5").show();
            }
        });
        $("#inputEmail").blur(function () {
            var email = $("#inputEmail").val();
            if (!(/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test(email))){
                $("#warnMsg6").html("<span class='glyphicon  glyphicon-remove'></span>");
                $("#warnMsg6").show();
            }else{
                $("#warnMsg6").html("<span class='glyphicon  glyphicon-ok'></span>");
                $("#warnMsg6").show();
            }
        });
        $("#inputAddress").blur(function () {
            var custAddress = $("#inputAddress").val();
            if (!(custAddress===null||custAddress==="")){
                $("#warnMsg7").html("<span class='glyphicon  glyphicon-ok'></span>");
                $("#warnMsg7").show();
            }else{
                $("#warnMsg7").html("<span class='glyphicon  glyphicon-remove'></span>");
                $("#warnMsg7").show();
            }
        });
    });
</script>
</html>
