<%--
  Created by IntelliJ IDEA.
  User: innopolis
  Date: 26.12.2016
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить сотрудника</title>
</head>
<body>

<%--<form action="<%= request.getContextPath()%>/addEmployee" method="post">--%>
<form action="${pageContext.servletContext.contextPath}/addEmployee" method="post">

    <table>
        <tr>
            <td>ФИО</td>
            <td><input type="text" name="addName"></td>
        </tr>
        <tr>
            <td>Отдел</td>
            <td><input type="text" name="addDepartment"></td>
        </tr>
        <tr>
            <td>Должность</td>
            <td><input type="text" name="addPosition"></td>
        </tr>
        <tr>
            <td>E-mail</td>
            <td><input type="text" name="addEmail"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Добавить" onclick="window.location='employeeList.jsp'"></td>
        </tr>
    </table>
</form>


</body>
</html>
