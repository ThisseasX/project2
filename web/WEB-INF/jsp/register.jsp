<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<head>
  <%@include file="../fragments/head.jspf" %>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login-register.css">
  <title>Register</title>
</head>

<body>

<%--Header--%>
<%@include file="../fragments/topbar.jspf" %>

<%
  String type = ((int) pageContext.findAttribute("type")) == 2 ? "Vendor" : "Client";
  List<String> path = new ArrayList<>(Arrays.asList("Register", type));
  pageContext.setAttribute("path", path);
%>

<%--Breadcrumbs--%>
<%@include file="../fragments/breadcrumbs.jspf" %>

<%--Register--%>
<div class="register">

  <div class="container">

    <h2>Register</h2>

    <div class="login-form-grids">

      <form:form method="post" modelAttribute="user">

        <h6>Login information</h6>

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
            <label for="password-confirm">Confirm Password</label>
            <div class="form-group">
              <input id="password-confirm" class="form-control no-space" type="password" pattern="[^\s]+"/>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-xs-12">
            <form:label path="name">Name</form:label>
            <form:errors cssClass="error" path="name"/>
            <div class="form-group">
              <form:input cssClass="form-control no-space capitalize" path="name" pattern="[^\s]+"/>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-xs-12">
            <form:label path="surname">Surname</form:label>
            <form:errors cssClass="error" path="surname"/>
            <div class="form-group">
              <form:input cssClass="form-control no-space capitalize" path="surname" pattern="[^\s]+"/>
            </div>
          </div>
        </div>

        <c:if test="${type eq 2}">

          <h6>Contact information</h6>

          <div class="row">
            <div class="col-xs-12">
              <form:label path="contact.city">Name</form:label>
              <form:errors cssClass="error" path="contact.city"/>
              <div class="form-group">
                <form:input cssClass="form-control capitalize" path="contact.city" pattern="{1,30}"/>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col-xs-12">
              <form:label path="contact.region">Region</form:label>
              <form:errors cssClass="error" path="contact.region"/>
              <div class="form-group">
                <form:input cssClass="form-control capitalize" path="contact.region" pattern="{1,30}"/>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col-xs-12">
              <form:label path="contact.address">Address</form:label>
              <form:errors cssClass="error" path="contact.address"/>
              <div class="form-group">
                <form:input cssClass="form-control capitalize" path="contact.address" pattern="{1,30}"/>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col-xs-12">
              <form:label path="contact.ssn">SSN</form:label>
              <form:errors cssClass="error" path="contact.ssn"/>
              <div class="form-group">
                <form:input cssClass="form-control no-space capitalize" path="contact.ssn" pattern="[0-9]{1,30}"/>
              </div>
            </div>
          </div>

        </c:if>

        <div class="row">
          <div class="col-xs-12">
            <input type="submit" value="Register">
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

<script src="${pageContext.request.contextPath}/js/password-validation.js"></script>
<script src="${pageContext.request.contextPath}/js/no-space.js"></script>

</body>
</html>