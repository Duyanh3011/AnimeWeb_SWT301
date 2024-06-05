<%--
    Document   : login
    Created on : Mar 7, 2024, 12:36:32 AM
    Author     : DuyAnhComputer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Anime Template">
    <meta name="keywords" content="Anime, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Anime | Login</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
    rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/plyr.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header Section Begin -->
    <header class="header">
        <jsp:include page="../header_footer/menu.jsp"></jsp:include>
    </header>
    <!-- Header End -->

    <!-- Normal Breadcrumb Begin -->
    <section class="normal-breadcrumb set-bg" data-setbg="img/normal-breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="normal__breadcrumb__text">
                        <h2>User Manage</h2>
                        <p>Welcome Admin to the Anime administration.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->

    <!-- Login Section Begin -->
    <section class="login spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">     
                    <div class="normal__breadcrumb__text">
                        <p>User Account: </p>
                    </div>        
                        <table class="table table-bordered table-striped table-primary table-info table-sm" border="1">
                            <tr class="table-">
                                <th>User ID</th>
                                <th>Password</th>
                                <th>Email</th>
                                <th>Full Name</th>
                                <th>Admin</th>
                                <th>Delete</th>
                            </tr>
                        <c:forEach items="${requestScope.users}" var="user">
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.password}</td>
                                <td>${user.email}</td>
                                <td>${user.fullname}</td>
                                <td>${user.admin}</td>
                                <td><a href="userdelete?id=${user.id}">Delete</a> </td>
                            </tr>
                        </c:forEach>
                    </table>
<!--                        <a href="#" class="forget_pass">Forgot Your Password?</a>-->
                </div>

            </div>
           
        </div>
    </section>
    <!-- Login Section End -->

    <!-- Footer Section Begin -->
    <footer class="footer">
        <jsp:include page="../header_footer/footer.jsp"></jsp:include>

      </footer>
      <!-- Footer Section End -->

      <!-- Search model Begin -->
      <jsp:include page="../header_footer/search.jsp"></jsp:include>

    <!-- Search model end -->

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/player.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>


</body>

</html>
