<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<head>
  <%@include file="../fragments/head.jspf" %>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login-register.css">
  <title>Login</title>
</head>

<body>

<%--Header--%>
<%@include file="../fragments/topbar.jspf" %>

<%
  List<String> path = new ArrayList<>(Collections.singletonList("Login"));
  pageContext.setAttribute("path", path);
%>

<%--Breadcrumbs--%>
<%@include file="../fragments/breadcrumbs.jspf" %>

<%--Register--%>
<div class="register">

  <div class="container">

    <h2>Login</h2>

    <div class="login-form-grids">

      <form:form method="post" modelAttribute="user">

        <div class="row">
          <div class="col-xs-12">
            <form:label path="email">Email</form:label>
            <form:errors cssClass="error" path="email"/>
            <div class="form-group">
              <form:input cssClass="form-control no-space" path="email" pattern="[^\s]+"/>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-xs-12">
            <form:label path="password">Password</form:label>
            <form:errors cssClass="error" path="password"/>
            <div class="form-group">
              <form:password id="password" cssClass="form-control no-space" path="password" pattern="[^\s]+"/>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-xs-12">
            <input type="submit" value="Login">
          </div>
        </div>

      </form:form>

    </div>

    <div class="register-home">
      <a href="${pageContext.request.contextPath}/">Home</a>
    </div>

  </div>
</div>
<%--//Register --%>

<%--Footer--%>
<%@include file="../fragments/footer.jspf" %>

<script src="${pageContext.request.contextPath}/js/no-space.js"></script>

</body>
</html>