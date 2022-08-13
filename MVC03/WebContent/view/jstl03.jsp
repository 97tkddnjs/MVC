<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cnt" value="10"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
스위치 문과 같은 것
<c:choose>
	<c:when test="${cnt%2==0}">
		짝수
	</c:when>
	<c:when test="${cnt%2!=0}">
		홀수
	</c:when>
	<c:otherwise>
		일치 when 없으면 이거 실행 
	</c:otherwise>
</c:choose>

</body>
</html>