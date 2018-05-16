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
  <h3>Checkout</h3>
  <div class="container" style="background-color:#f5f5f5; margin-top:30px; padding:0px 40px;
    border: 1px solid rgba(153, 153, 153, 0.144); text-align: center">

    <h2 style="padding-top: 20px">Congratulations!<br>you just purchased the following products:</h2>

    <c:forEach var="i" begin="0" end="${checked_out_cart.items.size() - 1}">
      <c:if test="${i eq 0 or i mod 3 eq 0}">
        <div class="agile_top_brands_grids">
      </c:if>
      <div class="col-md-4 top_brand_left">
        <div class="hover14 column">
          <div class="agile_top_brand_left_grid">
            <c:if test="${checked_out_cart.items[i].productByProductId.discount > 1}">
              <div class="agile_top_brand_left_grid_pos">
                <img src="${pageContext.request.contextPath}/images/offer.png" alt=" " class="img-responsive">
              </div>
            </c:if>
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
                    <div class="product-name">${checked_out_cart.items[i].listingName}
                      x${checked_out_cart.items[i].cartQuantity}</div>
                    <h4>${checked_out_cart.items[i].pricePerUnit * checked_out_cart.items[i].cartQuantity}&euro;</h4>
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
    <br>
    <h2>Total Quantity: ${checked_out_cart.totalQuantity}</h2>
    <br>
    <h2>Total Price: ${checked_out_cart.totalPrice}&euro;</h2>
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