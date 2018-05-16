<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
  <%@include file="../fragments/head.jspf" %>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/heart.css">
  <title>Products</title>
</head>

<body>

<%--Header--%>
<%@include file="../fragments/topbar.jspf" %>

<%
  List<String> path = new ArrayList<>(Collections.singletonList("Products"));
  pageContext.setAttribute("path", path);
%>

<%--Breadcrumbs--%>
<%@include file="../fragments/breadcrumbs.jspf" %>

<%--Products--%>
<div class="products">

  <div class="container">

    <div class="col-md-4 products-left">
      <div class="categories">
        <h2>Categories</h2>
        <ul class="cate">
          <c:forEach items="${categories}" var="c">
            <li><a href="${pageContext.request.contextPath}/products/${c.categoryId}">
              <i class="fa fa-arrow-right"
                 aria-hidden="true"></i>${c.categoryName}
            </a></li>
            <ul>
              <c:forEach items="${c.productsByCategoryId}" var="p">
                <li><a href="${pageContext.request.contextPath}/listings/${p.productId}">
                  <i class="fa fa-arrow-right"
                     aria-hidden="true"></i>${p.productName}
                </a></li>
              </c:forEach>
            </ul>
          </c:forEach>
        </ul>
      </div>
    </div>

    <div class="col-md-8 products-right">
      <div class="products-right-grid">
        <div class="products-right-grids">
          <div class="product-title">${selected}</div>
          <div class="clearfix"></div>
        </div>
      </div>

      <c:choose>
        <c:when test="${listings ne null and listings.size() > 0}">
          <c:forEach var="i" begin="0" end="${listings.size() - 1}">
            <c:if test="${i eq 0 or i mod 3 eq 0}">
              <div class="agile_top_brands_grids">
            </c:if>
            <div class="col-md-4 top_brand_left">
              <div class="hover14 column">
                <div class="agile_top_brand_left_grid">
                  <c:if test="${listings[i].productByProductId.discount > 1}">
                    <div class="agile_top_brand_left_grid_pos">
                      <img src="${pageContext.request.contextPath}/images/offer.png" alt="offer" class="img-responsive">
                    </div>
                  </c:if>
                  <%--<input class="heart" style="padding:0; margin:0;" type="button" onclick="toggleWish(${listings[i].productByProductId.productId})" value="">--%>

                  <div class="heart-checkbox">
                  <label class="heart" onclick="toggleWish(${listings[i].productByProductId.productId})">❤</label>
                  </div>
                  <div class="agile_top_brand_left_grid1">
                    <figure>
                      <div class="snipcart-item block">
                        <div class="snipcart-thumb">
                          <a href="#"><img title=" " alt=" " src="<c:choose>
                              <c:when test="${listings[i].imagePath ne null and listings[i].imagePath.length() > 0}">
                                ${pageContext.request.contextPath}/${listings[i].imagePath}
                              </c:when>
                              <c:otherwise>
                                ${pageContext.request.contextPath}/${listings[i].productByProductId.imagePath}
                              </c:otherwise>
                            </c:choose>"></a>
                          <div class="product-name">${listings[i].listingName}<br>
                            <div style="color: #3399cc"> by ${listings[i].userByUserId.name}</div></div>
                          <h4>${listings[i].pricePerUnit}&euro;</h4>

                        </div>
                        <div class="snipcart-details top_brand_home_details">
                          <form action="${pageContext.request.contextPath}/cart/add/${listings[i].listingId}"
                                method="post">
                            <fieldset>
                              <input type="button" onclick="addToCart(${listings[i].listingId})" name="submit"
                                     value="add to cart" class="button">
                              <%--<form action="#">--%>
                                <%--<input type="button" onclick="toggleWish(${listings[i].productByProductId.productId})" class="button2" value="wishlist">--%>
                              <%--</form>--%>
                            </fieldset>
                          </form>
                        </div>
                      </div>
                    </figure>
                  </div>
                </div>
              </div>
            </div>
            <c:if test="${i eq listings.size() - 1 or i mod 3 eq 2}">
              <div class="clearfix"></div>
              </div>
            </c:if>
          </c:forEach>
        </c:when>
        <c:when test="${products ne null and products.size() > 0}">
          <c:forEach var="i" begin="0" end="${products.size() - 1}">
            <c:if test="${i eq 0 or i mod 3 eq 0}">
              <div class="agile_top_brands_grids">
            </c:if>
            <div class="col-md-4 top_brand_left">
              <div class="hover14 column">
                <div class="agile_top_brand_left_grid">
                  <c:if test="${products[i].discount > 1}">
                    <div class="agile_top_brand_left_grid_pos">
                      <img src="${pageContext.request.contextPath}/images/offer.png" alt=" " class="img-responsive">
                    </div>
                  </c:if>
                  <div class="agile_top_brand_left_grid1">
                    <figure>
                      <div class="snipcart-item block">
                        <div class="snipcart-thumb">
                          <a href="${pageContext.request.contextPath}/listings/${products[i].productId}">
                            <img title=" " alt=" "
                                 src="${pageContext.request.contextPath}/${products[i].imagePath}">
                          </a>
                          <div class="product-name">${products[i].productName}</div>
                        </div>
                      </div>
                    </figure>
                  </div>
                </div>
              </div>
            </div>
            <c:if test="${i eq products.size() - 1 or i mod 3 eq 2}">
              <div class="clearfix"></div>
              </div>
            </c:if>
          </c:forEach>
        </c:when>
      </c:choose>

    </div>
    <div class="clearfix"></div>
  </div>
</div>
<%--//Products--%>

<%--Footer--%>
<%@include file="../fragments/footer.jspf" %>

<script>

    function addToCart(id) {
        window.event.stopPropagation();
        $.post("${pageContext.request.contextPath}/cart/add/" + id, (data) => {
            $("#cart_quantity").text(data);
        });
    }

    function toggleWish(productId) {
        // Stop Event Propagation
        let e = window.event;
        e.cancelBubble = true;
        if (e.stopPropagation) e.stopPropagation();

        $.post("${pageContext.request.contextPath}/wishlist/" + productId)
    }

</script>

</body>
</html>
