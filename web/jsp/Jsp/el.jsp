<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/11
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        普通的变量<br/>
        username:${username}<br/>
        session.username:${sessionScope.username}<br/>
        对象的数据：<br/>
        username${userInfo.username}<br/>
        password${userInfo.password}<br/>
        集合数据：el遍历不了
        list[0].username${list[0].username}<br/>

</body>
</html>
