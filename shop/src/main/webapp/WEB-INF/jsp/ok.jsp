<%--
  Created by IntelliJ IDEA.
  User: ZDS
  Date: 2019/4/19
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1 style="text-align: center">操作成功<b id="second">5</b>秒后自动返回<a href="javascript:goBack();">或者点我返回</a></h1>
<script type="text/javascript">
    //获取显示秒数的元素，通过定时器来更改秒数。
    var sec = document.getElementById("second");
    var i=5;
    var timer = setInterval(function(){
        i--;
        sec.innerHTML = i;
        if(i===1){
            window.location.href="/toManager.action";
        }
    },1000);

    //通过window的location和history对象来控制网页的跳转。
    function goBack(){
        window.history.go(-1);
    }

</script>
</body>
</html>
