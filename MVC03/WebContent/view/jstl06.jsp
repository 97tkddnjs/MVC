<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%
	List<String> list = new ArrayList<String>();
	list.add("국어");
	list.add("python");
	list.add("java");
	list.add("c++");
	request.setAttribute("list", list);
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
<c:forEach var="f" items="${list}">
	${f}<br>
</c:forEach>

</body>
</html>