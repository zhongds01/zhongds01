<%--
  Created by IntelliJ IDEA.
  User: ZDS
  Date: 2019/4/22
  Time: 0:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Warn</title>
</head>
<body>
<h1 style="text-align: center">您还没有登陆，请先登陆<b id="second">5</b>秒后跳转到登陆</h1>
<script type="text/javascript">
    //获取显示秒数的元素，通过定时器来更改秒数。
    var sec = document.getElementById("second");
    var i=5;
    var timer = setInterval(function(){
        i--;
        sec.innerHTML = i;
        if(i===1){
            window.location.href="/toLogin.action";
        }
    },1000);
    //通过window的location和history对象来控制网页的跳转。

</script>
</body>
</html>
