<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
  <%@include file="../fragments/head.jspf" %>
  <title>FAQ</title>
</head>

<body>
<%--Header--%>
<%@include file="../fragments/topbar.jspf" %>

<%--Breadcrumbs--%>
<%@include file="../fragments/breadcrumbs.jspf" %>

<!-- help-page -->
<div class="faq-w3agile">
  <div class="container" style="background-color:#f5f5f5; padding:20px 40px;
    border: 1px solid rgba(153, 153, 153, 0.144)">
    <h2 class="w3_agile_header">Frequently asked questions (FAQ)</h2>
    <ul class="faq">
      <li class="item1"><a href="#" title="click here"><h4 style="color: #3399cc">What is this?</h4></a>
        <ul>
          <li class="subitem1"><p> This is Farmers Market, a big cooperation of smaller sellers, dedicated to offer only the best quality products.
            <br>If you have some great products to sell, do not hesitate to join our cooperation as a member.
            In case that you cannot
            <br>find your product to our choices, contact us, and we can create a new listing for your offer.</p></li>
        </ul>
      </li>
      <li class="item2"><a href="#" title="click here"><h4 style="color: #fe9126">Who made this?</h4></a>
        <ul>
          <li class="subitem1"><p> This e-shop was carefully designed as a deliverable project from the Tomtogs team for the Alliance for Digital Employability Bootcamp.
            <br>Feel free to browse through the site's numerous capabilities, and appreciate what we have made.</p></li>
        </ul>
      </li>
      <li class="item3"><a href="#" title="click here"><h4 style="color: #3399cc">How can i become a vendor?</h4></a>
        <ul>
          <li class="subitem1"><p> You can be a member <a href="${pageContext.request.contextPath}/users/register" style="text-decoration:none">here</a> and have a chance to sell your products in a wider audience.
            <br>Our cooperation is using a state-of-the-art algorithm to share the profits amongst our members.</p></li>
        </ul>
      </li>
      <li class="item4"><a href="#" title="click here"><h4 style="color: #fe9126">How can i buy your products?</h4></a>
        <ul>
          <li class="subitem1"><p> Create an account <a href="${pageContext.request.contextPath}/users/register" style="text-decoration:none">here</a>
            <br>You can organise your purchases using our site's Cart. Not ready to buy yet?
            <br>Never miss any of our sales and offers, by using our Wishlist.
            <br>Our systems guarantee that no payment method would be a problem for you!</p></li>
        </ul>
      </li>
      <li class="item5"><a href="#" title="click here"><h4 style="color: #3399cc">How can i contact you?</h4></a>
        <ul>
          <li class="subitem1"><p> Complaints? Feedback? Or just saying a quick hello?
            <br>Whatever it is, let u know <a href="${pageContext.request.contextPath}/contact" style="text-decoration:none">here</a>!
            <br> Please insert your name, your email, and whatever you want to tell us!</p></li>
        </ul>
      </li>

    </ul>
    <!-- script for tabs -->
    <script type="text/javascript">
        $(function() {

            var menu_ul = $('.faq > li > ul'),
                menu_a  = $('.faq > li > a');

            menu_ul.hide();

            menu_a.click(function(e) {
                e.preventDefault();
                if(!$(this).hasClass('active')) {
                    menu_a.removeClass('active');
                    menu_ul.filter(':visible').slideUp('normal');
                    $(this).addClass('active').next().stop(true,true).slideDown('normal');
                } else {
                    $(this).removeClass('active');
                    $(this).next().stop(true,true).slideUp('normal');
                }
            });

        });
    </script>
    <!-- script for tabs -->
  </div>
</div>



<%--Footer--%>
<%@include file="../fragments/footer.jspf" %>

</body>
</html>
