<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单信息</title>
    <script src="./js/jquery-3.3.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script	src="./js/vue-2.5.22.min..js"></script>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <script src="./js/axios-0.18.0.min.js"></script>
</head>
<body>
<div class="container" id="ordersapp">
    <h1>订单信息</h1>
    <div class="row" >
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <form class="form-inline">
                <label for="SearchCustName">客户名称：</label>
                <input type="text" class="form-control" id="SearchCustName" v-model="custName"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-default form-control" @click="searchOrders()">搜索</button>
            </form>
        </div>
    </div>
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
                    <th>
                        操作
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
                    <th>
                        <button class="btn btn-sm btn-info" @click="finishOrders(orders.orderId)"><span class="glyphicon glyphicon-ok"></span></button>
                        <button class="btn btn-sm btn-danger" @click="deleteOrders(orders.orderId)"><span class="glyphicon glyphicon-trash"></span></button>
                    </th>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
<script>
    new Vue({
        el:'#ordersapp',
        data:{
            ordersAll:[],
            custName:''
        },
        methods:{
            getAllOrders:function(){
                const _this3 = this;
                return axios.get('/getAllOrders.action').then(function (res) {
                    console.log(res.data);
                    _this3.ordersAll = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            finishOrders(orderId){
                axios({
                    method:'get',
                    url:'/finishOrders.action',
                    params:{
                        orderId:orderId
                    }
                }).then(function(res){
                    console.log(res.data);
                    if (res.data==="ok"){
                        alert("订单已完成");
                        location.reload();
                    }else{
                        alert("订单已完成");
                        location.reload();
                    }
                }).catch(function(error){
                    console.log("error:"+error);
                });
            },
            deleteOrders(orderId){
                axios({
                    method:'get',
                    url:'/deleteOrders.action',
                    params:{
                        orderId:orderId
                    }
                }).then(function(res){
                    console.log(res.msg);
                    if (res.data==="ok"){
                        alert("订单已删除");
                        location.reload();
                    }else{
                        alert("订单已删除");
                        location.reload();
                    }
                }).catch(function(error){
                    console.log("error:"+error);
                });
            },
            searchOrders(){
                const _this = this;
                $.ajax({
                    type:"post",
                    url:"/searchOrders.action",
                    data:{
                        custName:_this.custName
                    },
                    dataType:"json",
                    success:function(data){
                        console.log(data);
                        _this.ordersAll = data;
                    },
                    error:function(data){
                        console.log(data);
                    }
                });
                /*axios({
                    method:'get',
                    url:'/searchOrders.action',
                    params:{
                        custName:_this.custName
                    }
                }).then(function(res){
                    console.log(res.data);
                    _this.ordersAll = res.data;
                }).catch(function(error){
                    console.log("error:"+error);
                });*/
            }
        },
        mounted() {
            this.getAllOrders();
        }
    })
</script>
</html>
