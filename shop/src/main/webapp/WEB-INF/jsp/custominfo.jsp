<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Title</title>
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
<div id="customapp">
    <h1>客户信息</h1>
    <hr>
    <div class="row" >
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <form class="form-inline">
                <label for="SearchCustName1">客户名称：</label>
                <input type="text" class="form-control" id="SearchCustName1" v-model="custName"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="button" class="btn btn-default form-control" @click="searchCustom()">搜索</button>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12 column">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>
                        用户编号
                    </th>
                    <th>
                        用户名称
                    </th>
                    <th>
                        用户性别
                    </th>
                    <th>
                        用户电话
                    </th>
                    <th>
                        用户邮箱
                    </th>
                    <th>
                        用户地址
                    </th>
                    <th>
                        注册日期
                    </th>
                </tr>
                </thead>
                <tbody v-for="(custom,index) in customs":key="custom.custId">
                <tr>
                    <td>
                        {{custom.custId}}
                    </td>
                    <td>
                        {{custom.custName}}
                    </td>
                    <td>
                        {{custom.custSex}}
                    </td>
                    <td>
                        {{custom.custTel}}
                    </td>
                    <td>
                        {{custom.custEmail}}
                    </td>
                    <td>
                        {{custom.custAddress}}
                    </td>
                    <td>
                        {{custom.createDate}}
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
        el:'#customapp',
        data:{
            customs:[],
            custName:''
        },
        methods:{
            getAllcustoms:function(){
                const _this1 = this;
                return axios.get('/getAllcustoms.action').then(function (res) {
                    console.log(res.data);
                    _this1.customs = res.data;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            searchCustom(){
                const _this1 = this;
                $.ajax({
                    type:"post",
                    url:"/searchCustom.action",
                    data:{
                        custName: _this1.custName
                    },
                    dataType:"json",
                    success:function(data){
                        console.log(data);
                        _this1.customs = data;
                    },
                    error:function(data){
                        console.log(data);
                    }
                });
            }
        },
        mounted() {
            this.getAllcustoms();
        }
    })
</script>
</html>
