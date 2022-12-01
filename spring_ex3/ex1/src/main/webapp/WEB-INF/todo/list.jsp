<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sj526
  Date: 2022-11-23
  Time: 오후 3:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List Page</h1>

<%--<ul>--%>
<%--    <c:forEach var="dto" items="${list}">--%>
<%--        <li>${dto}</li>--%>
<%--    </c:forEach>--%>
<%--</ul>--%>

<%--<ul>--%>
<%--    <c:forEach var="num" begin="1" end="10">--%>
<%--        <li>${num}</li>--%>
<%--</ul>--%>

<%--        <c:choose>--%>
<%--            <c:if test="${list.size() % 2 == 0}">--%>
<%--                짝수--%>
<%--            </c:if>--%>
<%--            <c:if test="${list.size() % 2 != 0}">--%>
<%--                홀수--%>
<%--            </c:if>--%>

<%--            <c:when test="${list.size() % 2 == 0}">--%>
<%--                짝수--%>
<%--            </c:when>--%>
<%--            <c:otherwise>--%>
<%--                홀수--%>
<%--            </c:otherwise>--%>
<%--        </c:choose>--%>
<%--    --%>
<%--    </c:forEach>--%>

<c:set var="target" value="5"></c:set>
<ul>
    <c:forEach var="num" begin="1" end="10">
        <c:if test="${num == target}">
            num is target
        </c:if>
    </c:forEach>
</ul>
<%--// 1~10까지의 숫자 출력--%>

<%--${list}--%>



</body>
</html>
