<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 1/4/2018
  Time: 11:12 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <%@include file="../fragments/head.jspf" %>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/heart.css">
  <title>Wishlist</title>
</head>
<body>

<div class="container">

  <div class="jumbotron">
    <h1 class="text-center">Wishlist</h1>
  </div>

  <div class="row">
    <div class="col-md-6 col-md-offset-3">

      <c:choose>

        <c:when test="${wishlist ne null and wishlist.size() > 0}">
          <table class="table table-bordered table-hover table-striped">
            <thead>
            <tr>
              <th>ID</th>
              <th>Product</th>
              <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${wishlist}" var="p">
              <tr>
                <td>${p.productId}</td>
                <td>${p.productName}</td>
                <td>
                  <input id="_${p.productId}" class="heart-checkbox" type="checkbox"
                      <c:if test="${wishlist.contains(p)}">
                        checked
                      </c:if>
                  />
                  <label for="_${p.productId}" class="heart" onclick="toggleWish(${p.productId})">❤</label>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </c:when>

        <c:otherwise>
          <h1 style="background-color: #f00">
            You have no items in your wishlist! Go add some!
          </h1>
        </c:otherwise>

      </c:choose>

    </div>
  </div>
</div>

<%@include file="../fragments/footer_scripts.jspf" %>

<script>

    function toggleWish(productId) {
        // Stop Event Propagation
        let e = window.event;
        e.cancelBubble = true;
        if (e.stopPropagation) e.stopPropagation();

        $.post("${pageContext.request.contextPath}/wishlist/" + productId)
    }

</script>

</body>
</html>