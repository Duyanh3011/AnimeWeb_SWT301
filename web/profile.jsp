<%--
    Document   : register
    Created on : Mar 7, 2024, 12:44:45 AM
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
    <title>Anime | Profile</title>

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
        <jsp:include page="header_footer/menu.jsp"></jsp:include>
    </header>
    <!-- Header End -->
        <c:set var="user" value="${sessionScope.account}"></c:set>
    <!-- Normal Breadcrumb Begin -->
    <section class="normal-breadcrumb set-bg" data-setbg="img/normal-breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="normal__breadcrumb__text">
                        <h2>User Profile</h2>
                        <p>Welcome to the official Anime blog.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->

    <!-- Signup Section Begin -->
    <section class="signup spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="login__form">
                        <h3>Password Change</h3>
                        <form id="form" action="password" method="post">
                            <input style="display: none" type="text" value="${user.id}" name="id" readonly="" >
                            <div class="input__item">
                                <input type="password" placeholder="Current Password" name="Opass" required=""> 
                                <span class="icon_lock-open_alt"></span>
                            </div>
                            <div class="input__item">
                                <input type="password" placeholder="New Password" name="Npass" required=""> 
                                <span class="icon_lock"></span>
                            </div>
                            <div class="input__item">
                                <input type="password" placeholder="Confirm Password" name="Cpass" required="">
                                <span class="icon_lock"></span>
                            </div>
                            <h2 id="fail1" style="color: red">${requestScope.err}</h2>
                            <h2 id="fail2" style="color: red">${requestScope.err1}</h2>
                            <h2 id="done" style="color: green">${requestScope.mes}</h2>

                        <button type="submit" class="site-btn">Change password</button>
                    </form>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="login__social__links">
                            <h3>User Information</h3>
                            
                        <form id="form" action="info" method="post">   
                             <div class="input__item">
                                <input type="text" value="${user.id}" name="id" readonly="" >
                                <span class="icon_profile"></span>
                            </div>
                            <div class="input__item">
                                <input type="text" placeholder="${user.admin?"ADMIN":"USER"}" name="role" readonly="">
                                <span class="icon_id-2"></span>
                            </div>
                            <div class="input__item">
                                <input type="text" placeholder="Email address" name="email" required="" value="${user.email}">
                                <span class="icon_mail"></span>
                            </div>
                            <div class="input__item">
                                <input type="text" placeholder="Your Name" name="fullname" required="" value="${user.fullname}">
                                <span class="icon_id"></span>
                            </div>
                            <h2 style="color: green">${requestScope.mes1}</h2>
                                                        
                            <button type="submit" class="site-btn">Update</button>
                        </form>
                            
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Signup Section End -->

    <!-- Footer Section Begin -->
    <footer class="footer">
        <jsp:include page="header_footer/footer.jsp"></jsp:include>
      </footer>
      <!-- Footer Section End -->
      <!-- Search model Begin -->
<jsp:include page="header_footer/search.jsp"></jsp:include>

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
    <script src="js/register.js"></script>

</body>

</html>
