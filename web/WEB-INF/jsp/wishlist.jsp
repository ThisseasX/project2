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
  <%@include file="../fragments/head.jspf" %>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/heart.css">
  <title>Wishlist</title>
</head>
<body>

<%--Header--%>
<%@include file="../fragments/topbar.jspf" %>

<%--Breadcrumbs--%>
<%@include file="../fragments/breadcrumbs.jspf" %>

<div class="checkout">
  <div class="container">
    <h2>Your wishlist contains: <span>${wishlist.size()} Categories</span></h2>
    <div class="checkout-right">

      <table class="timetable_sub">

        <thead>
        <tr>
          <th>SL No.</th>
          <th>Image</th>
          <th>Category Name</th>
          <th>Remove</th>
          <c:if test="${newProducts ne null and newProducts.size() > 0}">
            <th>New</th>
          </c:if>
        </tr>
        </thead>

        <tbody>
        <c:if test="${wishlist ne null and wishlist.size() > 0}">
          <c:forEach items="${wishlist}" var="p">
            <tr>
              <td>
                <div class="common">${p.productId}</div>
              </td>
              <td class="invert-image">
                <a href="${pageContext.request.contextPath}/listings/${p.productId}"><img
                    src="${pageContext.request.contextPath}/products/image/${p.productId}" alt=" "
                    class="img-responsive"/></a>
              </td>
              <td>
                <div class="common">${p.productName}</div>
              </td>
              <td>
                <input id="_${p.productId}" class="heart-checkbox" type="checkbox"
                    <c:if test="${wishlist.contains(p)}">
                      checked
                    </c:if>
                />
                <label for="_${p.productId}" class="heart" onclick="toggleWish(${p.productId})">❤</label>
              </td>
              <c:if test="${newProducts ne null and newProducts.size() > 0 and newProducts.contains(p)}">
                <td>New!</td>
              </c:if>
            </tr>
          </c:forEach>
        </c:if>

        </tbody>

      </table>

      <c:if test="${wishlist eq null or wishlist.size() < 1}">
        <div style="text-align:center; font-size:22px; border-bottom:1px solid rgba(0,0,0,0.15);
            border-left:1px solid rgba(0,0,0,0.16); border-right:1px solid rgba(0,0,0,0.16); padding: 5px 0">
          You have no items in your wishlist. <br>Go add some!
        </div>
      </c:if>

    </div>
  </div>
</div>

<%--Footer--%>
<%@include file="../fragments/footer.jspf" %>

<script>

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