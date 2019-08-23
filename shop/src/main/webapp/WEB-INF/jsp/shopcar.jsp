<%--
  Created by IntelliJ IDEA.
  User: ZDS
  Date: 2019/4/19
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script	src="/js/vue-2.5.22.min..js"></script>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script src="/js/axios-0.18.0.min.js"></script>
</head>
<body>
<div id="shopcarapp" class="container">
    <div class="row">
        <div class="col-sm-9">
            <h1>我的购物车</h1>
        </div>
        <div class="col-sm-2 " style="margin-top: 10px">
            <button class="btn  btn-default" @click="toMain">返回首页</button>
            <button class="btn  btn-default" @click="toOrders">我的订单</button>
        </div>
    </div>
    <br>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>商品名称</th>
            <th>买家名称</th>
            <th>购买数量</th>
            <th>商品价格</th>
            <th>操作</th>
        </tr>
        <tr v-for="(shopCar,index) in shopCars":key="shopCar.carId">
            <td>{{shopCar.carId}}</td>
            <td>{{shopCar.goodsName}}</td>
            <td>{{shopCar.custName}}</td>
            <td>{{shopCar.goodsMounts}}</td>
            <td>{{shopCar.goodsPrice}}</td>
            <td>
                <button class="btn  btn-default" v-bind:disabled="shopCar.goodsMounts === 0" v-on:click="shopCar.goodsMounts-=1">-</button>
                {{shopCar.goodsMounts}}
                <button class="btn  btn-default" v-on:click="shopCar.goodsMounts+=1">+</button>
                <button class="btn  btn-default" v-on:click="shopCar.goodsMounts=0">移除</button>
            </td>
        </tr>
    </table>
    <h3>总价：￥{{totalPrice()}}</h3>
    <div style="margin-left: 78%" >
        <button class="btn  btn-default" v-on:click="pay()">结算</button>
    </div>
</div>
</body>
<script>
    new Vue({
        el:'#shopcarapp',
        data:{
            shopCars:[]
        },
        methods:{
            totalPrice : function(){
                var totalP = 0;
                for (var i = 0,len = this.shopCars.length;i<len;i++) {
                    totalP+=this.shopCars[i].goodsPrice*this.shopCars[i].goodsMounts;
                }
                return totalP;
            },
            getAllShopCar:function(){
                const _this = this;
                return axios.get('/getAllShopCar.action').then(function (res) {
                    console.log(res.data);
                    _this.shopCars = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            pay(){
                const _this = this;
                $.ajax({
                    type:"post",
                    url:"/makeOrders.action",
                    data:{
                        "shopCars":JSON.stringify(_this.shopCars)
                    },
                    dataType:"json",
                    success:function(data){
                        if (data.msg==="ok"){
                            //alert("支付成功，订单已生成！");
                            /*var shopCars = JSON.stringify(_this.shopCars);

                            shopCars=URLEncoder.encode(shopCars,"utf-8");
                            console.log(shopCars);*/
                            var url = encodeURIComponent(JSON.stringify(_this.shopCars));
                            location.href=("/toAlipay.action?shopCars="+url);

                            //此处写删除购物车方法
                            $.ajax({
                                type:"post",
                                url:"/deleteCar.action",
                                data:{
                                    "shopCars":JSON.stringify(_this.shopCars)
                                },
                                dataType:"json",
                                success:function(data){
                                    console.log(data);
                                    //location.reload();
                                },
                                error:function(data){
                                    console.log(data);
                                }
                            });
                            //此处写商品库存减少方法
                            $.ajax({
                                type:"post",
                                url:"/reduceMounts.action",
                                data:{
                                    "shopCars":JSON.stringify(_this.shopCars)
                                },
                                dataType:"json",
                                success:function(data){
                                    console.log(data);
                                    //location.reload();
                                },
                                error:function(data){
                                    console.log(data);
                                }
                            });




                        }else {
                            alert("支付失败");
                        }
                    },
                    error:function(data){
                        console.log(data);
                    }
                });
            },
            toOrders(){
                location.href="/toOrders.action";
            },
            toMain(){
                location.href="/toMain.action";
            }
        },
        mounted() {
            this.getAllShopCar();
        }
    })
</script>
</html>