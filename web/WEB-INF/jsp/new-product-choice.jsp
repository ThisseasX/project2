<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
  <%@include file="../fragments/head.jspf" %>
  <title>New Product Type</title>
  <style>
    /*.container {*/
    /*padding: 2px 16px;*/
    /*}*/

    .panel {
      box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
      background-color: #3399cc;
      transition: 0.5s;
    }

    .panel:hover {
      box-shadow: 0 6px 10px 0 rgba(0, 0, 0, 0.3);
      background-color: #fe9126;
    }

    /*noinspection CssInvalidHtmlTagReference*/
    darkh {
      background-color: #3399cc;
    }

    .darkh:hover {
      filter: brightness(90%);
      background-color: #fe9126;
    }
  </style>
</head>

<body>

<%--Header--%>
<%@include file="../fragments/topbar.jspf" %>

<%
  List<String> path = new ArrayList<>(Arrays.asList("Management", "New Product Type"));
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

    <c:forEach var="i" begin="0" end="${all_categories.size() - 1}">
      <c:if test="${i eq 0 or i mod 3 eq 0}">
        <div class="agile_top_brands_grids">
      </c:if>
      <div class="col-md-4 top_brand_left" style="cursor: pointer">
        <a href="${pageContext.request.contextPath}/products/new/${all_categories[i].categoryId}">
          <div class="hover14 column panel" style="border-radius:8px;border:1px solid rgba(0, 0, 0, 0.05);">
            <div class="agile_top_brand_left_grid panel darkh" style="border:none;border-radius:8px">
              <div class="agile_top_brand_left_grid1">

                <div class="snipcart-item block">
                  <div class="snipcart-thumb">
                    <div class="product-name">
                        <%--<a href="${pageContext.request.contextPath}/products/new/${all_categories[i].categoryId}">--%>
                      <h2 style="color:white">${all_categories[i].categoryName}</h2>
                        <%--</a>--%>
                    </div>
                  </div>
                </div>

              </div>
            </div>
          </div>
        </a>
      </div>
      <c:if test="${i eq all_categories.size() - 1 or i mod 3 eq 2}">
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