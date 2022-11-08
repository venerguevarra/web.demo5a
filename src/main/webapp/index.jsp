<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<c:set var="greeting" value="Good Morning" scope="page"/>

<html>
<body>
	<h2>Bootcamp Starter Web Project</h2>
	<br/>
	<b>Greeting: <c:out value="${greeting}"/></b>
	<ul>
		<c:forEach var="index" begin="1" end="5">
            <li>Item <c:out value="${index}"/></li>
		</c:forEach>
	</ul>
	
	<ul>
	   <c:forEach items="${requestScope.names}" var="name">
	       <li><c:out value="${name}"/></li>
	   </c:forEach>
	</ul>
	
	<c:url var="addAction" value="/action" scope="page">
	   <c:param name="type" value="add"/>
	   <c:param name="page" value="catalog"/>
	</c:url>
	<a href="${addAction}">Add Action</a>
	
	<c:url var="updateAction" value="/action" scope="page">
       <c:param name="type" value="update"/>
       <c:param name="page" value="cart"/>
    </c:url>
	<a href="${updateAction}">Update Action</a>
	
	<c:forEach items="${requestScope.students}" var="entry">
        <div>
            Key: <c:out value="${entry.key}"/><br/>
            Student ID: <c:out value="${entry.value.id}"/><br/>
            First Name: <c:out value="${entry.value.firstName}"/><br/>
            Last Name: <c:out value="${entry.value.lastName}"/><br/>
            Status: 
            <c:if test="${entry.value.grade >= 75}">Pass</c:if>
            <c:if test="${entry.value.grade < 75}">Fail</c:if>
            <br/>
            <c:choose>
                <c:when test="${entry.value.grade >= 95 && entry.value.grade <= 100}">A+</c:when>
                <c:when test="${entry.value.grade >= 90 && entry.value.grade <= 94}">A</c:when>
                <c:otherwise>B</c:otherwise>
            </c:choose>
            <hr/>
        </div>
    </c:forEach>
	
</body>
</html>
