<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Todo List</title>
</head>
<body>
<h1>Todo List</h1>

<h2>${appName}</h2>
<h3>${loginInfo}</h3>
<h4>${loginInfo.mname}</h4>

<ul>
    <c:forEach items="${dtoList}" var="dto">

<%--        <li>${dto}</li>  // 전체 나오게 출력 --%>

        <li>
            <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
            <span>${dto.title}</span>
            <span>${dto.dueDate}</span>
            <span>${dto.finished? "DONE": "NOT YET"}</span>
        </li>
        <%-- 각 게시물에 링크를 추가--%>

    </c:forEach>
</ul>

<form action="/logout" method="post">
    <button>LOGOUT</button>
</form>

</body>
</html>