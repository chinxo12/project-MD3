<%--
  Created by IntelliJ IDEA.
  User: tintr
  Date: 11/23/2022
  Time: 8:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Rikkei E-commerce trading floor HOME </title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="Colo Shop Template">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="../css/bootstrap4/bootstrap.min.css">
  <link href="../plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" type="text/css" href="../plugins/OwlCarousel2-2.2.1/owl.carousel.css">
  <link rel="stylesheet" type="text/css" href="../plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
  <link rel="stylesheet" type="text/css" href="../plugins/OwlCarousel2-2.2.1/animate.css">
  <link rel="stylesheet" type="text/css" href="../css/main_styles.css">
  <link rel="stylesheet" type="text/css" href="../css/responsive.css">
</head>

<body>

<div class="super_container">

  <!-- Header -->

  <header class="header trans_300">

    <!-- Top Navigation -->

    <div class="top_nav">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <div class="top_nav_left"><a href="../views/shopManagerment.jsp">Kênh người bán</a></div>
          </div>
          <div class="col-md-6 text-right">
            <div class="top_nav_right">
              <ul class="top_nav_menu">

                <!-- Currency / Language / My Account -->
                <li class="account">
                  <a href="#">
                    My Account
                    <i class="fa fa-angle-down"></i>
                  </a>
                  <ul class="account_selection">
                    <li><a href="#"><i class="fa fa-sign-in" aria-hidden="true"></i>Sign In</a></li>
                    <li><a href="#"><i class="fa fa-user-plus" aria-hidden="true"></i>Register</a></li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Main Navigation -->
    <div class="main_nav_container">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-right">
            <div class="logo_container">
              <a href="../views/index.jsp"><img class="logo" src="https://play-lh.googleusercontent.com/UuYYGTDU7fFQXlFAk4h5EF_OC01Fl
								h-Vj0YSsB2_8xFXWapxvuE3jZA9wcFtfEFEB6VG=w600-h300-pc0xffffff-pd" alt="">
                <span>Rikkei</span> </a>
            </div>
            <nav class="navbar">
              <div class="container-fluid">
                <form class="d-flex">
                  <input id="searchMain" class="form-control me-2" type="search" placeholder="Search"
                         aria-label="Search">
                  <button class="btn btn-danger" type="submit">Search</button>
                </form>
                <ul class="navbar_user">
                  <li class="checkout">
                    <a href="<%=request.getContextPath()%>/OrderServlet?action=getAllCart">
                      <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                      <span id="checkout_items" class="checkout_items">2</span>
                    </a>
                  </li>
                </ul>
                <div class="hamburger_container">
                  <i class="fa fa-bars" aria-hidden="true"></i>
                </div>
              </div>
            </nav>
          </div>
        </div>
      </div>
    </div>

  </header>

  </header>

  <div class="fs_menu_overlay"></div>
  <div class="hamburger_menu">
    <div class="hamburger_close"><i class="fa fa-times" aria-hidden="true"></i></div>
    <div class="hamburger_menu_content text-right">
      <ul class="menu_top_nav">
        <li class="menu_item has-children">
          <a href="#">
            usd
            <i class="fa fa-angle-down"></i>
          </a>
          <ul class="menu_selection">
            <li><a href="#">cad</a></li>
            <li><a href="#">aud</a></li>
            <li><a href="#">eur</a></li>
            <li><a href="#">gbp</a></li>
          </ul>
        </li>
        <li class="menu_item has-children">
          <a href="#">
            English
            <i class="fa fa-angle-down"></i>
          </a>
          <ul class="menu_selection">
            <li><a href="#">French</a></li>
            <li><a href="#">Italian</a></li>
            <li><a href="#">German</a></li>
            <li><a href="#">Spanish</a></li>
          </ul>
        </li>
        <li class="menu_item has-children">
          <a href="#">
            My Account
            <i class="fa fa-angle-down"></i>
          </a>
          <ul class="menu_selection">
            <li><a href="#"><i class="fa fa-sign-in" aria-hidden="true"></i>Sign In</a></li>
            <li><a href="#"><i class="fa fa-user-plus" aria-hidden="true"></i>Register</a></li>
          </ul>
        </li>
        <li class="menu_item"><a href="#">home</a></li>
        <li class="menu_item"><a href="#">shop</a></li>
        <li class="menu_item"><a href="#">promotion</a></li>
        <li class="menu_item"><a href="#">pages</a></li>
        <li class="menu_item"><a href="#">blog</a></li>
        <li class="menu_item"><a href="#">contact</a></li>
      </ul>
    </div>
  </div>

  <!-- Slider -->

  <div class="main_slider" style="background-image:url(../hinhanh/nezuko.jpg)">
    <div class="container fill_height">
      <div class="row align-items-center fill_height">

      </div>
    </div>
  </div>

  <!-- Banner -->

  <div class="banner">
    <div class="container">
      <div class="row" id="catalogChoose">
        <ul>

          <li><a href="<%=request.getContextPath()%>/ProductServlet?action=getByCatalog&&catalogId=1"><img class="catalogPick" src="../hinhanh/thoi_trang_nu.jpg"
                                                                                                           alt=""> </a>
          </li>
          <li><a href="<%=request.getContextPath()%>/ProductServlet?action=getByCatalog&&catalogId=2"><img class="catalogPick" src="../hinhanh/thoitrangnam.jpg"
                                                                                                           alt=""> </a>
          </li>
          <li><a href="<%=request.getContextPath()%>/ProductServlet?action=getByCatalog&&catalogId=11"><img class="catalogPick"
                                                                                                            src="../hinhanh/bachhoa_online%20-%20Copy.jpg" alt=""> </a>
          </li>
          <li><a href="<%=request.getContextPath()%>/ProductServlet?action=getByCatalog&&catalogId=6"><img class="catalogPick" src="../hinhanh/dienthoai_phukien.jpg"
                                                                                                           alt="">
          </a></li>
          <li><a href="<%=request.getContextPath()%>/ProductServlet?action=getByCatalog&&catalogId=8"><img class="catalogPick" src="../hinhanh/giaydep_nu.jpg" alt="">
          </a></li>
          <
          <li><a href="<%=request.getContextPath()%>/ProductServlet?action=getByCatalog&&catalogId=9"><img class="catalogPick" src="../hinhanh/tui_vi_nu.jpg" alt="">
          </a></li>
          <li><a href="<%=request.getContextPath()%>/ProductServlet?action=getByCatalog&&catalogId=5"><img class="catalogPick" src="../hinhanh/thietbi_giadung.jpg"
                                                                                                           alt=""> </a>
          </li>


        </ul>

        <ul>
          <li><a href="<%=request.getContextPath()%>/ProductServlet?action=getByCatalog&&catalogId=10"><img class="catalogPick" src="../hinhanh/thiet_bi_dien_tu.jpg"
                                                                                                            alt="">
          </a></li>
          <li><a href="<%=request.getContextPath()%>/ProductServlet?action=getByCatalog&&catalogId=4"><img class="catalogPick" src="../hinhanh/suc_khoe.jpg" alt="">
          </a></li>
          <li><a href="<%=request.getContextPath()%>/ProductServlet?action=getByCatalog&&catalogId=14"><img class="catalogPick" src="../hinhanh/nha_sach_online.jpg"
                                                                                                            alt=""> </a>
          </li>
          <li><a href="<%=request.getContextPath()%>/ProductServlet?action=getByCatalog&&catalogId=13"><img class="catalogPick" src="../hinhanh/maytinh_laptop.jpg"
                                                                                                            alt=""> </a>
          </li>

          <li><a href="<%=request.getContextPath()%>/ProductServlet?action=getByCatalog&&catalogId=7"><img class="catalogPick" src="../hinhanh/giaydepnam.jpg" alt="">
          </a></li>

          </li>
          <li><a href="<%=request.getContextPath()%>/ProductServlet?action=getByCatalog&&catalogId=3"><img class="catalogPick" src="../hinhanh/sacdep.jpg" alt="">
          </a></li>
          <li><a href="<%=request.getContextPath()%>/ProductServlet?action=getByCatalog&&catalogId=12"><img class="catalogPick" src="../hinhanh/dongho.jpg" alt=""> </a>
          </li>
        </ul>
      </div>
    </div>
  </div>

  <!-- New Arrivals -->
  <div class="new_arrivals">
    <div class="container">
      <div class="row">
        <div class="col text-center">
          <div class="section_title new_arrivals_title">
            <h2>Sản Phẩm Mới</h2>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col">
          <div class="product-grid"
               data-isotope='{ "itemSelector": ".product-item", "layoutMode": "fitRows" }'>

            <!-- Product 1 -->
            <c:forEach items="${listNewProduct}" var="pro">
              <div class="product-item">
                <div class="product discount product_filter"  >
                  <div class="product_image">
                    <img src="../image/${pro.product.productImage}"
                         alt="${pro.product.productName}" style="height: 280px">
                  </div>
                  <div class="favorite favorite_left"></div>
                  <div class="product_info">
                    <h6 class="product_name"><a
                            href="<%=request.getContextPath()%>/ProductServlet?action=singerProduct&&proId=${pro.product.productId}">${pro.product.productName}</a>
                    </h6>
                    <c:choose>
                      <c:when test="${pro.minPrice == pro.maxPrice}">
                        <div class="product_price">${pro.minPrice}</div>
                      </c:when>
                      <c:otherwise>
                        <div class="product_price">
                            ${pro.minPrice} ~ ${pro.maxPrice}</div>
                      </c:otherwise>
                    </c:choose>
                  </div>
                </div>
                <div  class="red_button add_to_cart_button"><a href="#">add to cart</a></div>
              </div>
            </c:forEach>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="new_arrivals">
    <div class="container">
      <div class="row">
        <div class="col text-center">
          <div class="section_title new_arrivals_title">
            <h2>SẢN PHẨM NỔI BẬT</h2>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col">
          <div class="product-grid"
               data-isotope='{ "itemSelector": ".product-item", "layoutMode": "fitRows" }'>
            <c:forEach items="${listProduct}" var="pro">
              <div class="product-item">
                <div class="product discount product_filter"  >
                  <div class="product_image">
                    <img src="../image/${pro.product.productImage}"
                         alt="${pro.product.productName}" style="height: 280px">
                  </div>
                  <div class="favorite favorite_left"></div>
                  <div class="product_info">
                    <h6 class="product_name"><a
                            href="<%=request.getContextPath()%>/ProductServlet?action=singerProduct&&proId=${pro.product.productId}">${pro.product.productName}</a>
                    </h6>
                    <c:choose>
                      <c:when test="${pro.minPrice == pro.maxPrice}">
                        <div class="product_price">${pro.minPrice}</div>
                      </c:when>
                      <c:otherwise>
                        <div class="product_price">
                            ${pro.minPrice} ~ ${pro.maxPrice}</div>
                      </c:otherwise>
                    </c:choose>
                  </div>
                </div>
                <div  class="red_button add_to_cart_button"><a href="#">add to cart</a></div>
              </div>
            </c:forEach>
          </div>
        </div>
      </div>
    </div>
  </div>




  <footer class="footer">
    <div class="container">
      <div class="row">
        <div class="col-lg-6">
          <div class="footer_nav_container d-flex flex-sm-row flex-column align-items-center justify-content-lg-start justify-content-center text-center">
            <ul class="footer_nav">
              <li><a href="#">Blog</a></li>
              <li><a href="#">FAQs</a></li>
              <li><a href="contact.html">Contact us</a></li>
            </ul>
          </div>
        </div>
        <div class="col-lg-6">
          <div class="footer_social d-flex flex-row align-items-center justify-content-lg-end justify-content-center">
            <ul>
              <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
              <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
              <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
              <li><a href="#"><i class="fa fa-skype" aria-hidden="true"></i></a></li>
              <li><a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a></li>
            </ul>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <div class="footer_nav_container">
            <div class="cr">©2018 All Rights Reserverd. Made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="#">Colorlib</a> &amp; distributed by <a href="https://themewagon.com">ThemeWagon</a></div>
          </div>
        </div>
      </div>
    </div>
  </footer>

</div>

<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../css/bootstrap4/popper.js"></script>
<script src="../css/bootstrap4/bootstrap.min.js"></script>
<script src="../plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="../plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="../plugins/easing/easing.js"></script>
<script src="../js/custom.js"></script>
</body>

</html>

