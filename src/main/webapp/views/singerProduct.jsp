<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tintr
  Date: 11/21/2022
  Time: 10:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Single Product</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="Colo Shop Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap4/bootstrap.min.css">
    <link href="../plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="../plugins/OwlCarousel2-2.2.1/owl.carousel.css">
    <link rel="stylesheet" type="text/css" href="../plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
    <link rel="stylesheet" type="text/css" href="../plugins/OwlCarousel2-2.2.1/animate.css">
    <link rel="stylesheet" href="../plugins/themify-icons/themify-icons.css">
    <link rel="stylesheet" type="text/css" href="../plugins/jquery-ui-1.12.1.custom/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="../css/single_styles.css">
    <link rel="stylesheet" type="text/css" href="../css/single_responsive.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
                            <a href="<%=request.getContextPath()%>/ProductServlet?action=main"><img class="logo" src="https://play-lh.googleusercontent.com/UuYYGTDU7fFQXlFAk4h5EF_OC01Fl
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

                                    <li><a href="#"><i class="fa fa-user" aria-hidden="true"></i></a></li>
                                    <li class="checkout">
                                        <a href="#">
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

    <div class="fs_menu_overlay"></div>


    <div class="container single_product_container">
        <div class="row">
            <div class="col">

                <!-- Breadcrumbs -->

                <div class="breadcrumbs d-flex flex-row align-items-center">
                    <ul>
                        <li><a href="index.html">Home</a></li>
                        <li><a href="categories.html"><i class="fa fa-angle-right" aria-hidden="true"></i>Men's</a></li>
                        <li class="active"><a href="#"><i class="fa fa-angle-right" aria-hidden="true"></i>Single
                            Product</a></li>
                    </ul>
                </div>

            </div>
        </div>

        <div class="row">
            <div class="col-lg-7">
                <div class="single_product_pics">
                    <div class="row">
                        <div class="col-lg-3 thumbnails_col order-lg-1 order-2">
                            <div class="single_product_thumbnails">
                                <ul>
                                    <li><img src="../image/${product.product.productImage}"
                                             alt="${product.product.productName}"
                                             data-image="../image/${product.product.productImage}"></li>
                                    <C:forEach items="${product.product.imageList}" var="subImage">
                                        <li class="active"><img src="../image/${subImage}"
                                                                alt="${product.product.productName}"
                                                                data-image="../image/${subImage}"></li>
                                    </C:forEach>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-9 image_col order-lg-2 order-1">
                            <div class="single_product_image">
                                <div class="single_product_image_background"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-5">
                <div class="product_details">
                    <form action="<%=request.getContextPath()%>/OrderServlet?productId=${product.product.productId}" method="post">
                        <div class="product_details_title">
                            <h2>${product.product.productName}</h2>
                        </div>
                        <div class="product_price">
                            <c:choose>
                                <c:when test="${product.minPrice == product.maxPrice}">
                                    <div id="displayPrice" class="product_price">${product.minPrice} <sup>đ</sup></div>
                                </c:when>
                                <c:otherwise>
                                    <div class="product_price" id="displayPrice">
                                            ${product.minPrice}<sup>đ</sup> ~ ${product.maxPrice} <sup>đ</sup></div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <ul class="star_rating">
                            <li><i class="fa fa-star" aria-hidden="true"></i></li>
                            <li><i class="fa fa-star" aria-hidden="true"></i></li>
                            <li><i class="fa fa-star" aria-hidden="true"></i></li>
                            <li><i class="fa fa-star" aria-hidden="true"></i></li>
                            <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                        </ul>
                        <div class="product_color">
                            <span>Chọn màu sắc:</span>
                            <ul class="chooseColor">
                                <C:forEach items="${listColor}" var="color">
                                    <li>
                                        <button type="button" id="colorId" value="${color.colorId}"
                                                class="btn btn-outline-secondary"
                                                style="margin-left: 20px;margin-right: 20px">${color.colorName}</button>
                                        <input type="hidden" value="${product.product.productId}" id="productId">
                                    </li>
                                </C:forEach>
                            </ul>
                        </div>
                        <div id="chooseSize"></div>
                        <div class="quantity d-flex flex-column flex-sm-row align-items-sm-center">

                            <div class="red_button add_to_cart_button"><button type="submit"  class="btn btn-danger" name="action" value="addToCart">Thêm vào giỏ hàng</button></div>
                            <div class="product_favorite d-flex flex-column align-items-center justify-content-center"></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>

    <div class="shop">
        <div class="shopName">
            <h3>${product.product.user.userName}</h3>
            <button type="button" class="btn btn-outline-secondary">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chat-left-dots" viewBox="0 0 16 16">
                    <path d="M14 1a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1H4.414A2 2 0 0 0 3 11.586l-2 2V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12.793a.5.5 0 0 0 .854.353l2.853-2.853A1 1 0 0 1 4.414 12H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                    <path d="M5 6a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
                </svg> Chat ngay
            </button>
            <button type="button" class="btn btn-outline-warning">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-shop" viewBox="0 0 16 16">
                    <path d="M2.97 1.35A1 1 0 0 1 3.73 1h8.54a1 1 0 0 1 .76.35l2.609 3.044A1.5 1.5 0 0 1 16 5.37v.255a2.375 2.375 0 0 1-4.25 1.458A2.371 2.371 0 0 1 9.875 8 2.37 2.37 0 0 1 8 7.083 2.37 2.37 0 0 1 6.125 8a2.37 2.37 0 0 1-1.875-.917A2.375 2.375 0 0 1 0 5.625V5.37a1.5 1.5 0 0 1 .361-.976l2.61-3.045zm1.78 4.275a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 1 0 2.75 0V5.37a.5.5 0 0 0-.12-.325L12.27 2H3.73L1.12 5.045A.5.5 0 0 0 1 5.37v.255a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0zM1.5 8.5A.5.5 0 0 1 2 9v6h1v-5a1 1 0 0 1 1-1h3a1 1 0 0 1 1 1v5h6V9a.5.5 0 0 1 1 0v6h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V9a.5.5 0 0 1 .5-.5zM4 15h3v-5H4v5zm5-5a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1v-3zm3 0h-2v3h2v-3z"/>
                </svg> Xem shop
            </button>
        </div>
        <div class="shopInfomation">
            <div>
                <div>Đánh giá: 100</div>
                <div>Sản phẩm: 100</div>
            </div>
            <div>
                <div>Tỷ lệ phản hồi: 99%</div>
                <div>Thời gian phản hồi: trong vài giờ</div>
            </div>
            <div>
                <div>Tham gia: 22/22/2222 </div>
                <div>Người theo dõi: 1000 </div>
            </div>
        </div>

    </div>
    <!-- Tabs -->

    <div class="tabs_section_container">

        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="tabs_container">
                        <ul class="tabs d-flex flex-sm-row flex-column align-items-left align-items-md-center justify-content-center">
                            <li class="tab active" data-active-tab="tab_1"><span>Description</span></li>
                            <li class="tab" data-active-tab="tab_3"><span>Reviews (2)</span></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">

                    <!-- Tab Description -->

                    <div id="tab_1" class="tab_container active">
                        <div class="row">
                            <div class="col-lg-5 desc_col">
                                <div class="tab_title">
                                    <h4>Mô tả sản phẩm></h4>
                                </div>
                                <div class="tab_text_block">
                                    <p>${product.product.discription}</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Tab Additional Info -->


                    <!-- Tab Reviews -->

                    <div id="tab_3" class="tab_container">
                        <div class="row">

                            <!-- User Reviews -->

                            <div class="col-lg-6 reviews_col">
                                <div class="tab_title reviews_title">
                                    <h4>Reviews (2)</h4>
                                </div>

                                <!-- User Review -->

                                <div class="user_review_container d-flex flex-column flex-sm-row">
                                    <div class="user">
                                        <div class="user_pic"></div>
                                        <div class="user_rating">
                                            <ul class="star_rating">
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="review">
                                        <div class="review_date">27 Aug 2016</div>
                                        <div class="user_name">Brandon William</div>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                            tempor incididunt ut labore et dolore magna aliqua.</p>
                                    </div>
                                </div>

                                <!-- User Review -->

                                <div class="user_review_container d-flex flex-column flex-sm-row">
                                    <div class="user">
                                        <div class="user_pic"></div>
                                        <div class="user_rating">
                                            <ul class="star_rating">
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star-o" aria-hidden="true"></i></li>

                                            </ul>
                                        </div>
                                    </div>
                                    <div class="review">
                                        <div class="review_date">27 Aug 2016</div>
                                        <div class="user_name">Brandon William</div>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                            tempor incididunt ut labore et dolore magna aliqua.</p>
                                    </div>
                                </div>
                            </div>

                            <!-- Add Review -->

                            <div class="col-lg-6 add_review_col">

                                <div class="add_review">
                                    <form id="review_form" action="post">
                                        <div>
                                            <h1>Add Review</h1>
                                            <input id="review_name" class="form_input input_name" type="text"
                                                   name="name" placeholder="Name*" required="required"
                                                   data-error="Name is required.">
                                            <input id="review_email" class="form_input input_email" type="email"
                                                   name="email" placeholder="Email*" required="required"
                                                   data-error="Valid email is required.">
                                        </div>
                                        <div>
                                            <h1>Your Rating:</h1>
                                            <ul class="user_star_rating">
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                                            </ul>
                                            <textarea id="review_message" class="input_review" name="message"
                                                      placeholder="Your Review" rows="4" required
                                                      data-error="Please, leave us a review."></textarea>
                                        </div>
                                        <div class="text-left text-sm-right">
                                            <button id="review_submit" type="submit"
                                                    class="red_button review_submit_btn trans_300" value="Submit">submit
                                            </button>
                                        </div>
                                    </form>
                                </div>

                            </div>

                        </div>
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
                        <div class="cr">©2018 All Rights Reserverd. This template is made with <i class="fa fa-heart-o"
                                                                                                  aria-hidden="true"></i>
                            by <a href="#">Colorlib</a> &amp; distributed by <a
                                    href="https://themewagon.com">ThemeWagon</a></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(document).on('click', '.product_details .chooseColor #colorId', function () {
        let colorId = $(this).val();
        let proId = $(this).parent().find('#productId').val();
        $.ajax({
            type: 'get',
            url: '${pageContext.request.contextPath}/AjaxServlet?action=getSize&&colorId=' + colorId + '&&productId=' + proId,
            success: function (result) {
                let a = " <h4>Chọn size:</h4>";
                ;        let c = a + result;
                console.log(c)
                $('#chooseSize').html(c);
            }
        })
    });
    $(document).on('click', '#chooseSize #productDetail', function () {
        let id = $(this).val();
        $.ajax({
            type: 'get',
            url: '${pageContext.request.contextPath}/AjaxServlet?action=getPrice&&productDetailId=' + id,
            success: function (data) {
                console.log(data);
                var change = document.getElementById("displayPrice");

                change.innerHTML = data;
            }
        })
    });
</script>
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../css/bootstrap4/popper.js"></script>
<script src="../css/bootstrap4/bootstrap.min.js"></script>
<script src="../plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="../plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="../plugins/easing/easing.js"></script>
<script src="../plugins/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
<script src="../js/single_custom.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>

</html>
