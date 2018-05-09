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

      <c:choose>

        <c:when test="${wishlist ne null}">
          <table class="table table-bordered table-hover table-striped">
            <thead>
            <tr>
              <th>ID</th>
              <th>User</th>
              <th>Product</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${wishlist.wishes}" var="w">
              <tr>
                <td>${w.wishId}</td>
                <td>${w.userByUserId.name}</td>
                <td>${w.productByProductId.productName}</td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </c:when>

        <c:otherwise>
          <c:choose>
            <%--@elvariable id="wish" type="entities.Wish"--%>
            <c:when test="${wish ne null}">
              <%--TODO: Prosoxh: Inline CSS--%>
              <div style="background-color: #f00">
                <h1 style="text-align: center">Thank you for adding your wish!</h1>
                <h3 style="text-align: center">${wish.wishId}</h3>
                <h3 style="text-align: center">${wish.userByUserId.name}</h3>
                <h3 style="text-align: center">${wish.productByProductId.productName}</h3>
              </div>
            </c:when>

            <c:otherwise><%--@elvariable id="error" type="java.lang.String"--%>
              <h1 style="background-color: #f00">
                  ${error}
              </h1>
            </c:otherwise>

          </c:choose>

        </c:otherwise>

      </c:choose>

    </div>
  </div>
</div>

<%@include file="../reusables/footer.jspf" %>

</body>
</html>