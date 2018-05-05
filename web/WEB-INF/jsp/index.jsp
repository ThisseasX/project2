<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 11/3/2018
  Time: 7:13 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <%@include file="../reusables/head.jspf" %>
  <title>Index</title>
</head>
<body>

<c:catch>
  <jsp:useBean id="user" scope="session"/>
</c:catch>

<div class="wrapper">
  <!-- Sidebar Holder -->
  <c:if test="${user.role.id != null}">
    <nav id="sidebar">
      <div class="sidebar-header">
        <h3>My Account</h3>
      </div>

      <ul class="list-unstyled components">
        <p>Dummy Heading</p>
        <li class="active">
          <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false">Home</a>
          <ul class="collapse list-unstyled" id="homeSubmenu">
            <li><a href="${pageContext.request.contextPath}/users/all">Home 1</a></li>
            <li><a href="${pageContext.request.contextPath}/users/insert">Home 2</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/admin_panel">Home 3</a></li>
          </ul>
        </li>
        <li>
          <a href="#">About</a>
          <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false">Pages</a>
          <ul class="collapse list-unstyled" id="pageSubmenu">
            <li><a href="#">Page 1</a></li>
            <li><a href="#">Page 2</a></li>
            <li><a href="#">Page 3</a></li>
          </ul>
        </li>
        <li>
          <a href="#">Portfolio</a>
        </li>
        <li>
          <a href="#">Contact</a>
        </li>
      </ul>

      <ul class="list-unstyled CTAs">
        <li><a href="https://bootstrapious.com/tutorial/files/sidebar.zip" class="download">Download source</a></li>
        <li><a href="https://bootstrapious.com/p/bootstrap-sidebar" class="article">Back to article</a></li>
      </ul>
    </nav>
  </c:if>

  <!-- Page Content Holder -->
  <div id="content">

    <nav class="navbar navbar-default">
      <div class="container-fluid">

        <div class="navbar-header">
          <button type="button" id="sidebarCollapse" class="navbar-btn">
            <span></span>
            <span></span>
            <span></span>
          </button>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <img src="${pageContext.request.contextPath}/img/logo.png"/>
          <ul class="nav navbar-nav navbar-right navbar-btn">
            <%--<li><a href="#" style="background-image: url('${pageContext.request.contextPath}/img/logo.png')"></a></li>--%>
            <li><a href="#">ABOUT US</a></li>
            <li><a href="#">FAQ</a></li>
            <li><a href="#">CONTACT</a></li>
            <li><a href="#">LOG IN</a></li>
            <li><a href="#">SIGN UP</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <h2>Collapsible Sidebar Using Bootstrap 3</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore
      magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
      Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore
      magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
      Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

    <div class="line"></div>

    <h2>Lorem Ipsum Dolor</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore
      magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
      Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

    <div class="line"></div>

    <h2>Lorem Ipsum Dolor</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore
      magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
      Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

    <div class="line"></div>

    <h3>Lorem Ipsum Dolor</h3>
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore
      magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
      consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
      Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
  </div>
</div>

<%--<div class="container">
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
              <a class="btn btn-primary my-btn" style="margin-top: 16px;"
                 href="${pageContext.request.contextPath}/users/all">See
                all users</a>
              <a class="btn btn-primary my-btn" style="margin-top: 16px;"
                 href="${pageContext.request.contextPath}/users/insert">Insert user</a>
              <a class="btn btn-primary my-btn" style="margin-top: 16px;"
                 href="${pageContext.request.contextPath}/admin/admin_panel">Admin</a>
            </div>
          </div>
        </div>

      </div>

    </div>
  </div>
</div>--%>

<%@include file="../reusables/footer.jspf" %>

</body>
</html>
