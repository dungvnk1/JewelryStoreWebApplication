<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a href="home" class="logo-brand" style="width: 3%;">
            <img src="images/icon/logo.png" style="width: 80%; border-radius: 50%"/>
        </a>
        <a class="navbar-brand" href="home">Jewelry</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input value="${txtSearch}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                    <a class="btn btn-success btn-sm ml-3" href="loadCart?uID=${sessionScope.acc.userID}">
                    <i class="fa fa-shopping-cart"></i> Cart
                </a>
            </form>

            <ul class="navbar-nav m-auto">
                <c:if test="${sessionScope.acc.roleID == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="manageProduct">Manager Product</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="manageAccount">Manager Account</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.acc != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="loadProfile?uID=${sessionScope.acc.userID}">Hello ${sessionScope.acc.fullName}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.acc == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Login</a>
                    </li>
                </c:if>

            </ul>
        </div>
    </div>
</nav>
                    
                    
<!--<div class="container mt-5">
    <h2 class="text-center mb-4">Image Slideshow</h2>

    <div class="slideshow-container">
        <div class="mySlides fade">
            <img src="images/products/swarovski/swarovskiSwanEaring.png" alt="Image 1">
        </div>

        <div class="mySlides fade">
            <img src="images/products/pandora/pandoraEarring.png" alt="Image 2">
        </div>

        <div class="mySlides fade">
            <img src="images/products/saga/buterfly.png" alt="Image 3">
        </div>
    </div>
</div>                                    -->
                    
<section class="jumbotron text-center">
  <div class="container">
    <div class="video-container">
      <video autoplay loop muted playsinline>
        <source src="video/jewelry.mp4" type="video/mp4">
      </video>
    </div>
    <div class="content">
        <h1 class="jumbotron-heading">Jewelry Store</h1>
<!--      <h4 class="lead font-weight-bold mb-0">Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp các sản phầm trang sức nhập khẩu chính hãng từ các store trên thế giới!</h4>-->
        <h4 class="lead mb-0">Uy tín, thương hiệu và chất lượng!</h4>
    </div>
   </div>
</section>
                    
<!--end of menu-->