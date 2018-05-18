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
<%@include file="../fragments/topbar.jspf" %>

<%--Slider--%>
<%@include file="../fragments/main-slider.jspf" %>

<%--Top Brands--%>
<%@include file="../fragments/top-brands.jspf" %>

<div class="about-slid2 agileits-w3layouts">
  <div class="container">
    <div class="about-slid-info">
      <h2>Reach new clients for your products!</h2>
      <p>We know how hard it can be to find new clients.<br>
        Our website can offer you all the necessary exposure.</p>
    </div>
  </div>
</div>

<div class="container-fluid">
  <div class="about">
    <div class="container col-md-offset-2 col-md-8"
         style="background-color:#f0f0f0;padding-bottom:10px;margin-bottom:80px;border:1px solid rgba(190, 190, 190, 0.3)">
      <div class="about-agileinfo w3layouts">
        <div class="col-md-offset-1 col-md-10 text-center about-wthree-grids grid-top">
          <h4>A WHOLE NEW SHOPPING EXPERIENCE!</h4>
          <p class="top"><br>Organising your purchases can be such a mess! With our new
            <a href="${pageContext.request.contextPath}/cart"
              style="text-decoration:none;color:#4841f4">shopping cart </a>technology,
            hard shopping days belongs to the past.
          <p>Amazing <a href="${pageContext.request.contextPath}/wishlist"
                        style="text-decoration:none; color:#fe9126">wishlist</a> technology! Never miss a discount!
            Our engineers spent a lot of time creating a system that will
            inform you about discounts in products of your interest,
            as well as about products that are available to the market again, after they were depleted.
            <br><br><a href="${pageContext.request.contextPath}/users/register" style="text-decoration:none;
            color:#3399cc">Sign up</a> and manage your account easily! Signing up is free! Our user-oriented process
            guarantees you easy account management.</p>
        </div>
        <div class="clearfix"></div>
      </div>
    </div>
  </div>
</div>

<div class="about-slid3 agileits-w3layouts">
  <div class="container">
    <div class="about-slid-info">
      <h2>Reach new clients for your products!</h2>
      <p>We know how hard it can be to find new clients.<br>
        Our website can offer you all the necessary exposure.</p>
    </div>
  </div>
</div>

<div class="about">
  <div class="container col-md-offset-2 col-md-8"
       style="background-color:#f0f0f0;padding-bottom:10px;margin-bottom:80px;border:1px solid rgba(190, 190, 190, 0.3)">
    <div class="about-agileinfo w3layouts">
      <div class="col-md-offset-1 col-md-10 text-center about-wthree-grids grid-top">
        <h4>WE ARE A BIG COOPERATION OF SMALLER SELLERS</h4>
        <p class="top"><br>Our clients can choose from a big variety of quality
          <a href="${pageContext.request.contextPath}/listings"
            style="text-decoration:none;color:#4841f4">products</a>,
          including fruits, vegetables, dry nuts, cereals, and even dairy products.<br><br>
          Become a <a href="${pageContext.request.contextPath}/users/register"
                      style="text-decoration:none; color:#fe9126">vendor</a> and have a chance to sell your
          products
          in a wider audience, as well as having a share in our profit, using a state-of-the-art algorithm without any
          human interaction!</p>
        <p>As a <a href="${pageContext.request.contextPath}/users/register" style="text-decoration:none; color:#3399cc">client</a>,
          you can create an account
          to stay informed about our sales and offers, and manage your very own cart and wishlist!<br><br>
          Please refer to our <a href="${pageContext.request.contextPath}/faq" style="text-decoration:none;color:#4841f4">FAQ</a>
          section, for more details. </p>
      </div>
      <div class="clearfix"></div>
    </div>
  </div>
</div>

<%--Carousel--%>
<%@include file="../fragments/carousel.jspf" %>

<%--Banner Bottom--%>
<%@include file="../fragments/banner-bottom.jspf" %>

<%--Footer--%>
<%@include file="../fragments/footer.jspf" %>

</body>

</html>