<%@ page import="entities.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<head>
  <%@include file="../fragments/head.jspf" %>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login-register.css">
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

    <h2 style="margin-bottom:25px">New Product Type</h2>

    <div class="login-form-grids" style="border:1px solid rgba(190, 190, 190, 0.3);background-color:#f0f0f0">

      <form method="post" enctype="multipart/form-data">

        <h1 style="text-align:center;margin-bottom:20px">${selected.categoryName}</h1>

        <div class="row">
          <div class="col-xs-12" style="font-size:17px">
            <label for="productType">Product Type</label>
            <div class="form-group">
              <input type="text" id="productType" name="productType" class="form-control" pattern="{1,30}">
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-xs-12" style="font-size:17px">
            <label for="pricePerUnit">Price Per Unit</label>
            <div class="form-group">
              <input type="number" id="pricePerUnit" name="pricePerUnit" class="form-control" pattern="[0-9]+">
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-md-offset-4 col-xs-6" style="font-size:17px;margin-top:10px">
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
          <div class="col-xs-12" style="font-size:17px">
            <label for="image">Image</label>
            <div class="form-group">
              <input type="file" id="image" name="image" class="form-control">
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-xs-12">
            <input type="submit" value="SUBMIT">
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