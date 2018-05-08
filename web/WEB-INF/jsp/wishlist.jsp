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
  <title>Wishlist</title>
</head>
<body>

<div class="container">

  <div class="jumbotron">
    <h1 class="text-center">Wishlist</h1>
  </div>

  <div class="row">
    <div class="col-md-6 col-md-offset-3">

      <table class="table table-bordered table-hover table-striped">
        <thead>
        <tr>
          <th>ID</th>
          <th>User</th>
          <th>Product</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${wishlist}" var="w">
          <tr>
            <td>${w.wishId}</td>
            <td>${w.userByUserId.name}</td>
            <td>${w.productByProductId.productName}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>

    </div>
  </div>
</div>

<%@include file="../reusables/footer.jspf" %>

</body>
</html>