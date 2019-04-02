<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
	<td>No</td>
	<td>title</td>
	<td>content</td>
	<td>user</td>
	<td>number</td>
	<td>???</td>
	<td>redDate</td>
</tr>
<c:forEach items="${list}" var="boardList" varStatus="status">
<tr>
	<td>${boardList.NO}</td>
	<td>${boardList.TITL}</td>
	<td>${boardList.CNTT}</td>
	<td>${boardList.WRT_NM}</td>
	<td>${boardList.ORN_NO}</td>
	<td>${boardList.INQRY_CNT}</td>
	<td>${boardList.REG_DT}</td>
</tr>
</c:forEach>
</table>
</body>
</html>