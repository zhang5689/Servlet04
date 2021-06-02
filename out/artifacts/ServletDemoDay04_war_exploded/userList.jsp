<%--
  Created by IntelliJ IDEA.
  User: 75213
  Date: 2021/6/2
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--1.必需导包，我提供的工程中就有，如果大家找不到, 如果没效果，必需把jar复制到tomcat lib下面
    2.如果还不行， isELIgnored="false"--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" cellpadding="0" cellspacing="0" width="80%">
        <tr>
            <%--<td>id</td>--%>
            <td>userName</td>
            <td>sex</td>
            <td>date</td>
            <td>address</td>
            <td>操作</td>
        </tr>
        <c:forEach var="li" items="${list}">
            <tr>
                <<td>${li.id}</td>
                <td>${li.userName}</td>
                <td>${li.sex}</td>
                <td>${li.date}</td>
                <td>${li.address}</td>
                <td>操作</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
