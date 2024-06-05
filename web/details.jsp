<%--
    Document   : details
    Created on : Mar 7, 2024, 5:40:06 PM
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
    <title>Anime | Anime Detail</title>

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
        <c:set var="v" value="${requestScope.video}"></c:set>
        <c:set var="account" value="${sessionScope.account}"></c:set>
        
    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="home"><i class="fa fa-home"></i> Home</a>
                        <a href="categories">Categories</a>
                        <span>
                            <c:forEach items="${requestScope.genre}" var="g">
                                <c:if test="${g.id == v.genreId}">
                                    ${g.name}
                                </c:if>
                            </c:forEach>
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Anime Section Begin -->
    <section class="anime-details spad">
        <div class="container">
            <div class="anime__details__content">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="anime__details__pic set-bg" data-setbg="${v.poster}">
                            <div class="comment"><i class="fa fa-comments"></i> 11</div>
                            <div class="view"><i class="fa fa-eye"></i> ${v.views}</div>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="anime__details__text">
                            <div class="anime__details__title">
                                <h3>${v.title}</h3>
                                <span>${v.title}</span>
                            </div>
                            
                            <p>${v.description}</p>
                            <div class="anime__details__widget">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6">
                                        <ul>
                                            <li><span>Type:</span>Movie</li>
                                            <li><span>Studios:</span><c:forEach items="${requestScope.studio}" var="g">
                                                    <c:if test="${g.id == v.studioId}">
                                                        ${g.name}
                                                    </c:if>
                                                </c:forEach></li>
                                            <li><span>Genre:</span> <c:forEach items="${requestScope.genre}" var="g">
                                                    <c:if test="${g.id == v.genreId}">
                                                        ${g.name}
                                                    </c:if>
                                                </c:forEach></li>
                                        </ul>
                                    </div>
                                    <div class="col-lg-6 col-md-6">
                                        <ul>                            
                                            <li><span>Quality:</span> FHD</li>
                                            <li><span>Views:</span> ${v.views}</li>
                                            <li><span>Year aired:</span> ${v.year}</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="anime__details__btn">
                                <c:if test="${requestScope.fav == null}">
                                    <a href="like?act=add&id=${v.id}" class="follow-btn"><i class="fa fa-heart-o"></i> Follow</a>
                                </c:if>
                                <c:if test="${requestScope.fav != null}">
                                    <a href="like?act=remove&id=${v.id}" class="follow-btn"><i class="fa fa-heart"></i> UnFollow</a>
                                </c:if>
                                    
                                <a href="watch?id=${v.id}" class="watch-btn"><span>Watch Now</span> <i
                                    class="fa fa-angle-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                                        
                                        
                <div class="row">
                    <div class="col-lg-4 col-md-4">
                        <div class="section-title">
                            <h5>Same Genre, you might like...</h5>
                        </div>
                    </div>
                </div>
                                        
                <div class="row">
                    <c:forEach items="${requestScope.VidGen}" var="g">
                        <c:if test="${g.id != v.id}">

                        <div class="col-lg-4 col-md-4">
                            <div class="anime__details__sidebar">
                           
                            <div class="product__sidebar__view__item set-bg" data-setbg="${g.poster}">
                                <div class="ep">1/1</div>
                                <div class="view"><i class="fa fa-eye"></i>${g.views}</div>
                                <h5><a href="detail?id=${g.id}">${g.title}</a></h5>
                            </div>
                            </div>
                        </div>
                        </c:if>
                    </c:forEach>
                    
                </div>
                                        
                <div class="row">
                    <div class="col-lg-4 col-md-4">
                        <div class="section-title">
                            <h5>Same Studio, you might like...</h5>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <c:forEach items="${requestScope.VidStu}" var="g">
                        <c:if test="${g.id != v.id}">
                        <div class="col-lg-4 col-md-4">
                            <div class="anime__details__sidebar">

                                <div class="product__sidebar__view__item set-bg" data-setbg="${g.poster}">
                                    <div class="ep">1/1</div>
                                    <div class="view"><i class="fa fa-eye"></i>${g.views}</div>
                                    <h5><a href="detail?id=${g.id}">${g.title}</a></h5>
                                </div>
                            </div>
                        </div>
                        </c:if>
                    </c:forEach>

                </div>
                                        
            </div>
        </section>
        <!-- Anime Section End -->

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
