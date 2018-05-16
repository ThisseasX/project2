<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
  <%@include file="../fragments/head.jspf" %>
  <title>Cart</title>
</head>

<body>

<%--Header--%>
<%@include file="../fragments/topbar.jspf" %>

<%
  List<String> path = new ArrayList<>(Arrays.asList("Cart", "Checkout"));
  pageContext.setAttribute("path", path);
%>

<%--Breadcrumbs--%>
<%@include file="../fragments/breadcrumbs.jspf" %>

<jsp:useBean id="checked_out_cart" scope="session" class="model.Cart"/>

<!-- checkout -->
<div class="faq-w3agile">
  <div class="container" style="background-color:#f5f5f5; padding:20px 40px;
    border: 1px solid rgba(153, 153, 153, 0.144); text-align: center">
    <h3>Checkout</h3>
    <h2 style="padding-top: 20px">Congratulations!<br>You just bought the following products:</h2>
    <p>Total Quantity: ${checked_out_cart.totalQuantity}</p>
    <p>Total Total Price: ${checked_out_cart.totalPrice}</p>
    <p>Items:</p>
    <c:forEach var="i" begin="0" end="${checked_out_cart.items.size() - 1}">
      <c:if test="${i eq 0 or i mod 3 eq 0}">
        <div class="agile_top_brands_grids">
      </c:if>
      <div class="col-md-4 top_brand_left">
        <div class="hover14 column">
          <div class="agile_top_brand_left_grid">
            <div class="agile_top_brand_left_grid_pos">
              <img src="${pageContext.request.contextPath}/images/offer.png" alt=" " class="img-responsive">
            </div>
            <div class="agile_top_brand_left_grid1">
              <figure>
                <div class="snipcart-item block">
                  <div class="snipcart-thumb">
                    <a href="#"><img title=" " alt=" " src="<c:choose>
                              <c:when test="${checked_out_cart.items[i].imagePath ne null and checked_out_cart.items[i].imagePath.length() > 0}">
                                ${pageContext.request.contextPath}/${checked_out_cart.items[i].imagePath}
                              </c:when>
                              <c:otherwise>
                                ${pageContext.request.contextPath}/${checked_out_cart.items[i].productByProductId.imagePath}
                              </c:otherwise>
                            </c:choose>"></a>
                    <div class="product-name">${checked_out_cart.items[i].listingName}</div>
                    <h4>${checked_out_cart.items[i].pricePerUnit}&euro;</h4>
                  </div>
                  <div class="snipcart-details top_brand_home_details">
                    <form action="${pageContext.request.contextPath}/cart/add/${checked_out_cart.items[i].listingId}"
                          method="post">
                      <fieldset>
                        <input type="hidden" name="cmd" value="_cart">
                        <input type="hidden" name="add" value="1">
                        <input type="hidden" name="business" value=" ">
                        <input type="hidden" name="item_name" value="${checked_out_cart.items[i].listingName}">
                        <input type="hidden" name="amount" value="${checked_out_cart.items[i].pricePerUnit}">
                        <input type="hidden" name="discount_amount" value="0.00">
                        <input type="hidden" name="unit" value="${checked_out_cart.items[i].unitByUnitId.unitId}">
                        <input type="hidden" name="return" value=" ">
                        <input type="hidden" name="cancel_return" value=" ">
                        <input type="button" onclick="addToCart(${checked_out_cart.items[i].listingId})" name="submit"
                               value="cart" class="button">
                        <form action="#">
                          <input type="button" class="button2" value="wishlist">
                        </form>
                      </fieldset>
                    </form>
                  </div>
                </div>
              </figure>
            </div>
          </div>
        </div>
      </div>
      <c:if test="${i eq checked_out_cart.items.size() - 1 or i mod 3 eq 2}">
        <div class="clearfix"></div>
        </div>
      </c:if>
    </c:forEach>
  </div>
</div>
<!-- //checkout -->

<%--Footer--%>
<%@include file="../fragments/footer.jspf" %>

<script>

    function modifyCart(action, id) {
        $
            .post("${pageContext.request.contextPath}/cart/" + action + "/" + id)
            .always(location.reload())
    }

</script>

</body>
</html>