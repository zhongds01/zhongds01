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
    <script src="../../js/jquery-3.3.1.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script	src="../../js/vue-2.5.22.min..js"></script>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
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
                        <input type="text" class="form-control" id="inputGoodsName" name="goodsName"/>
                    </div>
                    <div id="warnMsg1" style="display: none;margin-left: 150px;font-size: 20px"></div>
                </div>
                <div class="form-group">
                    <label for="inputGoodPrice" class="col-sm-2 control-label">商品价格</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="inputGoodPrice" name="goodsPrice"/>
                    </div>
                    <div id="warnMsg2" style="display: none;margin-left: 150px;font-size: 20px"></div>
                </div>
                <div class="form-group">
                    <label for="inputGoodsCata" class="col-sm-2 control-label">商品类别</label>
                    <div class="col-sm-5">
                        <select class="form-control" id="inputGoodsCata" name="goodsCata">
                            <option>玩具</option>
                            <option>食品</option>
                            <option>家电</option>
                            <option>数码</option>
                            <option>饰品</option>
                            <option>五金</option>
                        </select>
                    </div>
                    <div id="warnMsg3" style="display: none;margin-left: 150px;font-size: 20px"></div>
                </div>

                <div class="form-group">
                    <label for="inputGoodsStock" class="col-sm-2 control-label">商品库存</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="inputGoodsStock" name="goodsStock"/>
                    </div>
                    <div id="warnMsg4" style="display: none;margin-left: 150px;font-size: 20px"></div>
                </div>
                <div class="form-group">
                    <label for="inputGoodsPic" class="col-sm-2 control-label">商品图片</label>
                    <div class="col-sm-5">
                        <input type="file" class="form-control" id="inputGoodsPic" multiple="multiple" name="goodsPic"/>
                    </div>
                    <div id="warnMsg5" style="display: none;margin-left: 150px;font-size: 20px"></div>
                </div>
                <div class="form-group">
                    <label for="inputGoodsDesc" class="col-sm-2 control-label">商品描述</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="inputGoodsDesc" name="goodsDesc"/>
                    </div>
                    <div id="warnMsg6" style="display: none;margin-left: 150px;font-size: 20px"></div>
                </div>
                <div class="form-group">
                    <label for="inputGoodsComment" class="col-sm-2 control-label">商品评价</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="inputGoodsComment" name="goodsComment"/>
                    </div>
                    <div id="warnMsg7" style="display: none;margin-left: 150px;font-size: 20px"></div>
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
    $(function(){
        $("#inputGoodsName").blur(function () {
            var goodsName = $("#inputGoodsName").val();
            if (goodsName===null||goodsName===""){
                $("#warnMsg1").html("<span class='glyphicon  glyphicon-remove'></span>");
                $("#warnMsg1").show();
            }else {
                $("#warnMsg1").html("<span class='glyphicon  glyphicon-ok'></span>");
                $("#warnMsg1").show();
            }
        });
        $("#inputGoodPrice").blur(function () {
            var goodsPrice = $("#inputGoodPrice").val();
            if (goodsPrice===null||goodsPrice===""||goodsPrice<=0){
                $("#warnMsg2").html("<span class='glyphicon  glyphicon-remove'></span>");
                $("#warnMsg2").show();
            }else {
                $("#warnMsg2").html("<span class='glyphicon  glyphicon-ok'></span>");
                $("#warnMsg2").show();
            }
        });
        $("#inputGoodsCata").blur(function () {
            $("#warnMsg3").html("<span class='glyphicon  glyphicon-ok'></span>");
            $("#warnMsg3").show();
        });
        $("#inputGoodsStock").blur(function () {
            var goodsStock = $("#inputGoodsStock").val();
            if (goodsStock===null||goodsStock===""||goodsStock<=0){
                $("#warnMsg4").html("<span class='glyphicon  glyphicon-remove'></span>");
                $("#warnMsg4").show();
            }else {
                $("#warnMsg4").html("<span class='glyphicon  glyphicon-ok'></span>");
                $("#warnMsg4").show();
            }
        });
        $("#inputGoodsPic").blur(function () {
            var goodsPic = $("#inputGoodsPic").val();
            if (goodsPic===null||goodsPic===""){
                $("#warnMsg5").html("<span class='glyphicon  glyphicon-remove'></span>");
                $("#warnMsg5").show();
            }else {
                $("#warnMsg5").html("<span class='glyphicon  glyphicon-ok'></span>");
                $("#warnMsg5").show();
            }
        });
        $("#inputGoodsDesc").blur(function () {
            var goodsDesc = $("#inputGoodsDesc").val();
            if (goodsDesc===null||goodsDesc===""){
                $("#warnMsg6").html("<span class='glyphicon  glyphicon-remove'></span>");
                $("#warnMsg6").show();
            }else{
                $("#warnMsg6").html("<span class='glyphicon  glyphicon-ok'></span>");
                $("#warnMsg6").show();
            }
        });
        $("#inputGoodsComment").blur(function () {
            var goodsComment = $("#inputGoodsComment").val();
            if (goodsComment===null||goodsComment===""){
                $("#warnMsg7").html("<span class='glyphicon  glyphicon-remove'></span>");
                $("#warnMsg7").show();
            }else {
                $("#warnMsg7").html("<span class='glyphicon  glyphicon-ok'></span>");
                $("#warnMsg7").show();
            }
        });
    });
</script>
</html>
