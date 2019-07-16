<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/11
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body><
<form action="UserSession"method="post">
    用户名：<input type="text" name="useername"><br/>
    密码：<input type="password" name="password"><br/>
    请选择接受的服务：
        <input  type="checkbox" name="hobbies" value="按摩"/>按摩
        <input type="checkbox" name="hobbies" value="沐浴"/>沐浴
        <input type="checkbox" name="hobbies" value="推背">推背
        <input type="checkbox" name="hobbies" value="足疗"/>足疗<br/>
    请选择服务人员：<select name="sex">
        <option value="请选择"></option>
        <option value="丽丽"></option>
        <option value="冰冰"></option>
        <option value="美美"></option>
</select><br/>
    <input type="submit" value="确定"/>
</form>

</body>
</html>
