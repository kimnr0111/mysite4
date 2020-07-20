<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">

</head>


<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //header -->
		
		<c:import url="/WEB-INF/views/include/nav.jsp"></c:import>
		<!-- //nav -->

		<c:import url="/WEB-INF/views/include/boardAside.jsp"></c:import>
		<!-- //aside -->

		<div id="content">

			<div id="content-head">
				<h3>게시판</h3>
				<div id="location">
					<ul>
						<li>홈</li>
						<li>게시판</li>
						<li class="last">일반게시판</li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<!-- //content-head -->

			<div id="board">
				<div id="list">
					<form action="${pageContext.request.contextPath}/board/list" method="get">
						<div class="form-group text-right">
							<input type="text" name="search">
							<button type="submit" id=btn_search>검색</button>
						</div>
					</form>
					<table >
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>글쓴이</th>
								<th>조회수</th>
								<th>작성일</th>
								<th>관리</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${bList}" var="vo" varStatus="status">
							<tr>
								<td>${vo.no }</td>
								<td class="text-left">
								<c:forEach  begin="0" end="${vo.depth}">
								&ensp;
								</c:forEach>
								<a href="${pageContext.request.contextPath}/board/read?no=${vo.no }">${vo.title }</a>
								</td>
								<td>${vo.name }</td>
								<td>${vo.hit }</td>
								<td>${vo.boarddate }</td>
								<td>
								<c:if test="${vo.userNo == sessionScope.authUser.no }">
									<a href="${pageContext.request.contextPath}/board/delete?no=${vo.groupNo }">[삭제]</a>
								</c:if>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
		
					<div id="paging">
						<ul>
							<li><a href="">◀</a></li>
							<c:forEach begin="1" end="${(listCnt-1)/5 + 1}" step="1" varStatus="status">
								<li><a href="${pageContext.request.contextPath}/board/list?page=${status.count}">${status.count}</a></li>
							</c:forEach>
							<li><a href="">▶</a></li>
						</ul>
						
						
						<div class="clear"></div>
					</div>
					<c:if test="${sessionScope.authUser != null }">
						<a id="btn_write" href="${pageContext.request.contextPath}/board/writeForm">글쓰기</a>
					</c:if>
				
				</div>
				<!-- //list -->
			</div>
			<!-- //board -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>

		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->
	</div>
	<!-- //wrap -->

</body>

</html>
