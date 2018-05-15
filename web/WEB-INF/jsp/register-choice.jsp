<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<head>
  <%@include file="../fragments/head.jspf" %>
  <title>Register</title>
  <style>
    .card {
      box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
      transition: 0.3s;
      margin-top: 5px;
      padding: 10px 10px;
      /* width: 40%; */
    }

    .card:hover {
      box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.6);
    }

    .container {
      padding: 2px 16px;
    }
  </style>
</head>

<body>

<%--Header--%>
<%@include file="../fragments/topbar.jspf" %>

<%
  List<String> path = new ArrayList<>(Collections.singletonList("Register"));
  pageContext.setAttribute("path", path);
%>

<%--Breadcrumbs--%>
<%@include file="../fragments/breadcrumbs.jspf" %>

<%--Register--%>
<div class="register">

  <h2>Create New Account</h2>

  <div class="container">
    <div class="register" style="width:45%; float:left; padding-top:16px">
      <div class="card" onclick="window.location.href='${pageContext.request.contextPath}/users/register/2'">
        <h2 style="font-size:30px; margin-bottom:10px; padding-bottom:5px">Vendor</h2>
        <img src="${pageContext.request.contextPath}/images/member.jpg" alt="vendor" style="width:100%">
      </div>
    </div>
    <div style="width:10%; float:left; margin-top:1px"></div>
    <div class="register" style="width:45%; float:left; padding-top:16px">
      <div class="card" onclick="window.location.href='${pageContext.request.contextPath}/users/register/3'">
        <h2 style="font-size:30px;  margin-bottom:10px; padding-bottom:5px">Client</h2>
        <img src="${pageContext.request.contextPath}/images/client.jpg" alt="client" style="width:100%">
      </div>
    </div>
  </div>
</div>
<%--//Register --%>

<%--Footer--%>
<%@include file="../fragments/footer.jspf" %>

</body>
</html>