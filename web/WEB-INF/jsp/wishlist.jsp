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
    <h2>Your wishlist contains: <span>0 Categories</span></h2>
    <div class="checkout-right">


      <%--<tbody>--%>

      <c:choose>

        <c:when test="${wishlist ne null and wishlist.size() > 0}">
          <table class="timetable_sub">

            <thead>
            <tr>
              <th>SL No.</th>
              <th>Image</th>
              <th>Category Name</th>
              <th>Remove</th>
            </tr>
            </thead>
              <%--<table class="table table-bordered table-hover table-striped">--%>
              <%--<thead>--%>
              <%--<tr>--%>
              <%--<th>ID</th>--%>
              <%--<th>Product</th>--%>
              <%--<th>Action</th>--%>
              <%--</tr>--%>
              <%--</thead>--%>
            <tbody>
            <c:forEach items="${wishlist}" var="p">
              <tr>
                <td><div class="common">${p.productId}</div></td>
                <%--<td>${p.imagePath.}</td>--%>
                <td class="invert-image">
                  <a href="${pageContext.request.contextPath}/products/${p.productId}"><img
                    src="${p.imagePath}" alt=" " class="img-responsive"/></a>
                </td>
                <td><div class="common">${p.productName}</div></td>
                <td>
                  <input id="_${p.productId}" class="heart-checkbox" type="checkbox"
                      <c:if test="${wishlist.contains(p)}">
                        checked
                      </c:if>
                  />
                  <label for="_${p.productId}" class="heart" onclick="toggleWish(${p.productId})">❤</label>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
          <%--</table>--%>
        </c:when>

        <c:otherwise>

          <table class="timetable_sub">

            <thead>
            <tr>
              <th>SL No.</th>
              <th>Image</th>
              <th>Category Name</th>
              <th>Remove</th>
            </tr>
            </thead>
            <tbody>
            <tr>

            </tr>
            </tbody>
          </table>
          <div style="text-align:center; font-size:22px; border-bottom:1px solid rgba(0,0,0,0.15);
            border-left:1px solid rgba(0,0,0,0.16); border-right:1px solid rgba(0,0,0,0.16); padding: 5px 0">
            You have no items in your wishlist. <br>Go add some!
          </div>

        </c:otherwise>

      </c:choose>

    </div>
  </div>
</div>


<%--</div>--%>
<%--</div>--%>


<%--<div class="container">--%>


<%--<div class="row">--%>
<%--<div class="col-md-6 col-md-offset-3">--%>

<%--<c:choose>--%>

<%--<c:when test="${wishlist ne null and wishlist.size() > 0}">--%>
<%--<table class="table table-bordered table-hover table-striped">--%>
<%--<thead>--%>
<%--<tr>--%>
<%--<th>ID</th>--%>
<%--<th>Product</th>--%>
<%--<th>Action</th>--%>
<%--</tr>--%>
<%--</thead>--%>
<%--<tbody>--%>
<%--<c:forEach items="${wishlist}" var="p">--%>
<%--<tr>--%>
<%--<td>${p.productId}</td>--%>
<%--<td>${p.productName}</td>--%>
<%--<td>--%>
<%--<input id="_${p.productId}" class="heart-checkbox" type="checkbox"--%>
<%--<c:if test="${wishlist.contains(p)}">--%>
<%--checked--%>
<%--</c:if>--%>
<%--/>--%>
<%--<label for="_${p.productId}" class="heart" onclick="toggleWish(${p.productId})">❤</label>--%>
<%--</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</tbody>--%>
<%--</table>--%>
<%--</c:when>--%>

<%--<c:otherwise>--%>
<%--<h1 style="background-color: #f00">--%>
<%--You have no items in your wishlist! Go add some!--%>
<%--</h1>--%>
<%--</c:otherwise>--%>

<%--</c:choose>--%>

<%--</div>--%>
<%--</div>--%>
<%--</div>--%>

<%--Footer--%>
<%@include file="../fragments/footer.jspf" %>
<%--<%@include file="../fragments/footer_scripts.jspf" %>--%>

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