<%--
  Created by IntelliJ IDEA.
  User: STUDIES_NUTNON
  Date: 11/14/2022
  Time: 11:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Productlist</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="row pt-4 align-items-center">
    <c:forEach items="${products}" var="p" varStatus="vs">
        <div class="col-2 my-1 mx-3">
            <div class="img-fluid img-thumbnail" title="${p.productCode}">
                <img src="model-images/${p.productLine}/${p.productCode}.jpg" height="120" width="180"/>
            </div>
            <div>${p.productName} <span style="text-align: right">${p.MSRP}</span>
                <span style="color: darkred;margin-left: 2px;cursor: pointer">
                    <i class="bi bi-bag-plus" onclick="addToCart('${p.productCode}')"></i></span>
            </div>
        </div>
    </c:forEach>
</div>
<hr>
<div class="d-flex flex-row">
    <div class="px-1">page:</div>
    <div class="px-1 mx-1 div-link"
         onclick="loadProduct(page=${page<=1?totalPage:page-1}, ${pageSize})"> &lt;
    </div>
    <c:set var="totalPage" value="${itemCount/pageSize}"/>
    <c:forEach begin="1" end="${totalPage}" varStatus="vs">
        <c:choose>
            <c:when test="${vs.count==page}">
                <div class="px-1 mx-1 div-link text-light bg-dark"> ${vs.count} </div>
            </c:when>
            <c:otherwise>
                <a href="proServlet?page=${vs.count}&pageSize=${pageSize}">
                    <div class="px-1 mx-1 div-link">
                            ${vs.count}
                    </div></a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <div class="px-1 mx-2 div-link"
         onclick="loadProduct(page=${page>=totalPage?1:page+1}, ${pageSize})"> &gt;
    </div>
    <div class="px-4 mx-1">
        items per page:
        <select id="itemsPage" onchange="loadProduct(1)">
            <option value="5" ${pageSize==5?'selected':''}>5</option>
            <option value="10" ${pageSize==10?'selected':''}>10</option>
            <option value="15" ${pageSize==15?'selected':''}>15</option>
            <option value="20" ${pageSize==20?'selected':''}>20</option>
            <option value="50" ${pageSize==50?'selected':''}>50</option>
        </select>
    </div>
</div>
</body>
</html>
