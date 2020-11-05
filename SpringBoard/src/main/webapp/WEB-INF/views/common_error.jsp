<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>WEB-INF/views/common_error.jsp</h1>
	
		<h2>관리자에게 문의하시오.</h2>

	<hr>
	${e }
	<hr>
	${e.getMessage()}
	<hr>
	
	<c:forEach items="${e.getStackTrace() }" var="stack">
		${stack.toString()}<br>
	</c:forEach>


</body>
</html>