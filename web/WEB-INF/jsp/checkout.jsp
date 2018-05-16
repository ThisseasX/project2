<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
  <%@include file="../fragments/head.jspf" %>
  <title>Cart</title>
</head>

<body>

<%--Header--%>
<%@include file="../fragments/topbar.jspf" %>

<%
  List<String> path = new ArrayList<>(Collections.singletonList("Cart"));
  pageContext.setAttribute("path", path);
%>

<%--Breadcrumbs--%>
<%@include file="../fragments/breadcrumbs.jspf" %>

<jsp:useBean id="checked_out_cart" scope="session" class="model.Cart"/>

<!-- checkout -->
<div class="faq-w3agile">
  <div class="container" style="background-color:#f5f5f5; padding:20px 40px;
    border: 1px solid rgba(153, 153, 153, 0.144); text-align: center">
<h3>Check Out</h3>
    <h2 style="padding-top: 20px">Congratulations!<br>You just bought the following products:</h2>
<p>Total Quantity: ${checked_out_cart.totalQuantity}</p>
<p>Total Total Price: ${checked_out_cart.totalPrice}</p>
<p>Items:</p>
<c:forEach items="${checked_out_cart.items}" var="l">
  <p>${l.listingName}</p>



</c:forEach>
  </div>
</div>
<!-- //checkout -->

<%--Footer--%>
<%@include file="../fragments/footer.jspf" %>

<script>

    function modifyCart(action, id) {
        $
            .post("${pageContext.request.contextPath}/cart/" + action + "/" + id)
            .always(location.reload())
    }

</script>

</body>
</html>