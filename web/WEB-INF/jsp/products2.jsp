<%--
  Created by IntelliJ IDEA.
  User: Konstantinos
  Date: 14/5/2018
  Time: 8:18 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <%@include file="../fragments/head.jspf" %>
  <title>Products2</title>
</head>

<body>

<%--Header--%>
<%@include file="../fragments/topbar.jspf" %>

<%--Breadcrumbs--%>
<%@include file="../fragments/breadcrumbs.jspf" %>

<c:forEach items="${categories}" var="c">
  <%--<div class="multi-gd-img">--%>
  <%--<ul class="multi-column-dropdown">--%>

  <%--<h6>${c.categoryName}</h6>--%>

  <%--<c:forEach items="${c.productsByCategoryId}" var="p">--%>
  <%--<li>--%>
  <%--<a href="${pageContext.request.contextPath}/listings/${p.productId}">--%>
  <%--${p.productName}--%>
  <%--</a>--%>
  <%--</li>--%>
  <%--</c:forEach>--%>

  <%--</ul>--%>
  <%--</div>--%>
</c:forEach>

<div class="products">

  <div class="container">

    <div class="col-md-4 products-left">
      <div class="categories">
        <h2>Categories</h2>
        <ul class="cate">
          <c:forEach items="${categories}" var="c">
            <li><a href="#"><i class="fa fa-arrow-right" aria-hidden="true"></i>${c.categoryName}</a></li>
            <ul>
              <c:forEach items="${c.productsByCategoryId}" var="p">
                <li><a href="#"><i class="fa fa-arrow-right" aria-hidden="true"></i>${p.productName}</a></li>
              </c:forEach>
            </ul>
          </c:forEach>
        </ul>
      </div>
    </div>

    <div class="col-md-8 products-right">
      <div class="products-right-grid">
        <div class="products-right-grids">
          <div class="sorting">
            <select id="country" onchange="change_country(this.value)" class="frm-field required sect">
              <option value="null"><i class="fa fa-arrow-right" aria-hidden="true"></i>Default sorting</option>
              <option value="null"><i class="fa fa-arrow-right" aria-hidden="true"></i>Sort by popularity</option>
              <option value="null"><i class="fa fa-arrow-right" aria-hidden="true"></i>Sort by average rating</option>
              <option value="null"><i class="fa fa-arrow-right" aria-hidden="true"></i>Sort by price</option>
            </select>
          </div>
          <div class="sorting-left">
            <select id="country1" onchange="change_country(this.value)" class="frm-field required sect">
              <option value="null"><i class="fa fa-arrow-right" aria-hidden="true"></i>Item on page 9</option>
              <option value="null"><i class="fa fa-arrow-right" aria-hidden="true"></i>Item on page 18</option>
              <option value="null"><i class="fa fa-arrow-right" aria-hidden="true"></i>Item on page 32</option>
              <option value="null"><i class="fa fa-arrow-right" aria-hidden="true"></i>All</option>
            </select>
          </div>
          <div class="clearfix"></div>
        </div>
      </div>


      <div class="agile_top_brands_grids">
        <c:forEach items="${listings}" var="l">
        <div class="col-md-4 top_brand_left">
          <div class="hover14 column">
            <div class="agile_top_brand_left_grid">
              <div class="agile_top_brand_left_grid_pos">
                <img src="images/offer.png" alt=" " class="img-responsive">
              </div>
              <div class="agile_top_brand_left_grid1">
                <figure>
                  <div class="snipcart-item block">
                    <div class="snipcart-thumb">
                      <a href="single.html"><img title=" " alt=" " src="images/pf4.png"></a>
                      <p>Sampann-toor-dal</p>
                      <h4>$35.99 <span>$55.00</span></h4>
                    </div>
                    <div class="snipcart-details top_brand_home_details">
                      <form action="#" method="post">
                        <fieldset>
                          <input type="hidden" name="cmd" value="_cart">
                          <input type="hidden" name="add" value="1">
                          <input type="hidden" name="business" value=" ">
                          <input type="hidden" name="item_name" value="Fortune Sunflower Oil">
                          <input type="hidden" name="amount" value="35.99">
                          <input type="hidden" name="discount_amount" value="1.00">
                          <input type="hidden" name="currency_code" value="USD">
                          <input type="hidden" name="return" value=" ">
                          <input type="hidden" name="cancel_return" value=" ">
                          <input type="submit" name="submit" value="Add to cart" class="button">
                        </fieldset>
                      </form>
                    </div>
                  </div>
                </figure>
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
        <div class="clearfix"></div>
      </div>




      <nav class="numbering">
        <ul class="pagination paging">
          <li>
            <a href="#" aria-label="Previous">
              <span aria-hidden="true">&laquo;</span>
            </a>
          </li>
          <li class="active"><a href="#">1<span class="sr-only">(current)</span></a></li>
          <li><a href="#">2</a></li>
          <li><a href="#">3</a></li>
          <li><a href="#">4</a></li>
          <li><a href="#">5</a></li>
          <li>
            <a href="#" aria-label="Next">
              <span aria-hidden="true">&raquo;</span>
            </a>
          </li>
        </ul>
      </nav>
    </div>
    <div class="clearfix"></div>
  </div>
</div>

<%--Footer--%>
<%@include file="../fragments/footer.jspf" %>
</body>
</html>
