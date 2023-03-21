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
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/login.css">

</head>
<body>
<section class="h-100 bg-dark">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col">
                <div class="card card-registration my-4">
                    <div class="row g-0">
                        <div class="col-xl-6 d-none d-xl-block">
                            <img src="https://scontent.fhan3-4.fna.fbcdn.net/v/t1.6435-9/68441406_2466330580119609_7677504433898389504_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=0debeb&_nc_ohc=VnA8PzxXxkQAX9THWyN&_nc_ht=scontent.fhan3-4.fna&oh=00_AfCpHqz9ROf_ITb8Qz77xwd2bxfsonhuhD3TxY6BT-TBZA&oe=63A252DA"
                                 alt="Sample photo" class="img-fluid"
                                 style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;"/>
                            <img src="images/register.jpg"
                                 alt="Sample photo" class="img-fluid"
                                 style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;"/>
                        </div>
                        <div class="col-xl-6">
                            <form action="<%=request.getContextPath()%>/UserServlet" method="post">
                                <div class="card-body p-md-5 text-black">
                                    <h3 class="mb-5 text-uppercase">Đăng ký tài khoản</h3>


                                    <div class="form-outline">
                                        <label class="form-label" for="userName">Tên đăng nhập
                                        </label>
                                        <input type="text" id="userName" name="userName"
                                               class="form-control form-control-lg"/>

                                    </div>


                                    <div class="form-outline">
                                        <label class="form-label" for="passwood">Mật khẩu
                                        </label>
                                        <input type="password" id="passwood" name="passwood"
                                               class="form-control form-control-lg"/>

                                    </div>


                                    <div class="form-outline">
                                        <label class="form-label" for="repeaterPasswood"> Nhập lại mật khẩu</label>
                                        <input type="password" id="repeaterPasswood"
                                               class="form-control form-control-lg"/>

                                    </div>


                                    <div class="form-outline">
                                        <label class="form-label" for="firstName">Họ và tên</label>
                                        <input type="text" id="firstName" name="fullName"
                                               class="form-control form-control-lg"/>


                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="address">Địa chỉ</label>
                                        <input type="text" name="address" id="address" class="form-control form-control-lg"/>

                                    </div>


                                    <div class="d-md-flex justify-content-start align-items-center mb-4 py-2">

                                        <h6 class="mb-0 me-4">Giới tính: </h6>

                                        <div class="form-check form-check-inline mb-0 me-4">
                                            <input class="form-check-input" type="radio" name="sex"
                                                   id="female"
                                                   value="2"/>
                                            <label class="form-check-label" for="female">Nữ</label>
                                        </div>

                                        <div class="form-check form-check-inline mb-0 me-4">
                                            <input class="form-check-input" type="radio" name="sex"
                                                   id="males"
                                                   value="1"/>
                                            <label class="form-check-label" for="males">Nam</label>
                                        </div>

                                        <div class="form-check form-check-inline mb-0">
                                            <input class="form-check-input" type="radio" name="sex"
                                                   id="otherGender"
                                                   value="0"/>
                                            <label class="form-check-label" for="otherGender">Khác</label>
                                        </div>

                                    </div>

                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="address">Số điện thoại</label>
                                        <input type="number" name="phoneNumber" id="phone" class="form-control form-control-lg"/>

                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example97">Email</label>
                                        <input type="text" id="form3Example97" name="email"

                                               class="form-control form-control-lg"/>

                                    </div>

                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example97">Ngày sinh</label>
                                        <input type="date" id="dateOfBirth" name="birthOfDate"
                                               class="form-control form-control-lg"/>

                                    </div>
                                    <div class="d-flex justify-content-end pt-3">
                                        <a href="../views/login.jsp">
                                            <button type="button" class="btn btn-dark btn-lg ms-2">Đóng
                                            </button>
                                        </a>

                                        <button value="register" name="action" type="submit"
                                                class="btn btn-warning btn-lg ms-2">Đăng ký
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
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
