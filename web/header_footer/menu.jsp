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
    <title>Anime | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
    rel="stylesheet">


</head>

<body>
    <!-- Header Section Begin -->
        <div class="container">
            <div class="row">
                <div class="col-lg-2">
                    <div class="header__logo">
                        <a href="home">
                            <img src="img/logo.png" alt="Logo Web">
                        </a>
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="header__nav">
                        <nav class="header__menu mobile-menu">
                            <ul>
                                <li><a href="home">Homepage</a></li>
                                <li><a href="categories">Categories </a></li>
                                <li><a href="favorite">Favorite Anime</a></li>
                                <c:if test="${sessionScope.account.admin eq true}">
                                    <li><a href="#">Admin<span class="arrow_carrot-down"></span> </a>
                                        <ul class="dropdown">
                                                <li><a href="user">User</a></li>
                                                <li><a href="show">Show anime</a></li>
                                                <li><a href="add">Add anime</a></li>
                                                <li><a href="report">Statistic</a></li>
                                        </ul>
                                    </li>
                                </c:if>
                            </ul>
                        </nav>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div class=" header__nav">
                        <nav class="header__menu mobile-menu">
                            <ul>
                                <li><a href="#" class="search-switch"><span class="icon_search"></span></a></li>
                                <li><a href="#"><span class="icon_profile"></span><span class="arrow_carrot-down"></span></a>
                                    <ul class="dropdown">
                                        <li><a href="profile">Profile</a></li>
                                        <c:if test="${sessionScope.account == null}">
                                            <li><a href="login">Login</a></li>
                                        </c:if>
                                        <c:if test="${sessionScope.account != null}">
                                            <li><a href="logout">Logout</a></li>
                                        </c:if>
                                    </ul>
                                </li>
                            </ul>
                        </nav>

                    </div>
                </div>
              
            </div>
            <div id="mobile-menu-wrap"></div>
        </div>
    <!-- Header End -->

    <!-- Js Plugins -->

</body>

</html>
