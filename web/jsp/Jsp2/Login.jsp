<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/15
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function onGather() {
            var flag = true;
            flag = flag && onValidateName();
            flag = flag && onValidatedpassword();
            flag = flag && onValidatepasswords()
            if (flag){
                return true;
            }
            function onValidateName() {
                var nameObj = document.getElementById("username");
                if (nameObj.value != null && ""!=nameObj.value){
                    return true;
                }else {
                    alert("用户名不能为空");
                    return false;
                }
            }
            function onValidatedpassword() {
                var passwordObj = document.getElementById("password");
                if(passwordObj.value !=null && ""!=passwordObj.value ){
                    if(passwordObj.value.length<6){
                        alert("密码不能小于六位数");
                        return false;
                    }
                    return true;
                }else {
                    alert("密码不能为空");
                    return false;
                }
            }
            function onValidatepasswords() {
                var passwordObj = document.getElementById("password");
                var passwordtwoObj = document.getElementById("passwordtwo")
                if (passwordObj.value != passwordtwoObj){
                    alert("密码与确认密码不一致");
                    return false;
                }
                return true;
            }
}


    </script>
</head>
<body>
<form action="LoginServlet" method="post">
    <table border="1">
        <tr>
            <td>用户名：</td>
            <td><input type="text" id="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" id="password"></td>
        </tr>
        <tr>
            <td>确认密码：</td>
            <td><input type="password" id="passwordtwo"></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center">
                <input type="button" value="注册" onclick="onGather()">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
