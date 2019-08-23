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
    <title>Title</title>
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script	src="/js/vue-2.5.22.min..js"></script>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<div class="container" id="goodsaddapp">
    <h2 align="center">商品添加</h2>
    <div class="row clearfix">

        <div class="col-md-12 column">
            <form class="form-horizontal" role="form" method="post" enctype="multipart/form-data" action="/goodsAdd.action">
                <div class="form-group">
                    <label for="inputGoodsName" class="col-sm-2 control-label">商品名称</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="inputGoodsName" name="goodsName" v-model="goodsName"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputGoodPrice" class="col-sm-2 control-label">商品价格</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="inputGoodPrice" name="goodsPrice" v-model="goodsPrice"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputGoodsCata" class="col-sm-2 control-label">商品类别</label>
                    <div class="col-sm-5">
                        <select class="form-control" id="inputGoodsCata" name="goodsCata" v-model="goodsCata">
                            <option>玩具</option>
                            <option>食品</option>
                            <option>家电</option>
                            <option>数码</option>
                            <option>饰品</option>
                            <option>五金</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputGoodsStock" class="col-sm-2 control-label">商品库存</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="inputGoodsStock" name="goodsStock" v-model="goodsStock"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputGoodsPic" class="col-sm-2 control-label">商品图片</label>
                    <div class="col-sm-5">
                        <input type="file" class="form-control" id="inputGoodsPic" multiple="multiple" name="goodsPic" v-model="goodsPic"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputGoodsDesc" class="col-sm-2 control-label">商品描述</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="inputGoodsDesc" name="goodsDesc" v-model="goodsDesc"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputGoodsComment" class="col-sm-2 control-label">商品评价</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="inputGoodsComment" name="goodsComment" v-model="goodsComment"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-5">
                        <input type="submit" class="btn btn-default" style="width: 457px;background-color: #2e6da4" />
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    var vm = new Vue({
        el:'#goodsaddapp',
        data:{
            goodsName:'',
            goodsCata:'',
            goodsPrice:'',
            goodsStock:'',
            goodsPic:'',
            goodsDesc:'',
            goodsComment:''
        },
        methods:{
            addGoods(){
               alert(1);
            }
        }
    })
</script>
</html>
