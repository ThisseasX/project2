<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 11/3/2018
  Time: 7:13 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Index</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>

<div class="container">
  <div class="row">
    <div class="col-md-4 col-md-offset-4">

      <div class="panel my-panel">

        <div class="panel-heading">
          <div class="row">
            <div class="col-md-12">
              <h1 class="text-center my-header">Actions</h1>
            </div>
          </div>
        </div>

        <hr>

        <div class="panel-body">
          <div class="row">
            <div class="col-md-12">
              <a class="btn btn-primary my-btn" style="margin-top: 16px;" href="${pageContext.request.contextPath}/users/all">See
                all users</a>
              <a class="btn btn-primary my-btn" style="margin-top: 16px;"
                 href="${pageContext.request.contextPath}/users/insert_form">Insert user</a>
            </div>
          </div>
        </div>

      </div>

    </div>
  </div>
</div>

</body>
</html>
