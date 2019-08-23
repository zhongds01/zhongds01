<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>首页</title>
    <!-- 引入Bootstrap核心样式文件 -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入jQuery核心js文件 -->
    <script src="../../js/jquery-3.3.1.min.js"></script>
    <!-- 引入BootStrap核心js文件 -->
    <script src="../../js/bootstrap.min.js"></script>
    <script	src="../../js/vue-2.5.22.min..js"></script>
    <script src="../../js/axios-0.18.0.min.js"></script>
</head>
<%
    String custName = (String)request.getSession().getAttribute("session");
%>
<body>

<div id="app">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-6">
                <img src="/img/logo.png" />
            </div>
            <div class="col-lg-5 col-md-4 hidden-xs col-sm-6">

            </div>
            <div class="col-lg-3 col-md-4 col-sm-12" style="padding-top: 20px;">
                <button class="btn btn-lg btn-default dropdown-toggle" data-toggle="dropdown"><%=custName%><strong class="caret"></strong></button>
                <ul class="dropdown-menu">
                    <li>
                        <a href="#" @click="toShopCar">我的购物车</a>
                    </li>
                    <li>
                        <a href="#" @click="toOrders">我的订单</a>
                    </li>
                    <li>
                        <a href="#" @click="toMyinfo">我的信息</a>
                    </li>
                    <li class="divider">
                    </li>
                    <li>
                        <a href="#" @click="toExit">退出登陆</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <!--导航栏-->
    <div class="container" style="margin-top: 10px;">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">首页</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="javascript:void (0)" @click="searchByCata1">手机数码<span class="sr-only">(current)</span></a>
                        </li>
                        <li>
                            <a href="javascript:void (0)" @click="searchByCata2">家用电器</a>
                        </li>
                        <li>
                            <a href="javascript:void (0)" @click="searchByCata3">美味食品</a>
                        </li>
                        <li>
                            <a href="javascript:void (0)" @click="searchByCata4">儿童玩具</a>
                        </li>
                        <li>
                            <a href="javascript:void (0)" @click="searchByCata5">美丽装饰</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">所有分类 <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="javascript:void (0)" @click="searchByCata1">手机数码</a>
                                </li>
                                <li>
                                    <a href="javascript:void (0)" @click="searchByCata2">家用电器</a>
                                </li>
                                <li>
                                    <a href="javascript:void (0)" @click="searchByCata3">美味食品</a>
                                </li>
                                <li role="separator" class="divider"></li>
                                <li>
                                    <a href="javascript:void (0)" @click="searchByCata4">儿童玩具</a>
                                </li>
                                <li role="separator" class="divider"></li>
                                <li>
                                    <a href="javascript:void (0)" @click="searchByCata5">美丽装饰</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-right">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="GoodsName" v-model="goodsName">
                        </div>
                        <button type="button" class="btn btn-default" @click="searchGoods()">搜索</button>
                    </form>
                </div>
            </div>
        </nav>
    </div>

    <!--轮播图-->
    <div class="container">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="/img/panoramic_forests1.jpg" alt="...">
                    <div class="carousel-caption">
                        ...
                    </div>
                </div>
                <div class="item">
                    <img src="/img/panoramic_forests2.jpg" alt="...">
                    <div class="carousel-caption">
                        ...
                    </div>
                </div>
                <div class="item">
                    <img src="/img/panoramic_forests3.jpg" alt="...">
                    <div class="carousel-caption">
                        ...
                    </div>
                </div>
            </div>

            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    <br>
    <!--热门商品-->
    <div class="container">
        <div class="row">
            <span style="font-size: 30px">
					<a href="javascript:void (0)" @click="recommend()">好货推荐</a>&nbsp;&nbsp;&nbsp;<img src="../../img/little_title.png" />
            </span>
        </div>
    </div>
    <div>
        <%--<a href="javascript:void (0)" class="btn" @click="recommend()">好货推荐</a>--%>
        <hr>
        <div style="width:80%;margin: 0 auto">
            <div v-for="(good, index) in recommendgoods" :key="good.goodsId" style="display: inline-block">
                <br/>
                <div class="card" style="width:355px;height:500px;" >
                    <div>
                        <img style="width: 355px;height: 355px" :src="'/images/'+good.goodsPic" alt="Goods image">
                    </div>
                    <div class="card-body" style="width:355px;height:145px">
                        <h4 style="color: red">&nbsp;￥{{good.goodsPrice}}&nbsp;</h4>
                        <p>&nbsp;商品名称：{{good.goodsName}}&nbsp;&nbsp;库存：{{good.goodsStock}}</p>
                        <p>&nbsp;类别：{{good.goodsCata}}</p>
                        <p>&nbsp;描述：&nbsp;{{good.goodsDesc}}</p>
                        <p>&nbsp;最新评论：&nbsp;{{good.goodsComment}}</p>
                        <button @click="addcar(good)" class="btn btn-default btn-warning" :disabled="good.gCount<=0">加入购物车</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <hr>
    <%-- 全部商品 --%>
    <div class="container">
        <div class="row">
				<span style="font-size: 30px;">
					热门商品&nbsp;&nbsp;&nbsp;<img src="../../img/little_title.png" />
				</span>
        </div>
    </div>
    <div id="showAllGoods">
        <div style="width:80%;margin: 0 auto">
            <div v-for="(good, index) in goods" :key="good.goodsId" style="display: inline-block">
                <br/>
                <div class="card" style="width:355px;height:500px;" >
                    <div>
                        <img style="width: 355px;height: 355px" :src="'/images/'+good.goodsPic" alt="Goods image">
                    </div>
                    <div class="card-body" style="width:355px;height:145px">
                        <h4 style="color: red">&nbsp;￥{{good.goodsPrice}}&nbsp;</h4>
                        <p>&nbsp;商品名称：{{good.goodsName}}&nbsp;&nbsp;库存：{{good.goodsStock}}</p>
                        <p>&nbsp;类别：{{good.goodsCata}}</p>
                        <p>&nbsp;描述：&nbsp;{{good.goodsDesc}}</p>
                        <p>&nbsp;最新评论：&nbsp;{{good.goodsComment}}</p>
                        <button @click="addcar(good)" class="btn btn-default btn-warning" :disabled="good.gCount<=0">加入购物车</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<br><br><br><br>
<div >
    <h4 align="center">Tel:13260906627</h4>
    <h4 align="center">Email:zhongds01@163.com</h4>
    <h4 align="center">Copyright © 2019 zhongds All Rights Reserved</h4>
</div>


<script>
    new Vue({
        el: '#app',
        data: {
            goods:[],
            recommendgoods:[],
            goodsName:''
        },
        methods:{
            getAllGoodsInfo:function(){
                const _this = this;
                return axios.get('/getAllGoods.action').then(function (res) {
                    console.log(res.data);
                    _this.goods = res.data;
                }).catch(function (error) {
                    console.log(error.response);
                });
            },
            addcar:function (good) {
                $.ajax({
                    type:"post",
                    url:"/addToShopCar.action",
                    data:{
                        "goodsId":good.goodsId,
                        "goodsName":good.goodsName,
                        "goodsPrice":good.goodsPrice,
                    },
                    dataType:"json",
                    success:function(data){
                        if (data.msg==="ok"){
                            alert("添加成功！");
                        }else{
                            alert("添加失败");
                        }
                    },
                    error:function(data){
                        console.log(data);
                    }
                });
            },
            toShopCar(){
                location.href="/toShopCar.action";
            },
            toOrders(){
                location.href="/toOrders.action";
            },
            toExit(){
                location.href="/toExit.action";
            },
            toMyinfo(){
                location.href="/toMyinfo.action";
            },
            recommend(){
                const _this = this;
                return axios.get('/recommend.action').then(function (res) {
                    console.log(res.data);
                    _this.recommendgoods = res.data;
                }).catch(function (error) {
                    console.log(error.response);
                });
            },
            searchGoods(){
                const _this = this;
                $.ajax({
                    type:"post",
                    url:"/searchGoods.action",
                    data:{
                        goodsName:_this.goodsName
                    },
                    dataType:"json",
                    success:function(data){
                        _this.goods = data;
                    },
                    error:function(data){
                        console.log(data);
                    }
                })
            },
            searchByCata1(){
                const _this = this;
                $.ajax({
                    type:"post",
                    url:"/searchGoodsByCata.action",
                    data:{
                        goodsCata:"数码"
                    },
                    dataType:"json",
                    success:function(data){
                        _this.goods = data;
                    },
                    error:function(data){
                        console.log(data);
                    }
                })
            },
            searchByCata2(){
                const _this = this;
                $.ajax({
                    type:"post",
                    url:"/searchGoodsByCata.action",
                    data:{
                        goodsCata:"家电"
                    },
                    dataType:"json",
                    success:function(data){
                        _this.goods = data;
                    },
                    error:function(data){
                        console.log(data);
                    }
                })
            },
            searchByCata3(){
                const _this = this;
                $.ajax({
                    type:"post",
                    url:"/searchGoodsByCata.action",
                    data:{
                        goodsCata:"食品"
                    },
                    dataType:"json",
                    success:function(data){
                        _this.goods = data;
                    },
                    error:function(data){
                        console.log(data);
                    }
                })
            },
            searchByCata4(){
                const _this = this;
                $.ajax({
                    type:"post",
                    url:"/searchGoodsByCata.action",
                    data:{
                        goodsCata:"玩具"
                    },
                    dataType:"json",
                    success:function(data){
                        _this.goods = data;
                    },
                    error:function(data){
                        console.log(data);
                    }
                })
            },
            searchByCata5(){
                const _this = this;
                $.ajax({
                    type:"post",
                    url:"/searchGoodsByCata.action",
                    data:{
                        goodsCata:"饰品"
                    },
                    dataType:"json",
                    success:function(data){
                        _this.goods = data;
                    },
                    error:function(data){
                        console.log(data);
                    }
                })
            },
        },
        mounted() {
            this.getAllGoodsInfo();
        }
    });
</script>
</body>
</html>
