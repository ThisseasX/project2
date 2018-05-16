<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
  <%@include file="../fragments/head.jspf" %>
  <title>About Us</title>
</head>

<body>

<%--Header--%>
<%@include file="../fragments/topbar.jspf" %>

<%--Breadcrumbs--%>
<%@include file="../fragments/breadcrumbs.jspf" %>

<%--About--%>

<div class="about">
  <div class="container">
    <h3 class="w3_agile_header">About Us</h3>
    <div class="about-agileinfo w3layouts">
      <div class="col-md-8 about-wthree-grids grid-top">
        <h4>We are a big cooperation of smaller sellers. </h4>
        <p class="top"><br>Our clients can choose from a big variety of quality <a href="${pageContext.request.contextPath}/listings"
                                                                                   style="text-decoration:none">products</a>,
          including fruits, vegetables, dry nuts, cereals, and even dairy products.<br><br>
          Become a <a href="${pageContext.request.contextPath}/users/register" style="text-decoration:none; color:#fe9126">vendor</a> and have a chance to sell your
          products
          in a wider audience, as well as having a share in our profit, using a state-of-the-art algorithm without any
          human interaction!</p>
        <p>As a <a href="${pageContext.request.contextPath}/users/register" style="text-decoration:none; color:#3399cc">client</a>, you can create an account
          to stay informed about our sales and offers, and manage your very own cart and wishlist!<br><br>
          Please refer to our <a href="${pageContext.request.contextPath}/faq" style="text-decoration:none">FAQ</a> section, for more details. </p>
        <div class="about-w3agilerow">
          <div class="col-md-4 about-w3imgs">
            <img src="${pageContext.request.contextPath}/images/pvs1.jpg" alt="vegetables" class="img-responsive zoom-img"/>
          </div>
          <div class="col-md-4 about-w3imgs">
            <img src="${pageContext.request.contextPath}/images/pfs1.jpg" alt="fruits" class="img-responsive zoom-img"/>
          </div>
          <div class="col-md-4 about-w3imgs">
            <img src="${pageContext.request.contextPath}/images/pds1.jpg" alt="dairy" class="img-responsive zoom-img"/>
          </div>
          <div class="clearfix"></div>
        </div>
      </div>
      <div class="col-md-4 about-wthree-grids">
        <div class="offic-time">
          <div class="time-top">
            <h4>FARMERS MARKET</h4>
          </div>
          <div class="time-bottom">
            <h5>Enjoy your shopping </h5>
            <h5>experience! </h5>
            <p>Members and administration are welcoming you to our shop! </p>
          </div>
        </div>
        <div class="testi">
          <h3 class="w3_agile_header" style="font-size:25px; padding-top: 14px">TESTIMONIALS </h3>
          <%--End-slider-script--%>
          <script src="${pageContext.request.contextPath}/js/responsiveslides.min.js"></script>
          <script>
              // You can also use "$(window).load(function() {"
              $(function () {
                  // Slideshow 5
                  $("#slider5").responsiveSlides({
                      auto: true,
                      pager: false,
                      nav: true,
                      speed: 500,
                      namespace: "callbacks",
                      before: function () {
                          $('.events').append("<li>before event fired</li>");
                      },
                      after: function () {
                          $('.events').append("<li>after event fired.</li>");
                      }
                  });

              });
          </script>
          <div id="top" class="callbacks_container">
            <ul class="rslides" id="slider5">
              <li>
                <div class="testi-slider">
                  <h4>" I AM VERY PLEASED!</h4>
                  <p>My order came on time, and there were no hidden charges.
                    Everything they have is of great quality, but above all, i would
                    recomment their dry nuts!</p>
                  <div class="testi-subscript">
                    <p><a href="#">Jonathan McCool,</a>client</p>
                    <span class="w3-agilesub"> </span>
                  </div>
                </div>
              </li>
              <li>
                <div class="testi-slider">
                  <h4>" POSITIVELY SURPRISED...</h4>
                  <p>I was positively surprised about how organised was Farmers Market's wishlist.
                    I was informed about their discounts on time, and managed to buy
                    my favorite fruits in a lower price!</p>
                  <div class="testi-subscript">
                    <p><a href="#">Elit Stemper,</a>client</p>
                    <span class="w3-agilesub"> </span>
                  </div>
                </div>
              </li>
              <li>
                <div class="testi-slider">
                  <h4>" MY PRODUCTS MATTER!</h4>
                  <p>This cooperation really made me feel that my products matter!
                    My fruits were sold to places that i could never manage to sell them on my own!</p>
                  <div class="testi-subscript">
                    <p><a href="#">L. von Matterhorn,</a>vendor</p>
                    <span class="w3-agilesub"> </span>
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div class="clearfix"></div>
    </div>
  </div>
</div>

<%--About--%>

<%--About-slid--%>

<div class="about-slid agileits-w3layouts">
  <div class="container">
    <div class="about-slid-info">
      <h2>Work with us, our profit shares worth it!</h2>
      <p>Vendors are the backbone of the Farmers Market.
        FM has enjoyed a reputation for relationship building
        among its vendors, and has been instrumental in
        taking several local businesses to the next level
        of their success.</p>
    </div>
  </div>
</div>

<%--About-slid--%>

<%--Footer--%>
<%@include file="../fragments/footer.jspf" %>

</body>
</html>
