<%@ page import="entities.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<head>
  <%@include file="../fragments/head.jspf" %>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login-register.css">
  <title>New Product Type</title>
</head>

<body>

<%--Header--%>
<%@include file="../fragments/topbar.jspf" %>

<%
  Category selected = (Category) request.getAttribute("selected");
  String selectedName = selected.getCategoryName();
  List<String> path = new ArrayList<>(Arrays.asList("Manage", "New Product Type", selectedName));
  pageContext.setAttribute("path", path);
%>

<%--Breadcrumbs--%>
<%@include file="../fragments/breadcrumbs.jspf" %>

<%--Register--%>
<div class="register">

  <div class="container">

    <h2>New Product Type</h2>

    <div class="login-form-grids">

      <form method="post" enctype="multipart/form-data">

        <h1>${selected.categoryName}</h1>

        <div class="row">
          <div class="col-xs-12">
            <label for="productType">Product Type</label>
            <div class="form-group">
              <input type="text" id="productType" name="productType" class="form-control" pattern="{1,30}">
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-xs-12">
            <label for="pricePerUnit">Price Per Unit</label>
            <div class="form-group">
              <input type="number" id="pricePerUnit" name="pricePerUnit" class="form-control" pattern="[0-9]+">
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-xs-12">
            <label for="unitId">Unit</label>
            <select id="unitId" name="unitId">
              <c:forEach items="${all_units}" var="u">
                <option value="${u.unitId}">
                    ${u.unitName}
                </option>
              </c:forEach>
            </select>
          </div>
        </div>

        <div class="row">
          <div class="col-xs-12">
            <label for="image">Image</label>
            <div class="form-group">
              <input type="file" id="image" name="image" class="form-control">
            </div>
          </div>
        </div>

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