<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chat</title>
</head>
<body>

<table border="1">
    <caption>Chat</caption>
    <c:forEach items="${messages}" var="item">
        <tr>
            <td>${item.clientName}</td>
            <td>${item.text}</td>
        </tr>
    </c:forEach>
</table>

<form action="messages" method="post">
    <input type="text" name="text">
    <input type="submit">
</form>
<a href="/app/messages">Refresh</a> <br>
</body>
</html>