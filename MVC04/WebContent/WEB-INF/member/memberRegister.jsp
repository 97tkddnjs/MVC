<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
회원 가입 화면

<form action="memberInsert.do" method="post" accept-charset="UTF-8">
<table>
  <tr>
    <td>아이디</td>
    <td><input type="text" name="id"/></td>
  </tr>
  <tr>
    <td>패스워드</td>
    <td><input type="text" name="pass"/></td>
  </tr>
  <tr>
    <td>이름</td>
    <td><input type="text" name="name"/></td>
  </tr>
  <tr>
    <td>age</td>
    <td><input type="text" name="age"/></td>
  </tr>
  <tr>
    <td>이메일</td>
    <td><input type="text" name="email"/></td>
  </tr>
  <tr>
    <td>전화 번호</td>
    <td><input type="text" name="phone"/></td>
  </tr>
  <tr>
    <td colspan="2" align="center">
    	<input type="submit" value="가입"/>
    	<input type="reset" value="취소"/>
    </td>
  </tr>
</table>
</form>

</body>
</html>