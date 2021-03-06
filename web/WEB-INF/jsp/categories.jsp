<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 1/4/2018
  Time: 11:12 μμ
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<head>
  <%@include file="../fragments/head.jspf" %>
  <title>Categories</title>
</head>
<body>

<div class="container">

  <div class="jumbotron">
    <h1 class="text-center">Categories</h1>
  </div>

  <div class="row">
    <div class="col-md-6 col-md-offset-3">

      <table class="table table-bordered table-hover table-striped">
        <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${categories}" var="c">
          <tr class="clickable" onclick="redirectToProducts(${c.categoryId})">
            <td>${c.categoryId}</td>
            <td>${c.categoryName}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>

    </div>
  </div>
</div>

<%@include file="../fragments/footer_scripts.jspf" %>

<script>

    function redirectToProducts(id) {
        window.location.href = "${pageContext.request.contextPath}/products/" + id;
    }

</script>

</body>
</html>