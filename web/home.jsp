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
    <title>Anime | Home page</title>

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
    <c:if test="${not empty requestScope.mes}">
        <div class="alert alert-success">
            <h3>${requestScope.mes}</h3>
        </div>
    </c:if>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header Section Begin -->
    <header class="header">
        <jsp:include page="header_footer/menu.jsp"></jsp:include>
    </header>
    <!-- Header End -->

    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="hero__slider owl-carousel">
            <c:forEach items="${requestScope.videoNew}" var="v">
                <div class="hero__items set-bg" data-setbg="${v.poster}">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="hero__text">
                                <div class="label" >
                                    <c:forEach items="${requestScope.genre}" var="g">
                                        <c:if test="${g.id == v.genreId}">
                                           ${g.name}
                                        </c:if>
                                    </c:forEach> 
                                </div>
                                <h2>${v.title}</h2>
                                <p style="color: #c1c8d8">${v.description}</p>
                                <a href="detail?id=${v.id}"><span>Watch Now</span> <i class="fa fa-angle-right"></i></a>
                        
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>    
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="trending__product">
                        <div class="row">
                            <div class="col-lg-8 col-md-8 col-sm-8">
                                <div class="section-title">
                                    <h4>All Anime</h4>
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
                            <div class="col-lg-4 col-md-6 col-sm-6">
                                <div class="product__item">
                                    <a href="detail?id=${v.id}">
                                         <div class="product__item__pic set-bg" data-setbg="${v.poster}">
                                        <div class="ep">1/1</div>
                                        <div class="comment"><i class="fa fa-comments"></i></div>
                                        <div class="view"><i class="fa fa-eye"></i> ${v.views}</div>
                                        </div>
                                    </a>
                                    <div class="product__item__text">
                                        <ul>
                                            <li><c:forEach items="${requestScope.genre}" var="g">
                                                    <c:if test="${g.id == v.genreId}">
                                                        ${g.name}
                                                    </c:if>
                                                </c:forEach> </li>
                                            <li>Movie</li>
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
                                <a href="home?page=1"><i class="fa fa-angle-double-left"></i></a>
                            </c:if>
                                
                            <c:forEach begin="1" end="${mp}" var="p">
                                <c:choose>
                                    <c:when test="${requestScope.page == p}">
                                        <a href="#" class="current-page">${p}</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="home?page=${p}">${p}</a>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                                        
                            <c:if test="${cp != (mp)}">
                                <a href="home?page=${mp}"><i class="fa fa-angle-double-right"></i></a>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-8">
                    <div class="product__sidebar">
                        <div class="product__sidebar__view">
                            <div class="section-title">
                                <h5>Top Views</h5>
                            </div>
                            <ul class="filter__controls">
                                <li class="active" data-filter="*">All Year</li>

                            </ul>
                            <c:forEach items="${requestScope.videoView}" var="v">
                                <div class="filter__gallery">
                                    <div class="product__sidebar__view__item set-bg mix day years"
                                         data-setbg="${v.poster}">
                                        <div class="ep">1/1</div>
                                        <div class="view"><i class="fa fa-eye"></i> ${v.views}</div>
                                        <h5><a href="detail?id=${v.id}">${v.title}</a></h5>
                                    </div>

                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
        </div>
    </div>
</section>
<!-- Product Section End -->

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


</body>

</html>
