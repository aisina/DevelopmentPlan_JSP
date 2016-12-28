<%--
  Created by IntelliJ IDEA.
  User: innopolis
  Date: 22.12.2016
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная</title>
</head>
<body>

<form name="usernameForm" action="${pageContext.servletContext.contextPath}/userLogon" method="post">
    <table align="left" width="350">
        <tr>
            <td width="100" align="left"><span style="color:red;">*</span> Логин:</td>
            <td><input type="text" name="username" size="20"/></td>
        </tr>
        <tr>
            <td align="left"><span style="color:red;">*</span> Пароль:</td>
            <td><input type="password" name="password" size="20" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Войти" /></td>
        </tr>
    </table>
</form>

</body>
</html>
