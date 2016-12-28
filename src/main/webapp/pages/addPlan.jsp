<%@ page import="pojo.Employee" %><%--
  Created by IntelliJ IDEA.
  User: innopolis
  Date: 27.12.2016
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление плана</title>
</head>
<body>

<jsp:useBean id="employeeList" class="dao.EmployeeListDAO" scope="page"/>
<jsp:useBean id="planTypes" class="ArrayLists.PlanTypes" scope="page"/>

<p><a href="${pageContext.servletContext.contextPath}/pages/adminPage.jsp">На главную</a></p>

<form action="${pageContext.servletContext.contextPath}/addPlan" method="post">

    <table>
        <tr>
            <td>Год</td>
            <td><input type="text" name="addYear"></td>
        </tr>
        <tr>
            <td>ФИО сотрудника</td>
            <td>
                <select name="addName">
                    <%
                        for (Employee employee : employeeList.getAll()) {
                    %>
                    <option><%= employee.getName()%></option>
                    <%}%>
                </select>
            </td>
        </tr>
        <tr>
            <td>Должность сотрудника</td>
            <td><input type="text" name="addPosition"></td>
        </tr>
        <tr>
            <td>План развития</td>
            <td>
                <select name="addPlanType">
                    <%
                        for (String planType : planTypes.getPlantypes()) {
                    %>
                    <option><%= planType%></option>
                    <%}%>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Добавить" onclick="window.location='planList.jsp'"></td>
        </tr>
    </table>
</form>

</body>
</html>
