<%@ page import="entities.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<head>
  <%@include file="../fragments/head.jspf" %>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login-register.css">
  <title>Sell Product</title>
</head>

<body>

<%--Header--%>
<%@include file="../fragments/topbar.jspf" %>

<%
  Product selected = (Product) request.getAttribute("selected");
  String selectedName = selected.getProductName();
  List<String> path = new ArrayList<>(Arrays.asList("Manage", "Sell Product", selectedName));
  pageContext.setAttribute("path", path);
%>

<%--Breadcrumbs--%>
<%@include file="../fragments/breadcrumbs.jspf" %>

<%--Register--%>
<div class="register">

  <div class="container">

    <h2>Sell Product</h2>

    <div class="login-form-grids">

      <form method="post">

        <h1>${selected.productName}</h1>

        <div>
          <img src="${pageContext.request.contextPath}/products/image/${selected.productId}">
        </div>

        <div class="row">
          <div class="col-xs-12">
            <label for="listingName">Product Name</label>
            <div class="form-group">
              <input type="text" id="listingName" name="listingName" class="form-control" pattern="{1,30}">
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-xs-12">
            <label for="listingQuantity">Quantity</label>
            <div class="form-group">
              <input type="number" id="listingQuantity" name="listingQuantity" class="form-control" pattern="[0-9]+">
            </div>
          </div>
        </div>

        <h1>Accepted at:</h1>
        <h1>${selected.basePriceIn}&euro;</h1>
        <h1>per ${selected.unitByUnitId.unitName}</h1>

        <div class="row">
          <div class="col-xs-12">
            <input type="submit" value="Sell">
          </div>
        </div>

      </form>

    </div>

    <div class="register-home">
      <a href="${pageContext.request.contextPath}/">Home</a>
    </div>

  </div>
</div>
<%--//Register --%>

<%--Footer--%>
<%@include file="../fragments/footer.jspf" %>

</body>
</html>