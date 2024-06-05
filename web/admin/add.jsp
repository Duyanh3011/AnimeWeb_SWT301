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
    <title>Anime | Admin</title>

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
                        <h2>Manage Anime</h2>
                        <p>Welcome Admin to the Anime Web Administration.</p>
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
                <div class="col-lg-12">
                    <div class="login__form">
                        <h3>Add Up</h3>
                        <form id="form" action="add" method="post">
                            <div class="input__item " style="width: 100%">
                                <input type="text" placeholder="Anime ID" name="id" required="">
                                <span class="icon_profile"></span>
                            </div>
                            <div class="input__item" style="width: 100%">
                                <input type="text" placeholder="Anime Title" name="title" required="">
                                <span class="icon_id"></span>
                            </div>
                            <div class="input__item" style="width: 100%">
                                <input type="text" placeholder="Poster" name="poster" required="">
                                <span class="icon_image"></span>
                            </div>
                            
                            <div class="input__item" style="width: 100%">
                                <input type="text" placeholder="views" name="views" required="">
                                <span class="icon_datareport"></span>
                            </div>
                            <div class="input__item" style="width: 100%">
                                <input type="text" placeholder="Description" name="description" required="">
                                <span class="icon_book"></span>
                            </div>
                            <div class="input__item" style="width: 100%">
                                <input type="text" placeholder="Link Anime" name="link" required="">
                                <span class="icon_link"></span>
                            </div>
                            <div class="input__item" style="width: 100%">
                                <input type="text" placeholder="Airing Year" name="year" required="">
                                <span class="icon_calendar"></span>
                            </div>
                           
                                <select  name="seleGenre" >
                                    <option value="0">All</option>
                                    <c:forEach items="${requestScope.genre}" var="g">
                                        <option value="${g.id}" ${g.id == seleGenID ? 'selected' : ''}>${g.name}</option>
                                    </c:forEach> 
                                </select>
                             <select name="seleStudio" >
                                        <option value="0">All</option>
                                    <c:forEach items="${requestScope.studio}" var="g">
                                        <c:choose>
                                            <c:when test="${g.id == seleStuID}">
                                                <option value="${g.id}" selected="">${g.name}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${g.id}" >${g.name}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    </select>
                            
                                <button style="display: block" type="submit" class="site-btn">Add Now</button>
                                <h3 style="color: green">${requestScope.mes}</h3>
                        </form>
                        </div>
                </div>
             
            </div>
        </div>
    </section>
    <!-- Signup Section End -->

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
    <script src="js/register.js"></script>

</body>

</html>
