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
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="Responsive Admin &amp; Dashboard Template based on Bootstrap 5">
  <meta name="author" content="AdminKit">
  <meta name="keywords"
        content="adminkit, bootstrap, bootstrap 5, admin, dashboard, template, responsive, css, sass, html, theme, front-end, ui kit, web">

  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link rel="shortcut icon" href="img/icons/icon-48x48.png"/>

  <link rel="canonical" href="https://demo-basic.adminkit.io/"/>

  <title>AdminKit Demo - Bootstrap 5 Admin Template</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="../css/mannage.css">

  <link rel="stylesheet" href="../css/createProduct.css">
  <script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
</head>

<body>
<div class="wrapper">
  <nav id="sidebar" class="sidebar js-sidebar">
    <div class="sidebar-content js-simplebar">
      <a class="sidebar-brand" href="index.html">
        <span class="align-middle">Quản lý cửa hàng</span>
      </a>

      <ul class="sidebar-nav">
        <li class="sidebar-header">
          Pages
        </li>
        <li class="sidebar-item active">
          <a class="sidebar-link" href="#">
            <i class="align-middle" data-feather="grid"></i> <span
                  class="align-middle">Quản lý đơn hàng</span>
          </a>
        </li>
        <li class="sidebar-item">
          <a class="sidebar-link" href="product.html">
            <i class="align-middle" data-feather="square"></i> <span
                  class="align-middle">Quản lý sản phẩm</span>
          </a>
        </li>
      </ul>
    </div>
  </nav>
  <div class="main">
    <nav class="navbar navbar-expand navbar-light navbar-bg">
      <a class="sidebar-toggle js-sidebar-toggle mx-2">
        <i class="hamburger align-self-center"></i>
      </a>

      <div class="navbar-collapse collapse">
        <ul class="navbar-nav navbar-align">
          <li class="nav-item dropdown">
            <a class="nav-icon dropdown-toggle" href="#" id="alertsDropdown" data-bs-toggle="dropdown">
              <div class="position-relative">
                <i class="align-middle" data-feather="bell"></i>
              </div>
            </a>
            <div class="dropdown-menu dropdown-menu-lg dropdown-menu-end py-0"
                 aria-labelledby="alertsDropdown">
              <div class="dropdown-menu-header">
                4 New Notifications
              </div>
              <div class="list-group">
                <a href="#" class="list-group-item">
                  <div class="row g-0 align-items-center">
                    <div class="col-2">
                      <i class="text-danger" data-feather="alert-circle"></i>
                    </div>
                    <div class="col-10">
                      <div class="text-dark">Update completed</div>
                      <div class="text-muted small mt-1">Restart server 12 to complete the
                        update.
                      </div>
                      <div class="text-muted small mt-1">30m ago</div>
                    </div>
                  </div>
                </a>
                <a href="#" class="list-group-item">
                  <div class="row g-0 align-items-center">
                    <div class="col-2">
                      <i class="text-warning" data-feather="bell"></i>
                    </div>
                    <div class="col-10">
                      <div class="text-dark">Lorem ipsum</div>
                      <div class="text-muted small mt-1">Aliquam ex eros, imperdiet vulputate
                        hendrerit et.
                      </div>
                      <div class="text-muted small mt-1">2h ago</div>
                    </div>
                  </div>
                </a>
                <a href="#" class="list-group-item">
                  <div class="row g-0 align-items-center">
                    <div class="col-2">
                      <i class="text-primary" data-feather="home"></i>
                    </div>
                    <div class="col-10">
                      <div class="text-dark">Login from 192.186.1.8</div>
                      <div class="text-muted small mt-1">5h ago</div>
                    </div>
                  </div>
                </a>
                <a href="#" class="list-group-item">
                  <div class="row g-0 align-items-center">
                    <div class="col-2">
                      <i class="text-success" data-feather="user-plus"></i>
                    </div>
                    <div class="col-10">
                      <div class="text-dark">New connection</div>
                      <div class="text-muted small mt-1">Christina accepted your request.</div>
                      <div class="text-muted small mt-1">14h ago</div>
                    </div>
                  </div>
                </a>
              </div>
              <div class="dropdown-menu-footer">
                <a href="#" class="text-muted">Show all notifications</a>
              </div>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-icon dropdown-toggle" href="#" id="messagesDropdown" data-bs-toggle="dropdown">
              <div class="position-relative">
                <i class="align-middle" data-feather="message-square"></i>
              </div>
            </a>
            <div class="dropdown-menu dropdown-menu-lg dropdown-menu-end py-0"
                 aria-labelledby="messagesDropdown">
              <div class="dropdown-menu-header">
                <div class="position-relative">
                  4 New Messages
                </div>
              </div>
              <div class="list-group">
                <a href="#" class="list-group-item">
                  <div class="row g-0 align-items-center">
                    <div class="col-2">
                      <img src="img/avatars/avatar-5.jpg" class="avatar img-fluid rounded-circle"
                           alt="Vanessa Tucker">
                    </div>
                    <div class="col-10 ps-2">
                      <div class="text-dark">Vanessa Tucker</div>
                      <div class="text-muted small mt-1">Nam pretium turpis et arcu. Duis arcu
                        tortor.
                      </div>
                      <div class="text-muted small mt-1">15m ago</div>
                    </div>
                  </div>
                </a>
                <a href="#" class="list-group-item">
                  <div class="row g-0 align-items-center">
                    <div class="col-2">
                      <img src="img/avatars/avatar-2.jpg" class="avatar img-fluid rounded-circle"
                           alt="William Harris">
                    </div>
                    <div class="col-10 ps-2">
                      <div class="text-dark">William Harris</div>
                      <div class="text-muted small mt-1">Curabitur ligula sapien euismod vitae.
                      </div>
                      <div class="text-muted small mt-1">2h ago</div>
                    </div>
                  </div>
                </a>
                <a href="#" class="list-group-item">
                  <div class="row g-0 align-items-center">
                    <div class="col-2">
                      <img src="img/avatars/avatar-4.jpg" class="avatar img-fluid rounded-circle"
                           alt="Christina Mason">
                    </div>
                    <div class="col-10 ps-2">
                      <div class="text-dark">Christina Mason</div>
                      <div class="text-muted small mt-1">Pellentesque auctor neque nec urna.</div>
                      <div class="text-muted small mt-1">4h ago</div>
                    </div>
                  </div>
                </a>
                <a href="#" class="list-group-item">
                  <div class="row g-0 align-items-center">
                    <div class="col-2">
                      <img src="img/avatars/avatar-3.jpg" class="avatar img-fluid rounded-circle"
                           alt="Sharon Lessman">
                    </div>
                    <div class="col-10 ps-2">
                      <div class="text-dark">Sharon Lessman</div>
                      <div class="text-muted small mt-1">Aenean tellus metus, bibendum sed,
                        posuere ac, mattis non.
                      </div>
                      <div class="text-muted small mt-1">5h ago</div>
                    </div>
                  </div>
                </a>
              </div>
              <div class="dropdown-menu-footer">
                <a href="#" class="text-muted">Show all messages</a>
              </div>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-icon dropdown-toggle d-inline-block d-sm-none" href="#" data-bs-toggle="dropdown">
              <i class="align-middle" data-feather="settings"></i>
            </a>

            <a class="nav-link dropdown-toggle d-none d-sm-inline-block" href="#" data-bs-toggle="dropdown">
              <img src="img/avatars/avatar.jpg" class="avatar img-fluid rounded me-1" alt="Charles Hall"/>
              <span class="text-dark">Chris Hung</span>
            </a>
            <div class="dropdown-menu dropdown-menu-end">
              <a class="dropdown-item" href="#"><i class="align-middle me-1"
                                                   data-feather="user"></i> Profile</a>
              <a class="dropdown-item" href="#"><i class="align-middle me-1" data-feather="pie-chart"></i>
                Analytics</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="index.html"><i class="align-middle me-1"
                                                            data-feather="settings"></i> Settings &
                Privacy</a>
              <a class="dropdown-item" href="#"><i class="align-middle me-1"
                                                   data-feather="help-circle"></i> Help Center</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="#">Log out</a>
            </div>
          </li>
        </ul>
      </div>
    </nav>

    <main class="content">
      <form action="<%=request.getContextPath()%>/ProductServlet" method="post" enctype="multipart/form-data">
        <div class="mainInput">
          <div class="basicInfomation">
            <h2>Thông tin cơ bản</h2>

            <div class="input-group mb-3">
              <span class="input-group-text" id="productImage">Thêm ảnh chính</span>
              <input type="file" class="form-control" name="image" placeholder="Username"
                     aria-label="Username"
                     aria-describedby="basic-addon1">
            </div>

            <div class="input-group mb-3">
              <span class="input-group-text" id="image" >Thêm ảnh phụ cho sản phẩm</span>
              <input type="file" class="form-control" name="subImage" multiple
                     aria-describedby="basic-addon1">
            </div>

            <div class="input-group mb-3">
              <span class="input-group-text" id="productName">Nhập tên sản phẩm</span>
              <input type="text" class="form-control" name="productName" value="${product.productName}" placeholder="Nhập vào tên sản phẩm !" aria-label="Username"
                     aria-describedby="basic-addon1">
            </div>

            <%--                        Gọi modal--%>
            <%--                        <div class="input-group mb-3">--%>


            <%--                                <span class="input-group-text" id="basic-addon1">--%>
            <%--                                    <button type="button" data-bs-toggle="modal" data-bs-target="#exampleModal">--%>
            <%--                            Chọn ngành hàng--%>
            <%--                                </button>--%>
            <%--                                </span>--%>
            <%--                                <input type="text" class="form-control" placeholder="Username" aria-label="Username"--%>
            <%--                                       aria-describedby="basic-addon1">--%>
            <%--                        </div>--%>
            <div class="input-group mb-3">
              <label class="input-group-text" for="inputGroupSelect01">Chọn ngành hàng</label>
              <select class="form-select" id="inputGroupSelect01">
                <option  selected>Choose...</option>
                <c:forEach items="${listCatalogRoot}" var="cat">
                  <option value="${cat.catalogId}" id="catalogChoose">${cat.catalogName}</option>
                </c:forEach>
              </select>
            </div>

            <%--                           ---------------- Goi catalog lan 2-------------------%>
            <div class="input-group mb-3" id="inputSelectCatalog">

            </div>

            <%--    ---------------- Goi catalog lan 3-------------------%>
            <div class="input-group mb-3" id="moreSelectCatalog" >

            </div>

            <div class="input-group">
              <span class="input-group-text">Mô tả sản phẩm</span>
              <textarea name="description" id="description" ></textarea>
            </div>
          </div>
          <div class="sellInformation">
            <div>
              <h2>Thông tin bán hàng</h2>
              <div>
                <div>
                  <h3>Phân loại hàng</h3>
                  <div>
                    <h4>Size</h4>
                    <div class="input-group-text" id="chooseSize">
                    </div>
                  </div>
                  <div>
                    <h4>Color</h4>
                    <div class="input-group-text" id="colorGroup">
                      <c:forEach items="${listColor}" var="color">
                        <input class="form-check-input mt-1" name="color" type="checkbox"
                               value="${color.colorId}"
                               aria-label="Checkbox for following text input">${color.colorName}
                      </c:forEach>

                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="confirm">
            <button type="button" class="btn btn-secondary">Hủy</button>
            <button type="submit" class="btn btn-primary" name="action" value="createProduct">Thêm sản phẩm</button>
          </div>
        </div>
      </form>
    </main>

    <footer class="footer">
      <div class="container-fluid">
        <div class="row text-muted">
          <div class="col-6 text-start">
            <p class="mb-0">
              <a class="text-muted" href="" target="_blank"><strong>DemoAdminKit</strong></a>
              - <a class="text-muted" href="" target="_blank"><strong>Bootstrap Admin
              Template</strong></a> &copy;
            </p>
          </div>
          <div class="col-6 text-end">
            <ul class="list-inline">
              <li class="list-inline-item">
                <a class="text-muted" href="#" target="_blank">Support</a>
              </li>
              <li class="list-inline-item">
                <a class="text-muted" href="#" target="_blank">Help Center</a>
              </li>
              <li class="list-inline-item">
                <a class="text-muted" href="#" target="_blank">Privacy</a>
              </li>
              <li class="list-inline-item">
                <a class="text-muted" href="#" target="_blank">Terms</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </footer>
  </div>
</div>

<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">

        <ul>
          <c:forEach items="${listCatalogRoot}" var="cat">
            <li id="chooseCatalog">
              <button type="button" value="${cat.catalogId}">${cat.catalogName}</button>
            </li>
          </c:forEach>
        </ul>
      </div>
      <div>
        <ul>

        </ul>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

<script src="../js/app.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
  document.addEventListener("DOMContentLoaded", function () {
    var ctx = document.getElementById("chartjs-dashboard-line").getContext("2d");
    var gradient = ctx.createLinearGradient(0, 0, 0, 225);
    gradient.addColorStop(0, "rgba(215, 227, 244, 1)");
    gradient.addColorStop(1, "rgba(215, 227, 244, 0)");
    // Line chart
    new Chart(document.getElementById("chartjs-dashboard-line"), {
      type: "line",
      data: {
        labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
        datasets: [{
          label: "Sales ($)",
          fill: true,
          backgroundColor: gradient,
          borderColor: window.theme.primary,
          data: [
            2115,
            1562,
            1584,
            1892,
            1587,
            1923,
            2566,
            2448,
            2805,
            3438,
            2917,
            3327
          ]
        }]
      },
      options: {
        maintainAspectRatio: false,
        legend: {
          display: false
        },
        tooltips: {
          intersect: false
        },
        hover: {
          intersect: true
        },
        plugins: {
          filler: {
            propagate: false
          }
        },
        scales: {
          xAxes: [{
            reverse: true,
            gridLines: {
              color: "rgba(0,0,0,0.0)"
            }
          }],
          yAxes: [{
            ticks: {
              stepSize: 1000
            },
            display: true,
            borderDash: [3, 3],
            gridLines: {
              color: "rgba(0,0,0,0.0)"
            }
          }]
        }
      }
    });
  });
</script>
<script>
  document.addEventListener("DOMContentLoaded", function () {
    // Pie chart
    new Chart(document.getElementById("chartjs-dashboard-pie"), {
      type: "pie",
      data: {
        labels: ["Chrome", "Firefox", "IE"],
        datasets: [{
          data: [4306, 3801, 1689],
          backgroundColor: [
            window.theme.primary,
            window.theme.warning,
            window.theme.danger
          ],
          borderWidth: 5
        }]
      },
      options: {
        responsive: !window.MSInputMethodContext,
        maintainAspectRatio: false,
        legend: {
          display: false
        },
        cutoutPercentage: 75
      }
    });
  });
</script>
<script>
  document.addEventListener("DOMContentLoaded", function () {
    // Bar chart
    new Chart(document.getElementById("chartjs-dashboard-bar"), {
      type: "bar",
      data: {
        labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
        datasets: [{
          label: "This year",
          backgroundColor: window.theme.primary,
          borderColor: window.theme.primary,
          hoverBackgroundColor: window.theme.primary,
          hoverBorderColor: window.theme.primary,
          data: [54, 67, 41, 55, 62, 45, 55, 73, 60, 76, 48, 79],
          barPercentage: .75,
          categoryPercentage: .5
        }]
      },
      options: {
        maintainAspectRatio: false,
        legend: {
          display: false
        },
        scales: {
          yAxes: [{
            gridLines: {
              display: false
            },
            stacked: false,
            ticks: {
              stepSize: 20
            }
          }],
          xAxes: [{
            stacked: false,
            gridLines: {
              color: "transparent"
            }
          }]
        }
      }
    });
  });
</script>
<script>
  document.addEventListener("DOMContentLoaded", function () {
    var markers = [{
      coords: [31.230391, 121.473701],
      name: "Shanghai"
    },
      {
        coords: [28.704060, 77.102493],
        name: "Delhi"
      },
      {
        coords: [6.524379, 3.379206],
        name: "Lagos"
      },
      {
        coords: [35.689487, 139.691711],
        name: "Tokyo"
      },
      {
        coords: [23.129110, 113.264381],
        name: "Guangzhou"
      },
      {
        coords: [40.7127837, -74.0059413],
        name: "New York"
      },
      {
        coords: [34.052235, -118.243683],
        name: "Los Angeles"
      },
      {
        coords: [41.878113, -87.629799],
        name: "Chicago"
      },
      {
        coords: [51.507351, -0.127758],
        name: "London"
      },
      {
        coords: [40.416775, -3.703790],
        name: "Madrid "
      }
    ];
    var map = new jsVectorMap({
      map: "world",
      selector: "#world_map",
      zoomButtons: true,
      markers: markers,
      markerStyle: {
        initial: {
          r: 9,
          strokeWidth: 7,
          stokeOpacity: .4,
          fill: window.theme.primary
        },
        hover: {
          fill: window.theme.primary,
          stroke: window.theme.primary
        }
      },
      zoomOnScroll: false
    });
    window.addEventListener("resize", () => {
      map.updateSize();
    });
  });
</script>
<script>
  document.addEventListener("DOMContentLoaded", function () {
    var date = new Date(Date.now() - 5 * 24 * 60 * 60 * 1000);
    var defaultDate = date.getUTCFullYear() + "-" + (date.getUTCMonth() + 1) + "-" + date.getUTCDate();
    document.getElementById("datetimepicker-dashboard").flatpickr({
      inline: true,
      prevArrow: "<span title=\"Previous month\">&laquo;</span>",
      nextArrow: "<span title=\"Next month\">&raquo;</span>",
      defaultDate: defaultDate
    });
  });
</script>
<script>
  // $(document).on('click', '.modal ', function () {
  //     let calId = $(this).val();
  //     alert(calId);
  //
  //
  // });

  $(document).on('change', '.mainInput #inputGroupSelect01', function () {
    let id = $(this).val();
    $.ajax({
      type: 'GET',
      <%--url: '${pageContext.request.contextPath}/CatalogServlet?action=GetSizeById&&catalogParentId=' + id,--%>
      url: '${pageContext.request.contextPath}/CatalogServlet?action=getChildCatalog&&catalogParentId=' + id,
      success: function (result) {
        var products = $.parseJSON(result);
        console.log("product ==============", products);
        let s = '   <label class="input-group-text" for="moreCatalog">Chọn ngành hàng</label>' +
                ' <br/>' + '  <select class="form-select" id="moreCatalog">'+'<br/>' +'<option selected>Choose...</option>'
        let a = '';
        for (var i = 0; i < products.length; i++) {
          // s += '<input type="checkbox" name="size" value=" ' + products[i].sizeId  + '">' + products[i].sizeName ;
          a += '<option value="' + products[i].catalogId + '" >' + products[i].catalogName + '</option>';
        }
        let x = ' </select>';
        let c = s + a + x;
        $('#inputSelectCatalog').html(c);
      }
    });
  });
  $(document).on('change', '.mainInput #moreCatalog', function () {
    let id = $(this).val();
    $.ajax({
      type: 'GET',
      <%--url: '${pageContext.request.contextPath}/CatalogServlet?action=GetSizeById&&catalogParentId=' + id,--%>
      url: '${pageContext.request.contextPath}/CatalogServlet?action=getChildCatalog&&catalogParentId=' + id,
      success: function (result) {
        var products = $.parseJSON(result);
        console.log("product ==============", products);
        let s = '   <label class="input-group-text" for="moreCatalog">Chọn ngành hàng chi tiết</label>' +
                ' <br/>' + '  <select class="form-select" id="lastChooseCatalog" name="catalog">' +'<br/>' +'<option selected>Choose...</option>'
        let a = '';
        for (var i = 0; i < products.length; i++) {
          // s += '<input type="checkbox" name="size" value=" ' + products[i].sizeId  + '">' + products[i].sizeName ;
          a += '<option value="' + products[i].catalogId + '" >' + products[i].catalogName + '</option>';
          console.log(products[i].catalogId)
        }
        let x = ' </select>';
        let c = s + a + x;
        $('#moreSelectCatalog').html(c);
      }
    });
  });
  $(document).on('change', '.mainInput #inputGroupSelect01', function () {
    let id = $(this).val();
    $.ajax({
      type: 'GET',
      url: '${pageContext.request.contextPath}/CatalogServlet?action=GetSizeById&&catalogParentId=' + id,
      success: function (result) {
        var products = $.parseJSON(result);
        let a = '';
        for (var i = 0; i < products.length; i++) {
          a += '<input type="checkbox" class="sizeValue" name="size" value="'+products[i].sizeId + '">' + products[i].sizeName;
        }
        $('#chooseSize').html(a);
      }
    });
  });


</script>
<script>
  CKEDITOR.replace("description")
</script>
</body>

</html>
