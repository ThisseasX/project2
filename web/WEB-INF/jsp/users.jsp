<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
  <%@include file="../fragments/head.jspf" %>
  <title>Management</title>
</head>

<body>

<%--Header--%>
<%@include file="../fragments/topbar.jspf" %>

<%
  List<String> path = new ArrayList<>(Collections.singletonList("Management"));
  pageContext.setAttribute("path", path);
%>

<%--Breadcrumbs--%>
<%@include file="../fragments/breadcrumbs.jspf" %>

<!-- checkout -->
<div class="checkout">
  <div class="container">

    <div class="checkout-right">

      <table class="timetable_sub">

        <thead>
        <tr>
          <th>ID</th>
          <th>Email</th>
          <th>Name</th>
          <th>Surname</th>
          <th>SSN</th>
          <th>City</th>
          <th>Region</th>
          <th>Address</th>
          <th>Balance</th>
          <th>Role</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="u">
          <tr>
            <td>${u.userId}</td>
            <td>${u.email}</td>
            <td>${u.name}</td>
            <td>${u.surname}</td>
            <td>${u.contact.ssn}</td>
            <td>${u.contact.city}</td>
            <td>${u.contact.region}</td>
            <td>${u.contact.address}</td>
            <td>${u.account.balance}</td>
            <td>${u.role.roleName}</td>
          </tr>
        </c:forEach>
        </tbody>

      </table>

    </div>
    <div class="checkout-left">
      <div class="checkout-right-basket">
        <a href="${pageContext.request.contextPath}/">
          <span class="glyphicon glyphicon-menu-left"
                aria-hidden="true"></span>
          Back to Home
        </a>
      </div>
      <div class="clearfix"></div>
    </div>
  </div>
</div>
<!-- //checkout -->

<%--Footer--%>
<%@include file="../fragments/footer.jspf" %>

</body>
</html>