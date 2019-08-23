<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>订单</title>
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
    <div class="row">
        <div class="col-sm-9">
            <h1>我的订单</h1>
        </div>
        <div class="col-sm-2 " style="margin-top: 10px">
            <button class="btn  btn-default" @click="toMain">&nbsp;&nbsp;返回首页&nbsp;&nbsp;</button>
            <button class="btn  btn-default" @click="toShopCar">返回购物车</button>
        </div>
    </div>
    <hr>
    <div class="row">&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-default" @click="searchFinished()">查看已完成订单</button>&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn  btn-default" @click="searchIng()">查看进行中订单</button></div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th>
                        订单编号
                    </th>
                    <th>
                        商品名称
                    </th>
                    <th>
                        商品数量
                    </th>
                    <th>
                        总价
                    </th>
                    <th>
                        买家姓名
                    </th>
                    <th>
                        买家地址
                    </th>
                    <th>
                        买家电话
                    </th>
                    <th>
                        订单状态
                    </th>
                    <th>
                        创建日期
                    </th>
                    <%----%>
                    <th v-show="flag">
                        评价
                    </th>
                </tr>
                </thead>
                <tbody v-for="(orders,index) in ordersAll":key="orders.orderId">
                <tr>
                    <td>
                        {{orders.orderId}}
                    </td>
                    <td>
                        {{orders.goodsName}}
                    </td>
                    <td>
                        {{orders.goodsMounts}}
                    </td>
                    <td>
                        {{orders.totalPrice}}
                    </td>
                    <td>
                        {{orders.custName}}
                    </td>
                    <td>
                        {{orders.custAddress}}
                    </td>
                    <td>
                        {{orders.custTel}}
                    </td>
                    <td>
                        {{orders.orderState}}
                    </td>
                     <td>
                         {{orders.orderDate}}
                     </td>
                    <%----%>
                    <td v-show="flag">
                        <button class="btn btn-sm btn-info" @click="comment(orders.goodsId)">评价</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
<script>
    new Vue({
        el:'#app',
        data:{
            ordersAll:[],
            flag : false
        },
        methods:{
            getAllOrders:function(){
                const orders_this = this;
                return axios.get('/getAllOrders.action').then(function (res) {
                    console.log(res.data);
                    orders_this.ordersAll = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            searchFinished(){
                this.flag=true;
                const orders_this = this;
                return axios.get('/getFinishedOrders.action').then(function (res) {
                    console.log(res.data);
                    orders_this.ordersAll = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            searchIng(){
                this.flag=false;
                const orders_this = this;
                return axios.get('/getIngOrders.action').then(function (res) {
                    console.log(res.data);
                    orders_this.ordersAll = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            toMain(){
                location.href="/toMain.action";
            },
            toShopCar(){
                location.href="/toShopCar.action";
            },
            comment(goodsId){
                var goodsComment=window.prompt("请输入宝贵的评价","系统默认给好评！");
                $.ajax({
                    type:"post",
                    url:"/commentGoods.action",
                    dataType:"json",
                    data:{
                        goodsId:goodsId,
                        goodsComment:goodsComment
                    },
                    success:function(data){
                        if (data.msg==="ok"){
                            alert("评价完成，谢谢！您的评价信息为："+goodsComment);
                        }else{
                            alert("系统出错");
                        }
                    },
                    error:function(data){
                        console.log(data);
                    }
                });
            }
        },
        mounted() {
            //this.getAllOrders();
        }
    })
</script>
</html>
