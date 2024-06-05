<%--
    Document   : test
    Created on : Mar 7, 2024, 10:13:17 AM
    Author     : DuyAnhComputer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Test</h1>
        <c:set var="v" value="${requestScope.video}"></c:set>

        <h3>${v.title}</h3>
        <h3>${v.description}</h3>
        <h3>${v.views}</h3>
        

        <iframe width="560" height="315" src="${v.link}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
        <iframe width="560" height="315" src="https://www.youtube.com/embed/SQv0CmSfUBg?si=YD2Bz0GX8hw2eIH2" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>

                <c:set var="stuID" value="${requestScope.video}"></c:set>
                ${v.title}
        for
                
        <c:set var="seleStuID" value="${requestScope.seleStudio}"></c:set>
        <h1>${seleStuID}</h1>
        <form action="categories" method="POST">
            <input type="number" name="seleGenre" value="1">


           <p style="display: inline"> Studio:</p>
                                            <select name="seleStudio" style="display: inline" >
                                                <option value="0">All</option>
                                            <c:forEach items="${requestScope.studio}" var="g">
                                                <c:choose>
                                                    <c:when test="${g.id eq seleStuID}">
                                                        <option value="${g.id}" selected="">${g.name}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${g.id}" >${g.name}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                            </select>

            <input type="submit" >

        </form>




        <c:forEach items="${requestScope.studio}" var="g">
            <c:choose>
                <c:when test="${g.id eq seleStuID}">
                    ${g.id}, ${seleStuID}, x
                </c:when>
                <c:otherwise>
                    ${g.id}, ${seleStuID}
                </c:otherwise>
            </c:choose>
        </c:forEach>

    </body>
</html>
