<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
  <%@include file="../fragments/head.jspf" %>
  <title>Sell Product</title>
</head>

<body>

<%--Header--%>
<%@include file="../fragments/topbar.jspf" %>

<%
  List<String> path = new ArrayList<>(Arrays.asList("Management", "Sell Product"));
  pageContext.setAttribute("path", path);
%>

<%--Breadcrumbs--%>
<%@include file="../fragments/breadcrumbs.jspf" %>

<jsp:useBean id="checked_out_cart" scope="session" class="model.Cart"/>

<!-- checkout -->
<div class="faq-w3agile">
  <h3>Supported Products</h3>
  <div class="container" style="background-color:#f5f5f5; margin-top:30px; padding:0 40px;
    border: 1px solid rgba(153, 153, 153, 0.144); text-align: center">

    <c:forEach var="i" begin="0" end="${all_products.size() - 1}">
      <c:if test="${i eq 0 or i mod 3 eq 0}">
        <div class="agile_top_brands_grids">
      </c:if>
      <div class="col-md-4 top_brand_left">
        <div class="hover14 column">
          <div class="agile_top_brand_left_grid">
            <div class="agile_top_brand_left_grid1">
              <figure>
                <div class="snipcart-item block">
                  <div class="snipcart-thumb">
                    <a href="${pageContext.request.contextPath}/listings/new/${all_products[i].productId}">
                      <img title=" " alt=" "
                           src="${pageContext.request.contextPath}/products/image/${all_products[i].productId}">
                    </a>
                    <div class="product-name">${all_products[i].productName}</div>
                    <div class="product-name">Accepted at:</div>
                    <h4>${all_products[i].basePriceIn}&euro;</h4>
                    <div class="product-name">per ${all_products[i].unitByUnitId.unitName}</div>
                  </div>
                </div>
              </figure>
            </div>
          </div>
        </div>
      </div>
      <c:if test="${i eq all_products.size() - 1 or i mod 3 eq 2}">
        <div class="clearfix"></div>
        </div>
      </c:if>
    </c:forEach>
  </div>
</div>
<!-- //checkout -->

<%--Footer--%>
<%@include file="../fragments/footer.jspf" %>

</body>
</html>