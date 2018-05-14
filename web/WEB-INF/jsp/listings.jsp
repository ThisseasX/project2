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
  <title>Listings</title>
</head>
<body>

<div class="container">

  <div class="jumbotron">
    <h1 class="text-center">${listings[0].productByProductId.productName}</h1>
  </div>

  <div class="row">
    <div class="col-md-6 col-md-offset-3">

      <table class="table table-bordered table-hover table-striped">
        <thead>
        <tr>
          <th>ID</th>
          <th>Username</th>
          <th>Unit</th>
          <th>Quantity</th>
          <th>Price Per Unit</th>
          <th>Base Price In</th>
          <th>Base Price Out</th>
          <th>Date Listed</th>
          <th>Status</th>
          <th>Cart</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listings}" var="l">
          <tr>
            <td>${l.listingId}</td>
            <td>${l.userByUserId.email}</td>
            <td>${l.unitByUnitId.unitName}</td>
            <td>${l.listingQuantity}</td>
            <td>${l.pricePerUnit}&euro;</td>
            <td>${l.productByProductId.basePriceIn}&euro;</td>
            <td>${l.productByProductId.basePriceOut}&euro;</td>
            <td>${l.listingDate}</td>
            <td>
              <c:choose>
                <c:when test="${l.statusByStatusId.statusId eq 3}">
                  <p id="status_${l.listingId}">
                      ${l.statusByStatusId.statusName}
                  </p>
                </c:when>
                <c:otherwise>
                  <button onclick="changeStatus(${l.listingId})" id="status_${l.listingId}">
                      ${l.statusByStatusId.statusName}
                  </button>
                </c:otherwise>
              </c:choose>
            </td>
            <td>
              <button onclick="addToCart(${l.listingId})" id="cart_${l.listingId}">
                <span class="glyphicon glyphicon-shopping-cart"> Cart</span>
              </button>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>

    </div>
  </div>
</div>

<%@include file="../fragments/footer_scripts.jspf" %>

<script>

    function changeStatus(id) {
        $.post("${pageContext.request.contextPath}/admin/change_listing_status/" + id,
            function (data) {
                $("#status_" + id).text(data);
            }
        );
    }

    function addToCart(id) {
        $.post("${pageContext.request.contextPath}/cart/add/" + id);
    }

</script>

</body>
</html>