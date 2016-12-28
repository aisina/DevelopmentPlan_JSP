<%--
  Created by IntelliJ IDEA.
  User: innopolis
  Date: 28.12.2016
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменение логина и пароля</title>
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/userChangeLoginAndPassword" method="post">
<table>
    <tr>
        <td>Новый логин:</td>
        <td><input type="text" name="login"></td>
    </tr>
    <tr>
        <td>Повторите логин:</td>
        <td><input type="text" name="login2"></td>
    </tr>
    <tr>
    <tr>
        <td>Новый пароль:</td>
        <td><input type="text" name="password"></td>
    </tr>
        <td>Повторите пароль:</td>
        <td><input type="text" name="password2"></td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit" class="button" value="Сохранить"></td>
    </tr>
</table>
</form>

</body>
</html>
