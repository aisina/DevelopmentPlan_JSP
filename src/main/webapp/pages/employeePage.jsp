<%@ page import="pojo.Plan" %><%--
  Created by IntelliJ IDEA.
  User: innopolis
  Date: 26.12.2016
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Личный кабинет сотрудника</title>
</head>
<body>

<jsp:useBean id="employeePlanList" class="dao.PlanDAO" scope="page"/>

<h2>Здравствуйте, ${username}!</h2>
<p><a href="/userLogout">Выйти</a></p>
<p><a href="${pageContext.servletContext.contextPath}/pages/changePassAndLogin.jsp">Изменить логин и пароль</a></p>

<%--<%request.setCharacterEncoding("UTF-8");%>
<%= "Здравствуйте, " + request.getParameter("username") + "!" %>
<%--${param["username"]} &lt;%&ndash;EL&ndash;%&gt;--%>

<table border="1">
    <tr>
        <td>Год</td>
        <td>Тип</td>
    </tr>

    <c:forEach items="${plans}" var="plan" varStatus="status">
        <tr valign="top">
            <td>${plan.getYear()}</td>
            <td>${plan.getPlanType()}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
