<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
  <%@include file="../fragments/head.jspf" %>
  <title>Management</title>
</head>

<body>

<%--Header--%>
<%@include file="../fragments/topbar.jspf" %>

<%
  List<String> path = new ArrayList<>(Arrays.asList("Management", "Sales History"));
  pageContext.setAttribute("path", path);
%>

<%--Breadcrumbs--%>
<%@include file="../fragments/breadcrumbs.jspf" %>

<!-- checkout -->
<div class="checkout">
  <div class="container">

    <div class="btn-group btn-group-justified">
      <c:if test="${sessionScope.user.admin}">
        <a href="${pageContext.request.contextPath}/sales/all" class="button-admin-choice-middle"
           style="border-radius: 10px 0 0 0">All</a>
        <a href="${pageContext.request.contextPath}/sales/user"
           class="button-admin-choice-middle" style="border-radius:0 10px 0 0">User</a>
      </c:if>
      <form method="get" action="${pageContext.request.contextPath}/sales/all/dates">
        <label for="dateStart">Start Date:</label>
        <input id="dateStart" type="date" name="dateStart">
        <label for="dateEnd">End Date:</label>
        <input id="dateEnd" type="date" name="dateEnd">
        <button type="submit"
                class="button-admin-choice-middle">Search Dates
        </button>
      </form>
      <%--<button onclick="viewSales('user')"--%>
      <%--class="button-admin-choice-middle">Search Dates By User--%>
      <%--</button>--%>
    </div>

    <div class="checkout-right">

      <table class="timetable_sub">

        <thead>
        <tr>
          <th>ID</th>
          <th>Seller</th>
          <th>Buyer</th>
          <th>Product</th>
          <th>Unit</th>
          <th>Quantity</th>
          <th>Price Per Unit</th>
          <th>Total Price</th>
          <th>Date Sold</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sales}" var="s">
          <tr>
            <td>${s.saleId}</td>
            <td>${s.listingByListingId.userByUserId.name}</td>
            <td>${s.buyer.name}</td>
            <td>${s.listingByListingId.listingName}</td>
            <td>${s.listingByListingId.productByProductId.unitByUnitId.unitName}</td>
            <td>${s.saleQuantity}</td>
            <fmt:formatNumber var="ppu" minFractionDigits="1" maxFractionDigits="2"
                              value="${s.listingByListingId.pricePerUnit}"/>
            <fmt:formatNumber var="totalPrice" minFractionDigits="1" maxFractionDigits="2"
                              value="${s.listingByListingId.pricePerUnit * s.saleQuantity}"/>
            <td>${ppu}&euro;</td>
            <td>${totalPrice}&euro;</td>
            <td>${s.saleDate}</td>
          </tr>
        </c:forEach>
        </tbody>

      </table>

    </div>
    <div class="checkout-left">
      <div class="checkout-right-basket">
        <a href="${pageContext.request.contextPath}/">
          <span class="glyphicon glyphicon-menu-left"
                aria-hidden="true"></span>
          Back to Home
        </a>
      </div>
      <div class="clearfix"></div>
    </div>
  </div>
</div>
<!-- //checkout -->

<%--Footer--%>
<%@include file="../fragments/footer.jspf" %>

<script>

    function viewSales(user) {
        let u = user || 'all';
        let dateStart = $('#dateStart').value || '';
        let dateEnd = $('#dateEnd').value || '';
        let delimiter = dateStart && dateEnd ? "/" : "";
        window.location.href = '${pageContext.request.contextPath}/sales/' + u + delimiter + dateStart + delimiter + dateEnd;
    }

</script>

</body>
</html>