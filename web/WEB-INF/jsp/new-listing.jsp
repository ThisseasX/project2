<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
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
  List<String> path = new ArrayList<>(Collections.singletonList("Sell Product"));
  pageContext.setAttribute("path", path);
%>

<%--Breadcrumbs--%>
<%@include file="../fragments/breadcrumbs.jspf" %>

<%--Register--%>
<div class="register">

  <div class="container">

    <h2>Sell Product</h2>

    <div class="login-form-grids">

      <form:form method="post" modelAttribute="listing">

        <div class="row">
          <div class="col-xs-12">
            <form:label path="listingName">Product Name</form:label>
            <form:errors cssClass="error" path="listingName"/>
            <div class="form-group">
              <form:input cssClass="form-control" path="listingName" pattern="{1,30}"/>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-xs-12">
            <form:label path="listingQuantity">Quantity</form:label>
            <form:errors cssClass="error" path="listingQuantity"/>
            <div class="form-group">
              <form:input type="number" cssClass="form-control" path="listingQuantity"/>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-xs-12">
            <form:label path="pricePerUnit">Price Per Unit</form:label>
            <form:errors cssClass="error" path="pricePerUnit"/>
            <div class="form-group">
              <form:input cssClass="form-control" path="pricePerUnit" pattern="[0-9]+"/>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-xs-12">
            <form:label path="unitByUnitId.unitId">Unit</form:label>
            <form:errors cssClass="error" path="unitByUnitId.unitId"/>
            <div class="form-group">
              <form:select path="unitByUnitId.unitId"
                           items="${all_units}"
                           itemValue="unitId"
                           itemLabel="unitName"/>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-xs-12">
            <form:label path="productByProductId.productId">Type</form:label>
            <form:errors cssClass="error" path="productByProductId.productId"/>
            <div class="form-group">
              <form:select path="productByProductId.productId"
                           items="${all_products}"
                           itemValue="productId"
                           itemLabel="productName"/>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-xs-12">
            <input type="submit" value="Sell">
          </div>
        </div>

      </form:form>

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