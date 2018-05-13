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
  <%@include file="../fragments/head.jspf" %>
  <title>Cart</title>
</head>
<body>

<div class="container">

  <div class="jumbotron">
    <h1 class="text-center">Cart</h1>
  </div>

  <%--<div class="row">--%>
  <%--<div class="col-md-6 col-md-offset-3">--%>

  <%--<table class="table table-bordered table-hover table-striped">--%>
  <%--<thead>--%>
  <%--<tr>--%>
  <%--<th>ID</th>--%>
  <%--<th>Name</th>--%>
  <%--<th>User</th>--%>
  <%--<th>Quantity</th>--%>
  <%--<th>Cart</th>--%>
  <%--<th>Price Per Unit</th>--%>
  <%--<th>Total</th>--%>
  <%--<th>Action</th>--%>
  <%--</tr>--%>
  <%--</thead>--%>
  <%--<tbody>--%>
  <%--<jsp:useBean id="cart" scope="session" class="model.Cart"/>--%>
  <%--<c:forEach items="${cart.items}" var="l">--%>
  <%--<tr id="row_${l.listingId}">--%>
  <%--<td>${l.listingId}</td>--%>
  <%--<td>${l.productByProductId.productName}</td>--%>
  <%--<td>${l.userByUserId.name}</td>--%>
  <%--<td>${l.listingQuantity}</td>--%>
  <%--<td id="cart_${l.listingId}">${l.cartQuantity}</td>--%>
  <%--<td id="price_${l.listingId}">${l.pricePerUnit}</td>--%>
  <%--<td id="total_${l.listingId}">${l.cartQuantity * l.pricePerUnit}</td>--%>
  <%--<td>--%>
  <%--<button type="button"--%>
  <%--class="btn btn-danger btn-number"--%>
  <%--onclick="subtractFromCart(${l.listingId})">--%>
  <%--<span class="glyphicon glyphicon-minus"></span>--%>
  <%--</button>--%>
  <%--</td>--%>
  <%--</tr>--%>
  <%--</c:forEach>--%>
  <%--</tbody>--%>
  <%--</table>--%>

  <%--<h1 style="background-color: red; color: white;">--%>
  <%--${cart.totalPrice}--%>
  <%--</h1>--%>

  <%--<button onclick="clearCart()">--%>
  <%--Clear Cart--%>
  <%--</button>--%>

  <%--</div>--%>
  <%--</div>--%>
</div>

<!-- checkout -->
<div class="checkout">
  <div class="container">
    <h2>Your shopping cart contains: <span>${cart.totalNumber} Products</span></h2>
    <div class="checkout-right">
      <table class="timetable_sub">
        <thead>
        <tr>
          <th>SL No.</th>
          <th>Image</th>
          <th>Product Name</th>
          <th>Vendor</th>
          <th>Available</th>
          <th>Quantity</th>
          <th>PPU</th>
          <th>Price</th>
          <th>Remove</th>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="cart" scope="session" class="model.Cart"/>
        <c:forEach items="${cart.items}" var="l">
          <tr id="row_${l.listingId}" class="rem1">
            <td class="invert">${l.listingId}</td>
            <td class="invert-image"><a href="single.html"><img src="images/1.png" alt=" " class="img-responsive"/></a>
            </td>
            <td class="invert">${l.productByProductId.productName}</td>
            <td class="invert">${l.userByUserId.name}</td>
            <td class="invert">${l.listingQuantity}</td>
            <td id="cart_${l.listingId}" class="invert">
              <div class="quantity">
                <div class="quantity-select">
                  <div class="entry value-minus">&nbsp;</div>
                  <div class="entry value"><span>${l.cartQuantity}</span></div>
                  <div class="entry value-plus active">&nbsp;</div>
                </div>
              </div>
            </td>
            <td id="price_${l.listingId}" class="invert">$${l.pricePerUnit}</td>
            <td id="total_${l.listingId}" class="invert">$${l.cartQuantity * l.pricePerUnit}</td>
            <td class="invert">
              <div class="rem">
                  <button type="button"
                          class="btn btn-danger btn-number"
                          onclick="subtractFromCart(${l.listingId})">
                    <span class="glyphicon glyphicon-minus"></span>
                  </button>
              </div>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
    <div class="checkout-left">
      <div class="checkout-left-basket">
        <ul>
          <%--<li>Product1 <i>-</i> <span>$15.00 </span></li>--%>
          <%--<li>Product2 <i>-</i> <span>$25.00 </span></li>--%>
          <%--<li>Product3 <i>-</i> <span>$29.00 </span></li>--%>
          <li style="font-size: 22px">Total Price<i> :</i> <span>$${cart.totalPrice}</span></li>
        </ul>
        <a href="#"><h4>Proceed to Checkout</h4></a>
            <button onclick="clearCart()">Clear Cart</button>
      </div>
      <div class="checkout-right-basket">
        <a href="#"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>Continue
          Shopping</a>
      </div>
      <div class="clearfix"></div>
    </div>
  </div>
</div>
<!-- //checkout -->

<%@include file="../fragments/footer_scripts.jspf" %>

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