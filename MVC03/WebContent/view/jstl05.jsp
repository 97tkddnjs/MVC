<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String[] str ={"사과", "바나나", "orange", "strawberry"};
	request.setAttribute("str", str);
%>
<c:set var="cnt" value="10"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
반복문
<!--= ${str} == 는 request.getAttribute("str");-->
<c:forEach var="f" items="${str}">
	${f}<br>
</c:forEach>

</body>
</html>