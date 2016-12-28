<%@ page import="pojo.Plan" %><%--
  Created by IntelliJ IDEA.
  User: innopolis
  Date: 26.12.2016
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>План</title>
</head>
<body>
<jsp:useBean id="planList" class="servlets.ShowPlan" scope="page"/>

<p><a href="/userLogout">Выйти</a></p>
<p><a href="${pageContext.servletContext.contextPath}/userPlanViewServlet">На главную</a></p>
<p><a href="addPlan.jsp">Добавить план</a></p>

<table border="1">
    <tr>
        <td>Год</td>
        <td>ФИО сотрудника</td>
        <td>Должность сотрудника</td>
        <td>Программа</td>
        <td></td>
    </tr>

</table>


</body>
</html>
