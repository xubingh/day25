<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/12
  Time: 0:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body><table>
    <tr>
        <td>用户名：</td>
        <td>${userInfo.username}</td>
    </tr>
    <tr>
        <td>密码：</td>
        <td>${userInfo.password}</td>
    </tr>
    <tr>
        <td>爱好：</td>
        <td><c:forEach items="${userInfo.hobbies}" var="hobbies">
            ${hobbies}
        </c:forEach></td>
    </tr>
    <tr>
        <td>性别:</td>
        <td><c:if test="${userInfo.sex==0}">女</c:if>
            <c:if test="${userInfo.sex==1}">男</c:if>
        </td>
    </tr>
</table>

</body>
</html>
