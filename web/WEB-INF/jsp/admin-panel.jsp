<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
  <%@include file="../fragments/head.jspf" %>
  <title>Admin Panel</title>
  <style>
    .container {
      padding: 2px 16px;
    }

    .panel {
      box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
      transition: 0.5s;
    }

    .panel:hover {
      box-shadow: 0 6px 10px 0 rgba(0, 0, 0, 0.3);
    }

    .darkh:hover {
      filter: brightness(88%);
    }
  </style>
</head>

<body>

<%--Header--%>
<%@include file="../fragments/topbar.jspf" %>

<%--Breadcrumbs--%>
<%@include file="../fragments/breadcrumbs.jspf" %>

<div class="faq-w3agile">
  <h3>Admin Panel</h3>
  <div class="container" style="background-color:#f5f5f5; margin-top:30px; padding:0 20px 40px 20px;
    border: 1px solid rgba(153, 153, 153, 0.144); text-align: center">
    <div class="agile_top_brands_grids">
      <div class="col-md-6 top_brand_left" style="cursor: pointer;">
        <a style="text-decoration:none;" href="${pageContext.request.contextPath}/admin/listings/all">
          <div class="hover14 column panel"
               style="border-radius:8px;color:#fe9126;border:1px solid rgba(0, 0, 0, 0.05);">
            <div class="agile_top_brand_left_grid panel darkh" style="background-color:#fe9126;border:none;border-radius:8px">
              <div class="agile_top_brand_left_grid1">
                <div class="snipcart-item block">
                  <div class="snipcart-thumb">
                    <div class="product-name">
                      <h1 style="color:white">Manage Products</h1>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </a>
      </div>
      <div class="col-md-6 top_brand_left" style="cursor: pointer;">
        <a style="text-decoration:none;" href="${pageContext.request.contextPath}/products/new">
          <div class="hover14 column panel"
               style="border-radius:8px;color:#58a23e;border:1px solid rgba(0, 0, 0, 0.05);">
            <div class="agile_top_brand_left_grid panel darkh" style="background-color:#58a23e;border:none;border-radius:8px">
              <div class="agile_top_brand_left_grid1">
                <div class="snipcart-item block">
                  <div class="snipcart-thumb">
                    <div class="product-name">
                      <h1 style="color:white">New Product Type</h1>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </a>
      </div>
      <div class="clearfix"></div>
    </div>
    <div class="agile_top_brands_grids">
      <div class="col-md-6 top_brand_left" style="cursor: pointer;">
        <a style="text-decoration:none;" href="${pageContext.request.contextPath}/users/all">
          <div class="hover14 column panel"
               style="border-radius:8px;color:#3399cc;border:1px solid rgba(0, 0, 0, 0.05);">
            <div class="agile_top_brand_left_grid panel darkh" style="background-color:#3399cc;border:none;border-radius:8px">
              <div class="agile_top_brand_left_grid1">
                <div class="snipcart-item block">
                  <div class="snipcart-thumb">
                    <div class="product-name">
                      <h1 style="color:white">User Details</h1>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </a>
      </div>
      <div class="col-md-6 top_brand_left" style="cursor: pointer;">
        <a style="text-decoration:none;" href="${pageContext.request.contextPath}/sales/all">
          <div class="hover14 column panel"
               style="border-radius:8px;color:#df533a;border:1px solid rgba(0, 0, 0, 0.05);">
            <div class="agile_top_brand_left_grid panel darkh" style="background-color:#df533a;border:none;border-radius:8px">
              <div class="agile_top_brand_left_grid1">
                <div class="snipcart-item block">
                  <div class="snipcart-thumb">
                    <div class="product-name">
                      <h1 style="color:white">Sales History</h1>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </a>
      </div>
      <div class="clearfix"></div>
    </div>
  </div>
</div>


<%--Footer--%>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>
