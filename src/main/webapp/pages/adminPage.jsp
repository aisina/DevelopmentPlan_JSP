<%@ page import="pojo.Plan" %><%--
  Created by IntelliJ IDEA.
  User: innopolis
  Date: 26.12.2016
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<p>
<jsp:useBean id="planList" class="dao.PlanDAO" scope="page"/>

<h2>Здравствуйте, ${username}!</h2>

<p><a href="/userLogout">Выйти</a></p>
<p><a href="${pageContext.servletContext.contextPath}/pages/employeeList.jsp">Просмотр списка сотрудников</a></p>
<p>Список текущих планов:</p>
<p>
    <table>
        <%
            for (String planYear : planList.getPlanYear()) {
        %>
            <tr>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/showPlan?planYear=<%=planYear%>"><%= "План на " + planYear + " год"%></a>
                </td>
            </tr>
        <%}%>
    </table>
</p>

</body>
</html>
