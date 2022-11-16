<%--
  Created by IntelliJ IDEA.
  User: STUDIES_NUTNON
  Date: 11/15/2022
  Time: 12:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${products}" var="p" varStatus="vs">
  <p>${p.id}</p>
</c:forEach>
</body>
</html>
