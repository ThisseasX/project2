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
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Products</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>

<div class="container">

  <div class="jumbotron">
    <h1 class="text-center">${products[0].categoryByCategoryId.categoryName}</h1>
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
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="p">
          <tr style="cursor: pointer" onclick="redirectToListings(${p.productId})">
            <td>${p.productId}</td>
            <td>${p.productName}</td>
            <td>${p.imagePath}</td>
            <td>${p.basePriceIn}</td>
            <td>${p.basePriceOut}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>

    </div>
  </div>
</div>

<script>

    function redirectToListings(id) {
        window.location.href = "${pageContext.request.contextPath}/admin/listings/" + id;
    }

</script>

</body>
</html>