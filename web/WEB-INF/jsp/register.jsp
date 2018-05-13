<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
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
  List<String> path = new ArrayList<>(Collections.singletonList("Register"));
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

        <div class="row">
          <div class="col-xs-12">
            <form:label path="role.roleId">Role</form:label>
            <form:errors cssClass="error" path="role.roleId"/>
            <div class="form-group">
              <form:select path="role.roleId">
                <form:option value="0" label="Select an Option"/>
                <form:options title="role" items="${all_roles}" itemValue="roleId" itemLabel="roleName"/>
              </form:select>
            </div>
          </div>
        </div>

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