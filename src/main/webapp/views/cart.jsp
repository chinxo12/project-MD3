<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tintr
  Date: 11/21/2022
  Time: 10:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Amado - Furniture Ecommerce Template | Cart</title>

    <!-- Favicon  -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="../css/single_styles.css">
    <link rel="stylesheet" href="../css/cart.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>
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
                                    <li><a href="#"><i class="fa fa-user-plus" aria-hidden="true"></i>Register</a>
                                    </li>
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
                        <a href="#"><img class="logo" src="https://play-lh.googleusercontent.com/UuYYGTDU7fFQXlFAk4h5EF_OC01Fl
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
<!-- Search Wrapper Area Start -->


<!-- ##### Main Content Wrapper Start ##### -->
<div class="main-content-wrapper d-flex clearfix">

    <!-- Mobile Nav (max width 767px)-->
    <div class="mobile-nav">
        <!-- Navbar Brand -->
        <div class="amado-navbar-brand">
            <a href="index.html"><img src="img/core-img/logo.png" alt=""></a>
        </div>
        <!-- Navbar Toggler -->
        <div class="amado-navbar-toggler">
            <span></span><span></span><span></span>
        </div>
    </div>

    <div class="cart-table-area section-padding-100">
        <div class="container-fluid">
            <div class>
                <form action="<%=request.getContextPath()%>/OrderServlet?action=pays" method="post">
                    <div class="col-15 col-lg-7">
                        <div class="cart-title mt-50">
                            <h2>Giỏ hàng </h2>
                        </div>

                        <div class="cart-table">

                            <table class="table ">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th></th>
                                    <th>Tên sản phẩm</th>
                                    <th>Phân loại</th>
                                    <th>Giá</th>
                                    <th>Số lượng</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${listCart}" var="cart">
                                    <tr>
                                            <%--                                    <%=request.getContextPath()%>/ProductServlet?action=singerProduct&&proId=${cart.cartProduct.productId}--%>
                                        <td>
                                            <div>
                                                <input class="form-check-input" type="checkbox" checked>
                                                <input type="hidden" value="${cart.cartId}" name="cartId">
                                            </div>
                                        </td>
                                        <td class="cart_product_img">
                                            <a href="<%=request.getContextPath()%>/ProductServlet?action=singerProduct&&proId=${cart.cartProduct.productId}"><img
                                                    src="<%=request.getContextPath()%>/image/${cart.cartProduct.productImage}"
                                                    alt="${cart.cartProduct.productName}"
                                                    style="width: 100px;height: 100px"></a>

                                        </td>
                                        <td class="cart_product_desc">
                                            <a href="<%=request.getContextPath()%>/ProductServlet?action=singerProduct&&proId=${cart.cartProduct.productId}">
                                                <h5>${cart.cartProduct.productName}</h5></a>
                                        </td>
                                        <td>
                                            <span>${cart.cartProduct.productDetail.color.colorName},${cart.cartProduct.productDetail.size.sizeName}</span>
                                        </td>
                                        <td class="price">
                                            <span>${cart.cartProduct.productDetail.price}</span>
                                        </td>
                                        <td class="qty">
                                            <div class="qty-btn d-flex">
                                                <div class="quantity">
                                                <span class="qty-minus"
                                                      onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;"><i
                                                        class="fa fa-minus" aria-hidden="true"></i></span>
                                                    <input type="number" class="qty-text" id="qty" step="1" min="1"
                                                           max="300" name="quantity"
                                                           value="${cart.quantity}">
                                                    <span class="qty-plus"
                                                          onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i
                                                            class="fa fa-plus" aria-hidden="true"></i></span>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col-12 col-lg-4">
                        <div class="cart-summary">
                            <h5>Tổng tiền </h5>
                            <ul class="summary-table">
                                <li><span>Tiền số tiền</span> <span>$140.00</span></li>
                                <li><span>Giảm giá</span> <span>Free</span></li>
                                <li><span>Tổng số tiền thanh toán</span> <span>$140.00</span></li>
                            </ul>
                            <div class="cart-btn mt-100">
                                <button type="submit" class="btn btn-warning">Đặt hàng</button>
                            </div>
                        </div>
                    </div>
                </form>
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
                    <div class="cr">©2018 All Rights Reserverd. Made with <i class="fa fa-heart-o"
                                                                             aria-hidden="true"></i> by <a href="#">Colorlib</a>
                        &amp; distributed by <a href="https://themewagon.com">ThemeWagon</a></div>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- ##### Footer Area End ##### -->

<!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
<script src="js/jquery/jquery-2.2.4.min.js"></script>
<!-- Popper js -->
<script src="js/popper.min.js"></script>
<!-- Bootstrap js -->
<script src="js/bootstrap.min.js"></script>
<!-- Plugins js -->
<script src="js/plugins.js"></script>
<!-- Active js -->
<script src="js/active.js"></script>

</body>

</html>