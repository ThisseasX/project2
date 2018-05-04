<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 11/3/2018
  Time: 7:13 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
  <%@include file="../reusables/head.jspf" %>
  <title>Admin Panel</title>
</head>
<body>

<div class="container">

  <div class="jumbotron">
    <h1 class="text-center">Admin</h1>
  </div>

  <div class="row">
    <div class="col-md-4 col-md-offset-4">

      <div class="panel my-panel">

        <div class="panel-heading">
          <div class="row">
            <div class="col-md-12">
              <h1 class="text-center my-header">Actions</h1>
            </div>
          </div>
        </div>

        <hr>

        <div class="panel-body">
          <div class="row">
            <div class="col-md-12">
              <a class="btn btn-primary my-btn" style="margin-top: 16px;"
                 href="${pageContext.request.contextPath}/admin/categories">Manage Categories</a>
              <a class="btn btn-primary my-btn" style="margin-top: 16px;"
                 href="${pageContext.request.contextPath}/admin/products">Manage Products</a>
              <a class="btn btn-primary my-btn" style="margin-top: 16px;"
                 href="${pageContext.request.contextPath}/admin/listings">Manage Listings</a>
            </div>
          </div>
        </div>

      </div>

    </div>
  </div>
</div>

<%@include file="../reusables/footer.jspf" %>

</body>
</html>
