<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 1/4/2018
  Time: 11:12 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <%@include file="../fragments/head.jspf" %>
  <title>Users</title>
</head>
<body>

<div class="container">

  <div class="jumbotron">
    <h1 class="text-center">Users</h1>
  </div>

  <div class="row">
    <div class="col-md-6 col-md-offset-3">

      <table class="table table-bordered table-hover table-striped">
        <thead>
        <tr>
          <th>Name</th>
          <th>Surname</th>
          <th>Role</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="u">
          <tr>
            <td>${u.name}</td>
            <td>${u.surname}</td>
            <td>${u.role.roleName}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>

    </div>
  </div>
</div>

<%@include file="../fragments/footer_scripts.jspf" %>

</body>
</html>