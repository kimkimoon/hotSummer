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
	var check = false;
	var noCheck = 0;
	function toggle(No){ //view 토글
		$(".subTr").each(function(i){
			$(".subTr").eq(i).hide();
		});	
		if(check==false||noCheck!=No){
			check = true;
			noCheck=No;
			$("#hiddenContent"+No).show();
			var hit = {NO:No};
			$.ajax({
				type:"post",
				data:hit,
				url:"/board/hit",
				success:function(data){
					$("#mainDiv").html(data);
				}
			})
		}else{
			noCheck=0;
			check = false;
		}
	}
</script>

</head>
<body>
	<c:set var="totalPage"/>
	<div class="container" id="mainDiv">
		<a href="#layer" class="clickPop" id="default">글&nbsp;쓰&nbsp;기</a>
		<div class="writePop">	<!-- 레이어 팝업 처리 -->
			<div class="dimBg"></div>
			<div id="layer" class="pop-layer">
					<table class="table table-hover">
						<tr>
							<td rowspan="3"><span id="changeT"><br>글<br>쓰<br>기</span></td>
							<td rowspan="2">
								제목 : <input type="text" id="TITL" name="TITL"/><br>
								<textarea class="form-control col-sm-5" rows="5" id="CNTT" name="CNTT"></textarea></td>
							<td rowspan="2">작성자 : <input type="text" id="WRT_NM" name="WRT_NM"/> <br><br><br> 
								<button class="btn pull-center" id="writeGo">쓰기</button> &nbsp;&nbsp;
								<button class="btn pull-cener" id="popClose">닫기</button></td>
						</tr>
					</table>
			</div>
		</div>
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
						<c:if test="${status.index==1}">
							<c:set var="totalPage" value="${boardList.TOTAL_PAGE}"/>
						</c:if>	
							<tr class="mainTr"  id="mainTr" align="center">
								<td width="30px">${boardList.NO}</td>
								<td width="50px">
									<c:forEach var="i" begin="1" end="${boardList.LE}" step="1">
										&nbsp;&nbsp;&nbsp;&nbsp;
									</c:forEach>
									<a href="javascript:toggle(${boardList.NO});" id="${boardList.NO}">
											<span id="title${boardList.NO}">${boardList.TITL}</span>
									</a>
								</td>
								<td width="50px"><span id="usName${boardList.NO}">${boardList.WRT_NM}</span></td>
								<td width="50px">${fn:substring(boardList.REG_DT,0,10)}</td>
							</tr>
							<tr class="subTr" id="hiddenContent${boardList.NO}"style="display:none;height:150px;">
								<td colspan="4" align="center">
										<span id="content${boardList.NO}">${boardList.CNTT}</span>
										<div class="pull-right" >조회수 : ${boardList.INQRY_CNT}</div>
										<div class="container-fluid full-width" style="vertical-align: middle;margin-top:3%;">
											<div class="low-flid">
												<a href="#layer" class="clickPop btn pull-right" 
												   id="modifyBtn" name="${boardList.NO}">수정</a>
												<a href="#layer" class=" clickPop btn pull-right" 
												   id="replyBtn" name="${boardList.NO}">댓글</a>
											</div>
										</div>
								</td>
							</tr>
					</c:forEach>
				</tbody>
			</table>
	
		<div class="col-md-12" align="center">
			<ul class="pagination" id="pageArea">
				<li class="page-item"><a class="page-link" style="cursor:pointer">Prev</a></li>
				<c:forEach var="i" begin="1" end="${totalPage}" step="1">
					<li class="page-item"><a href="/board/list?page=${i}" class="page-link" style="cursor:pointer">${i}</a></li>
				</c:forEach>
				<li class="page-item"><a class="page-link" style="cursor:pointer">Next</a></li>				
			</ul>
		</div>
	</div>
</body>
</html>