<%--
    Document   : home
    Created on : Mar 7, 2024, 12:26:29 AM
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
    <title>Anime | Anime Watching</title>

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
                        <a href="detail?id=${v.id}">
                            <c:forEach items="${requestScope.genre}" var="g">
                                <c:if test="${g.id == v.genreId}">
                                    ${g.name}
                                </c:if>
                            </c:forEach>
                        </a>
                        <span>${v.title}</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Anime Section Begin -->
    <section class="anime-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="anime__video__player">
                        <iframe width="1120" height="630" src="${v.link}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                    </div>
                    
                    <div class="anime__details__episodes">
                        <div class="section-title">
                            <h5>List movie</h5>
                        </div>
                        <a href="#">Full Movie</a>
                        
                    </div>
                </div>
            </div>
                    
            <div class="anime__details__content">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="section-title">
                            <h5>Introduction</h5>
                        </div>
                    </div>
                </div>
                    
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
                        </div>
                    </div>
                </div>
            </div>
                    
            <div class="row">
                
                <div class="col-lg-8">
                    
                    <div class="anime__details__form">
                        <div class="section-title">
                            <h5>Your Comment</h5>
                        </div>
                        <form action="#">
                            <textarea placeholder="Your Comment"></textarea>
                            <button type="submit"><i class="fa fa-location-arrow"></i> Review</button>
                        </form>
                    </div>
                </div>
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
