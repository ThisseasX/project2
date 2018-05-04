<%--
  Created by IntelliJ IDEA.
  User: Konstantinos
  Date: 5/4/2018
  Time: 12:27 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    #navlist {
      position: relative;
    }

    #navlist li {
      margin: 0;
      padding: 0;
      list-style: none;
      position: absolute;
      top: 0;
    }

    #navlist li, #navlist a {
      height: 44px;
      display: block;
    }

    #home {
      filter: grayscale(100%);
      background: url("${pageContext.request.contextPath}/img/tangerines.jpg");
    }

    #prev {
      left: 63px;
      width: 43px;
      background: url("${pageContext.request.contextPath}/img/sample.jpg") -47px 0;
    }

    #next {
      left: 129px;
      width: 43px;
      background: url("${pageContext.request.contextPath}/img/sample.jpg") -91px 0;
    }

    #home:hover {
      filter: none;
      <%--background: url("${pageContext.request.contextPath}/img/tangerines.jpg");--%>
    }

    #prev a:hover {
      background: url("${pageContext.request.contextPath}/img/sample.jpg") -47px -45px;
    }

    #next a:hover {
      background: url("${pageContext.request.contextPath}/img/sample.jpg") -91px -45px;
    }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Project 2</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Page 1-1</a></li>
            <li><a href="#">Page 1-2</a></li>
            <li><a href="#">Page 1-3</a></li>
          </ul>
        </li>
        <li><a href="#">Page 2</a></li>
        <li><a href="#">Page 3</a></li>
      </ul>
      <form class="navbar-form navbar-right" action="#">
        <div class="input-group">
          <input type="text" class="form-control" placeholder="Search" name="search">
          <div class="input-group-btn">
            <button class="btn btn-default" type="submit">
              <i class="glyphicon glyphicon-search"></i>
            </button>
          </div>
        </div>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>


<div class="container">
  <div class="row">
    <div class="col-md-12"><h2>Carousel Example</h2>
      <div style="width: 800px; height: 600px; margin: auto">
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
          <!-- Indicators -->
          <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
          </ol>

          <!-- Wrapper for slides -->
          <div class="carousel-inner">

            <div class="item active">
              <img src="${pageContext.request.contextPath}/img/image1.jpg" alt="image1" style="width:100%;">
              <div class="carousel-caption">
                <h3>Image 1</h3>
                <p>Get our great products!</p>
              </div>
            </div>

            <div class="item">
              <img src="${pageContext.request.contextPath}/img/image2.jpg" alt="image2" style="width:100%;">
              <div class="carousel-caption">
                <h3>Image 2</h3>
                <p>Amazing prices!</p>
              </div>
            </div>

            <div class="item">
              <img src="${pageContext.request.contextPath}/img/image3.jpg" alt="image3" style="width:100%;">
              <div class="carousel-caption">
                <h3>Image 3</h3>
                <p>Eat healthy!</p>
              </div>
            </div>

          </div>

          <!-- Left and right controls -->
          <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
      </div>
    </div>
  </div>
</div>

<img id="home" src="${pageContext.request.contextPath}/img/tangerines.jpg"/>


</body>
</html>
