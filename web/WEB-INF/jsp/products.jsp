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
  <%@include file="../reusables/head.jspf" %>
  <title>Products</title>
</head>
<body>

<div class="container">

  <div class="jumbotron">
    <h1 class="text-center">${products[0].categoryByCategoryId.categoryName}</h1>
    <p>Logged User: ${sessionScope.user.name}</p>
  </div>

  <div class="row">
    <div class="col-md-6 col-md-offset-3">

      <table class="table table-bordered table-hover table-striped">
        <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Image Path</th>
          <th>Base Price In</th>
          <th>Base Price Out</th>
          <c:if test="${sessionScope.user ne null}">
            <th>Action</th>
          </c:if>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="p">
          <tr>
            <td>${p.productId}</td>
            <td class="clickable" onclick="redirectToListings(${p.productId})">${p.productName}</td>
            <td>${p.imagePath}</td>
            <td>${p.basePriceIn}</td>
            <td>${p.basePriceOut}</td>
            <td>
              <c:if test="${sessionScope.user ne null and not wishlist.contains(p)}">
                <button
                    id="_${p.productId}"
                    onclick="addToWishlist(${p.productId})"
                    class="btn btn-info btn-lg" style="z-index: 3">
                  <span class="glyphicon glyphicon-heart"></span>
                </button>
              </c:if>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>

    </div>
  </div>
</div>

<%@include file="../reusables/footer.jspf" %>

<script>

    function addToWishlist(productId) {
        let e = window.event;
        e.cancelBubble = true;
        if (e.stopPropagation) e.stopPropagation();
        $.post("${pageContext.request.contextPath}/wishlist/" + productId,
            function () {
                $("#_" + productId).remove();
            })
    }

    function redirectToListings(id) {
        window.location.href = "${pageContext.request.contextPath}/listings/" + id;
    }

</script>

</body>
</html>