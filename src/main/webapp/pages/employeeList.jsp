<%@ page import="pojo.Employee" %><%--
  Created by IntelliJ IDEA.
  User: innopolis
  Date: 26.12.2016
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:useBean id="employeeList" class="dao.EmployeeListDAO" scope="page"/>

<p><a href="${pageContext.servletContext.contextPath}/pages/adminPage.jsp">На главную</a></p>
<p><a href="${pageContext.servletContext.contextPath}/userLogout">Выход</a></p>

<br/>
<a href="${pageContext.servletContext.contextPath}/pages/addEmployee.jsp">Добавить сотрудника</a>
<br/>

<table border="1">
    <tr>
        <td>ID</td>
        <td>ФИО</td>
        <td>Отдел</td>
        <td>Должность</td>
        <td>e-mail</td>
        <td></td>
    </tr>

    <%
        for (Employee employee : employeeList.getAll()) {
    %>
    <tr>

        <td><%=employee.getId()%></td>
        <td><%=employee.getName()%></td>
        <td><%=employee.getDepartment()%></td>
        <td><%=employee.getPosition()%></td>
        <td><%=employee.getEmail()%></td>
        <form action="<%= request.getContextPath()%>/deleteEmployee" method="post">
            <td><input class="button" type="submit" value="Удалить">
                <input type="hidden" name="employeeID" value="<%=employee.getId()%>">
            </td>
        </form>

    </tr>
    <%}%>

</table>


</body>
</html>
