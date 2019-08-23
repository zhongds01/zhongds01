<%--
  Created by IntelliJ IDEA.
  User: ZDS
  Date: 2019/4/21
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的信息</title>
    <!-- 引入Bootstrap核心样式文件 -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入jQuery核心js文件 -->
    <script src="../../js/jquery-3.3.1.min.js"></script>
    <!-- 引入BootStrap核心js文件 -->
    <script src="../../js/bootstrap.min.js"></script>
    <script	src="../../js/vue-2.5.22.min..js"></script>
    <script src="../../js/axios-0.18.0.min.js"></script>
</head>
<body>
    <div class="container" id="app">
        <div>
            <div class="row">
                <div class="col-sm-9">
                    <h1>我的信息</h1>
                </div>
                <div class="col-sm-2 " style="margin-top: 18px">
                    <button class="btn  btn-default" @click="toMain">返回首页</button>
                </div>
            </div>
            <table class="table table-cell">
                <tbody>
                <tr>
                    <td>用户名称</td>
                    <td>{{customs.custName}}</td>
                </tr>
                <tr>
                    <td>用户性别</td>
                    <td>{{customs.custSex}}</td>
                </tr>
                <tr>
                    <td>用户电话</td>
                    <td>{{customs.custTel}}</td>
                </tr>
                <tr>
                    <td>用户邮箱</td>
                    <td>{{customs.custEmail}}</td>
                </tr>
                <tr>
                    <td>用户地址</td>
                    <td>{{customs.custAddress}}</td>
                </tr>
                <tr>
                    <td>注册时间</td>
                    <td>{{customs.createDate}}</td>
                </tr>
                <tr>
                    <td>最后修改时间</td>
                    <td>{{customs.modifyDate}}</td>
                </tr>
                </tbody>
            </table>

            <button class="btn btn-default" data-toggle="modal" data-target="#myModal">修改信息</button>
        </div>
    <%--modify modal--%>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">个人信息修改</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label for="custName" class="col-sm-2 control-label">用户名称</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="custName" v-model="customs.custName" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="custSex" class="col-sm-2 control-label">用户性别</label>
                                <div class="col-sm-10">
                                    <select id="custSex" class="form-control" v-model="customs.custSex">
                                        <option>男</option>
                                        <option>女</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="custTel" class="col-sm-2 control-label">用户电话</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="custTel" v-model="customs.custTel" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="custEmail" class="col-sm-2 control-label">用户邮箱</label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" id="custEmail" v-model="customs.custEmail" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="custAddress" class="col-sm-2 control-label">用户地址</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="custAddress" v-model="customs.custAddress" />
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" @click="modify">提交更改</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
    </div>
</body>
<script>
    new Vue({
        el:'#app',
        data:{
            customs:{}
        },
        methods:{
            getInfo(){
                const _this = this;
                $.ajax({
                    type:"post",
                    url:"/myInfo.action",
                    dataType:"json",
                    success:function(data){
                        _this.customs = data;
                    },
                    error:function(data){
                        console.log(data);
                    }
                });
            },
            modify(){
                const _this = this;
                $.ajax({
                    type:"post",
                    url:"/modifyCustom.action",
                    data:{
                        customs:JSON.stringify(_this.customs)
                    },
                    dataType:"json",
                    success:function(data){
                        if (data.msg==="ok"){
                            alert("修改成功");
                            location.reload();
                        }else{
                            alert("修改失败");
                        }
                    },
                    error:function(data){
                        console.log(data);
                    }
                });
            },
            toMain(){
                location.href="/toMain.action";
            }
        },
        mounted(){
            this.getInfo();
        }
    })
</script>
</html>
