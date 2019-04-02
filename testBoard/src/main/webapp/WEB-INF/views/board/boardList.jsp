<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/WEB-INF/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<script type="text/javascript">
	function toggle(No){ //view 토글
		$("#hiddenContent"+No).toggle();
	}
</script>
</head>
<body>
	<div class="container">
		<form action="">
			<table class="table table-hover">
				<tr>
					<td rowspan="2"><br>글<br>쓰<br>기</td>
					<td rowspan="2"><textarea class="form-control col-sm-5" rows="5"></textarea></td>
					<td rowspan="2">작성자 : <input type="text" id="name"/> <br><br><br> <button class="btn pull-center">쓰기</button></td>
				</tr>
			</table>
		</form>
		<form id="exForm" name="boardForm" method="post">
			<table class="table table-striped table-hover">
				<thead>
					<tr align="center">
						<td width="30px">글번호</td>
						<td width="50px">제목</td>
						<td width="50px">작성자</td>
						<td width="50px">작성일자</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="boardList" varStatus="status">
						<c:if test="${boardList.ORN_NO==null}"> <!-- ORN_NO가 null일때-->
							<tr align="center">
								<td width="30px">${boardList.NO}</td>
								<td width="50px">
									<a href="javascript:toggle(${boardList.NO});" id="${boardList.NO}">${boardList.TITL}</a></td>
								<td width="50px">${boardList.WRT_NM}</td>
								<td width="50px">${fn:substring(boardList.REG_DT,0,10)}</td>
							</tr>
							<tr id="hiddenContent${boardList.NO}"style="display:none;height:150px;">
								<td colspan="4" align="center">
										${boardList.CNTT}
										<div class="container-fluid full-width">
											<div class="low-flid">
												<button class="btn pull-right">수정</button>
												<button class="btn pull-right">댓글</button>
											</div>
										</div>
										<table class="table table-striped table-hover">
											<tr align="center">
												<td>댓글</td>
												<td>내용</td>
												<td>작성자</td>
												<td>작성일자</td>
											</tr>
											<c:forEach items="${list}" var="checkORN" varStatus="status">
												<c:if test="${checkORN.ORN_NO!=null && checkORN.ORN_NO==boardList.NO}">	
													<tr align="center">
														<td></td>
														<td>${checkORN.CNTT}</td>
														<td>${checkORN.WRT_NM}</td>
														<td>${fn:substring(checkORN.REG_DT,0,10)}</td>
													</tr>
												</c:if>
											</c:forEach>
										</table>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</form>
		
		<form id="inBoard" name="inBoard" method="get">
			
		</form>
		
	</div>
</body>
</html>