<%--
  Created by IntelliJ IDEA.
  User: ZDS
  Date: 2019/4/19
  Time: 4:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager</title>
    <script src="../../js/jquery-3.3.1.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script	src="../../js/vue-2.5.22.min..js"></script>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <script src="../../js/axios-0.18.0.min.js"></script>
    <style  type="text/css">
        .table th, .table td {
            text-align: center;
            font-size: 14px!important;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <h1>管理员门户</h1>
    </div>
    <div class="row" id="app">
        <div class="col-sm-2 column">
            <br><br><br><br>
            <div class="panel-group" id="panel-760710">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-760710" href="#customManager">用户管理</a>
                    </div>
                    <div id="customManager" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <a href="#customInfo" data-toggle="tab">用户信息</a>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-760710" href="#goodsManager">商品管理</a>
                    </div>
                    <div id="goodsManager" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <a href="#goodsInfo" data-toggle="tab">商品信息</a>
                        </div>
                        <div class="panel-body">
                            <a href="#goodsAdd" data-toggle="tab" >商品添加</a>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-760710" href="#ordersManager">订单管理</a>
                    </div>
                    <div id="ordersManager" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <a href="#ordersInfo" data-toggle="tab">订单信息</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-10 tab-content"><%--class="tab-pane active"--%>
            <div id="customInfo" class="tab-pane fade in">
                <jsp:include page="custominfo.jsp"></jsp:include>
            </div>
            <div id="goodsInfo" class="tab-pane fade">
                <jsp:include page="goodsinfo.jsp"></jsp:include >
            </div>
            <div id="goodsAdd" class="tab-pane fade">
                <jsp:include page="goodsadd.jsp"></jsp:include>
            </div>
            <div id="ordersInfo" class="tab-pane fade">
                <jsp:include page="ordersinfo.jsp"></jsp:include>
            </div>
        </div>
    </div>
</div>
</body>
</html>
