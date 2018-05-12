<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 1/4/2018
  Time: 11:12 μμ
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<head>
  <%@include file="../reusables/head.jspf" %>
  <title>Cart</title>
</head>
<body>

<div class="container">

  <div class="jumbotron">
    <h1 class="text-center">Cart</h1>
  </div>

  <div class="row">
    <div class="col-md-6 col-md-offset-3">

      <table class="table table-bordered table-hover table-striped">
        <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>User</th>
          <th>Quantity</th>
          <th>Cart</th>
          <th>Price Per Unit</th>
          <th>Total</th>
          <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="cart" scope="session" class="model.Cart"/>
        <c:forEach items="${cart.items}" var="l">
          <tr id="row_${l.listingId}">
            <td>${l.listingId}</td>
            <td>${l.productByProductId.productName}</td>
            <td>${l.userByUserId.name}</td>
            <td>${l.listingQuantity}</td>
            <td id="cart_${l.listingId}">${l.cartQuantity}</td>
            <td id="price_${l.listingId}">${l.pricePerUnit}</td>
            <td id="total_${l.listingId}">${l.cartQuantity * l.pricePerUnit}</td>
            <td>
              <button type="button"
                      class="btn btn-danger btn-number"
                      onclick="subtractFromCart(${l.listingId})">
                <span class="glyphicon glyphicon-minus"></span>
              </button>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>

      <h1 style="background-color: red; color: white;">
        ${cart.totalPrice}
      </h1>

      <button onclick="clearCart()">
        Clear Cart
      </button>

    </div>
  </div>
</div>

<%@include file="../reusables/footer.jspf" %>

<script>

    function clearCart() {
        $.post("${pageContext.request.contextPath}/cart/clear", () => {
            location.reload()
        })
    }

    function subtractFromCart(id) {
        $.post("${pageContext.request.contextPath}/cart/" + id + "/subtract").always(
            location.reload()
        )
    }

</script>

</body>
</html>