<%--
  Created by IntelliJ IDEA.
  User: ZDS
  Date: 2019/4/19
  Time: 5:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品信息</title>
    <!-- 引入Bootstrap核心样式文件 -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入jQuery核心js文件 -->
    <script src="/js/jquery-3.3.1.min.js"></script>
    <!-- 引入BootStrap核心js文件 -->
    <script src="/js/bootstrap.min.js"></script>
    <script	src="/js/vue-2.5.22.min..js"></script>
    <script src="/js/axios-0.18.0.min.js"></script>
</head>
<body>
<div class="container"  id="goodsapp">
    <h1>商品信息</h1>
    <div class="row" >
        <div class="col-sm-3"></div>
        <div class="col-sm-8">
            <form class="form-inline">
                <label for="SearchGoodsName">商品名称：</label>
                <input type="text" class="form-control" id="SearchGoodsName" v-model="goodsName"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <label for="SearchGoodsCata">商品类别：</label>
                <select id="SearchGoodsCata" class="form-control" v-model="goodsCata">
                    <option>数码</option>
                    <option>家电</option>
                    <option>饰品</option>
                    <option>玩具</option>
                    <option>食品</option>
                    <option>五金</option>
                </select>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-default form-control" @click="searchGoods()">搜索</button>
            </form>
        </div>
    </div>
    <div class="row clearfix" v-for="(good,index) in goods":key="good.goodsId">
        <div class="col-md-12 column">
            <table class="table table-border">
                <thead>
                <tr>
                    <th>
                        商品编号
                    </th>
                    <th>
                        商品名称
                    </th>
                    <th>
                        商品类别
                    </th>
                    <th>
                        商品价格
                    </th>
                    <th>
                        商品库存
                    </th>
                    <th>
                        商品描述
                    </th>
                    <th>
                        商品图片
                    </th>
                    <th>
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        {{good.goodsId}}
                    </td>
                    <td>
                        {{good.goodsName}}
                    </td>
                    <td>
                        {{good.goodsCata}}
                    </td>
                    <td>
                        {{good.goodsPrice}}
                    </td>
                    <td>
                        {{good.goodsStock}}
                    </td>
                    <td>
                        {{good.goodsDesc}}
                    </td>
                    <td>
                        <img style="width: 100px;height: 60px" :src="'/images/'+good.goodsPic" alt="Goods image">
                    </td>
                    <th>
                        <button type="button" class="btn btn-sm btn-info" data-toggle="modal" data-target="#myModal">修改</button>
                    </th>
                </tr>
                </tbody>
            </table>
        </div>
        <%--modal--%>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">商品信息修改</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label for="goodsName" class="col-sm-2 control-label">商品名称</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="goodsName" v-model="good.goodsName" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="goodsCata" class="col-sm-2 control-label">商品类别</label>
                                <div class="col-sm-10">
                                    <select id="goodsCata" class="form-control" v-model="good.goodsCata">
                                        <option>数码</option>
                                        <option>家电</option>
                                        <option>玩具</option>
                                        <option>饰品</option>
                                        <option>食品</option>
                                        <option>五金</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="goodsPrice" class="col-sm-2 control-label">商品价格</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="goodsPrice" v-model="good.goodsPrice" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="goodsStock" class="col-sm-2 control-label">商品库存</label>
                                <div class="col-sm-10">
                                    <input type="number" class="form-control" id="goodsStock" v-model="good.goodsStock" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="goodsDesc" class="col-sm-2 control-label">商品描述</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="goodsDesc" v-model="good.goodsDesc" />
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" @click="modifyGoods(good)">提交更改</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
    </div>



</div>
</body>
<script>
    new Vue({
        el:'#goodsapp',
        data:{
            goods:[],
            goodsName:'',
            goodsCata:''
        },
        methods:{
            getAllGoods:function(){
                const _this2 = this;
                return axios.get('/getAllGoods.action').then(function (res) {
                    console.log(res.data);
                    _this2.goods = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            searchGoods(){
                const _this = this;

                $.ajax({
                    type:"post",
                    url:"/searchGoodsByNameOrCata.action",
                    data:{
                        goodsName:_this.goodsName,
                        goodsCata:_this.goodsCata
                    },
                    dataType:"json",
                    success:function(data){
                        console.log(data);
                        _this.goods=data;
                    },
                    error:function(data){
                        console.log(data);
                    }
                });
            },
            modifyGoods(good){
                const _this = this;
                $.ajax({
                    type:"post",
                    url:"/modifyGoods.action",
                    data:{
                        modifyGoods:JSON.stringify(good)
                    },
                    dataType:"json",
                    success:function(data){
                        if (data.msg==="ok"){
                            alert("修改成功");
                            location.reload();
                        }else {
                            alert("修改失败");
                        }
                    },
                    error:function(data){
                        console.log(data);
                    }
                });
            }
        },
        mounted() {
            this.getAllGoods();
        }
    })
</script>
</html>
