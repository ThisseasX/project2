<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 2/4/2018
  Time: 1:21 πμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
  <%@include file="../reusables/head.jspf" %>
  <title>Insert</title>
</head>
<body>

<div class="container">

  <div class="row">
    <div class="col-xs-12 col-md-4 col-md-offset-4">

      <div class="panel my-panel">

        <div class="panel-heading">

          <div class="row">
            <div class="col-xs-12">
              <h1 class="text-center text-primary my-header">Insert User</h1>
            </div>
          </div>

        </div>

        <hr>

        <div class="panel-body">

          <form:form method="post" modelAttribute="user">

            <div class="row">
              <div class="col-xs-12">
                <form:label path="username">Username</form:label>
                <form:errors cssClass="error" path="username"/>
                <div class="form-group">
                  <form:input cssClass="form-control" path="username" required="required"/>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-xs-12">
                <form:label path="password">Password</form:label>
                <form:errors cssClass="error" path="password"/>
                <div class="form-group">
                  <form:input cssClass="form-control" path="password"/>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-xs-12">
                <form:label path="name">Name</form:label>
                <form:errors cssClass="error" path="name"/>
                <div class="form-group">
                  <form:input cssClass="form-control" path="name"/>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-xs-12">
                <form:label path="surname">Surname</form:label>
                <form:errors cssClass="error" path="surname"/>
                <div class="form-group">
                  <form:input cssClass="form-control" path="surname"/>
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
                    <form:options title="asd" items="${all_roles}" itemValue="roleId" itemLabel="roleName"/>
                  </form:select>
                </div>
              </div>
            </div>

            <div class="row">
              <div class="col-xs-12">
                <input class="btn btn-primary my-btn" type="submit" value="Insert">
              </div>
            </div>

          </form:form>

        </div>
      </div>
    </div>
  </div>
</div>

<%@include file="../reusables/footer.jspf" %>

</body>
</html>