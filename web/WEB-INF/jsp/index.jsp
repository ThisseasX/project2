<%--suppress CssUnknownTarget --%>
<%--suppress CssOptimizeSimilarProperties --%>
<!doctype html>
<html>

<head>
  <%@include file="../fragments/head.jspf" %>
  <title>Farmers Market</title>
</head>

<body>

<%--Header--%>
<%@include file="../fragments/header.jspf" %>

<%--Slider--%>
<%@include file="../fragments/main-slider.jspf" %>

<%--Parallax--%>
<div id="colorlib-intro" class="colorlib-intro"
     style="background-image: url(images/fruits.jpg); background-attachment: fixed" data-stellar-background-ratio="0.6">

  <div class="container">
    <div class="row">
      <div class="col-md-6">

            <h2>45</h2>
            <p>%</p>
            <p>Off</p>

            <h2>Sale</h2>

            <h3 class="title">Just hurry up limited offer!</h3>
            <p>Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>

            <p>
              <a href="#" class="btn btn-primary">Shop Now</a>
              <a href="#" class="btn btn-primary btn-outline">Read more</a>
            </p>

      </div>
    </div>
  </div>
</div>

<%--Top Brands--%>
<%@include file="../fragments/top-brands.jspf" %>

<%--Carousel--%>
<%@include file="../fragments/carousel.jspf" %>

<%--Banner Bottom--%>
<%@include file="../fragments/banner-bottom.jspf" %>

<%--Footer--%>
<%@include file="../fragments/footer.jspf" %>

</body>

</html>