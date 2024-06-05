<%--
    Document   : home
    Created on : Mar 7, 2024, 12:31:39 AM
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
    <title>Anime | Show page</title>

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

    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="trending__product">
                        <div class="row">
                            <div class="col-lg-8 col-md-8 col-sm-8">
                                <div class="section-title">
                                    <h4>All Anime in Web</h4>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4">
                                <div class="btn__all">
                                    <a href="#" class="primary-btn">Menu<span class="arrow_right"></span></a>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                        <c:forEach items="${requestScope.videos}" var="v">
                            <div class="col-lg-3 col-md-4 col-sm-4">
                                <div class="product__item">
                                    <a href="detail?id=${v.id}">
                                         <div class="product__item__pic set-bg" data-setbg="${v.poster}">
                                        <div class="ep">1/1</div>
                                        <div class="comment"><i class="fa fa-comments"></i></div>
                                        <div class="view"><i class="fa fa-eye"></i> ${v.views}</div>
                                        </div>
                                    </a>
                                    <div class="product__item__text">
                                        <ul >
                                            <li><h5><a style="color: red" href="delete?id=${v.id}">DELETE</a></h5> </li>
                                            <li><h5><a style="color: lightgreen" href="update?id=${v.id}">UPDATE</a></h5></li>
                                        </ul>
                                        <h5><a href="detail?id=${v.id}">${v.title}</a></h5>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>

                        <div class="product__pagination">
                            <c:set var="cp" value="${requestScope.page}"></c:set>
                            <c:set var="mp" value="${requestScope.numPage}"></c:set>
                               
                            <c:if test="${cp != 1}">
                                <a href="show?page=1"><i class="fa fa-angle-double-left"></i></a>
                            </c:if>
                                
                            <c:forEach begin="1" end="${mp}" var="p">
                                <c:choose>
                                    <c:when test="${requestScope.page == p}">
                                        <a href="#" class="current-page">${p}</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="show?page=${p}">${p}</a>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                                        
                            <c:if test="${cp != (mp)}">
                                <a href="show?page=${mp}"><i class="fa fa-angle-double-right"></i></a>
                            </c:if>
                        </div>
                    </div>
                </div>

        </div>
    </div>
</section>
<!-- Product Section End -->

<!-- Footer Section Begin -->
<footer class="footer">
    <jsp:include page="../header_footer/footer.jsp"></jsp:include>

</footer>
  <!-- Footer Section End -->

  <!-- Search model Begin -->
      <div class="search-model">
    <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="search-close-switch"><i class="icon_close"></i></div>
        <form class="search-model-form" action="show">
            <input type="text" id="search-input" name="search" placeholder="Search here.....">
            <button type="submit" class="site-btn">Search</button>
        </form>
    </div>
</div>

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
