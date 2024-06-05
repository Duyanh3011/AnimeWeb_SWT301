<%--
    Document   : categories
    Created on : Mar 8, 2024, 8:36:44 AM
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
    <title>Anime | Template</title>

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

    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="home"><i class="fa fa-home"></i> Home</a>
                        <a href="categories">Categories</a>
                        <span>
                            Result
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Product Section Begin -->
    <section class="product-page spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="product__page__content">
                        <div class="product__page__title">
                            <div class="row">
                                <div class="col-lg-2 col-md-2 col-sm-6">
                                    <div class="section-title">
                                        <h4>Result</h4>
                                </div>
                                </div>
                                <div class="col-lg-10 col-md-12 col-sm-6">
                                    <div class="product__page__filter">
                                    <c:set var="seleGenID" value="${requestScope.gid}"></c:set>
                                    <c:set var="seleStuID" value="${requestScope.seleStudio}"></c:set>
                                        <form action="categories" method="POST">
                                            <p style="display: inline"> Genre:</p>
                                            <select name="seleGenre" style="display: inline">
                                                <option value="0">All</option>
                                                <c:forEach items="${requestScope.genre}" var="g">
                                                    <option value="${g.id}" ${g.id == seleGenID ? 'selected' : ''}>${g.name}</option>
                                                </c:forEach> 
                                            </select>
                                            
                                            <p style="display: inline"> Studio:</p>
                                            <select name="seleStudio" style="display: inline" >
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
                                            
                                                <p style="display: inline">Order by:</p>
                                                <select name="order" style="display: inline">
                                                    <option value="${requestScope.order}">${requestScope.order}</option>
                                                    <option value="1-10">1-10</option>
                                                    <option value="A-Z">A-Z</option>
                                                    <option value="Views">Views</option>
                                                    <option value="Years">Year</option>
                                                </select>
                                                <input style="display: inline" type="submit" value="Search">
                                        </form>
                                        
                                    </div>
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
                    </div>
                    <div class="product__pagination">
                            <c:set var="cp" value="${requestScope.page}"></c:set>
                            <c:set var="mp" value="${requestScope.numPage}"></c:set>
                               
                            <c:if test="${cp != 1 and cp != null}">
                                <a href="categories?page=1"><i class="fa fa-angle-double-left"></i></a>
                            </c:if>
                                
                            <c:forEach begin="1" end="${mp}" var="p">
                                <c:choose>
                                    <c:when test="${requestScope.page == p}">
                                        <a href="#" class="current-page">${p}</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="categories?page=${p}">${p}</a>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                                        
                            <c:if test="${cp != (mp)}">
                                <a href="categories?page=${mp}"><i class="fa fa-angle-double-right"></i></a>
                            </c:if>
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
