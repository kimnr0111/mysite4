<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.js"></script>
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrap">
	
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //header -->

		<c:import url="/WEB-INF/views/include/nav.jsp"></c:import>
		<!-- //nav -->

		<c:import url="/WEB-INF/views/include/guestAside.jsp"></c:import>
		<!-- //aside -->
		
		<div id="content">
		
			<div id="content-head">
            	<h3>ajax방명록</h3>
            	<div id="location">
            		<ul>
            			<li>홈</li>
            			<li>방명록</li>
            			<li class="last">ajax방명록</li>
            		</ul>
            	</div>
                <div class="clear"></div>
            </div>
            <!-- //content-head -->
            
            <div id="guestbook">
				<table id="guestAdd">
					<colgroup>
						<col style="width: 70px;">
						<col>
						<col style="width: 70px;">
						<col>
					</colgroup>
					<tbody>
						<tr>
							<th><label class="form-text" for="input-uname">이름</label></td>
							<td><input id="input-uname" type="text" name="name"></td>
							<th><label class="form-text" for="input-pass">패스워드</label></td>
							<td><input id="input-pass"type="password" name="password"></td>
						</tr>
						<tr>
							<td colspan="4"><textarea name="content" cols="72" rows="5"></textarea></td>
						</tr>
						<tr class="button-area">
							<td colspan="4"><button id="guestAddBtn">등록</button></td>
						</tr>
					</tbody>
					
				</table>
				<!-- //guestWrite -->
				
				<div id="guestbookListArea">
			
				</div>
				
            </div>
			<!-- //guestbook -->
		</div>
		<!-- //content  -->
		<div class="clear"></div>
		
		<div id="footer">
			<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		</div>
		<!-- //footer -->
		
	</div>
	<!-- //wrap -->

<!-- 삭제팝업(모달)창 -->
	<div class="modal fade" id="delModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title">방명록삭제</h4>
				</div>
				<div class="modal-body">
					<label>비밀번호</label>
					<input type="password" name="modalPassword" id="modalPassword"><br>	
					<input type="hidden" name="modalNo" value="" id="modalNo"> <br>	
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-danger" id="btnDel">삭제</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
</body>

<script type="text/javascript">
$(document).ready(function(){
	
	//전체리스트 불러오기
	fetchList();
	
});

//삭제버튼 클릭할때
$("#guestbookListArea").on("click", "a", function(){
	event.preventDefault(); //a태그 기능 막기위해 사용
	
	var $this = $(this);
	
	var no = $this.data("delno");
	
	console.log(no);
	
	$("#modalNo").val(no); //no값 전달
	$("#modalPassword").val(""); //password칸 비우기
	$("#delModal").modal(); //모달창 보이게
});

//모달창 삭제버튼 클릭
$("#btnDel").on("click", function(){	
	//데이터 수집
	var password = $("#modalPassword").val();
	var no = $("#modalNo").val();
	
	//데이터 전송 -> 그리기 작업
	$.ajax({
		url : "${pageContext.request.contextPath }/api/gb/delete",		
		type : "post",
		contentType : "application/json",
		data : JSON.stringify({password: password, no: no}),

		dataType : "json",
		success : function(count){
			/*성공시 처리해야될 코드 작성*/
			console.log(count);
			if(count == 1) {
				//모달창 닫기
				$("#delModal").modal("hide");
				//리스트 지우기
				$("#t-" + no).remove();
			} else {
				//모달창 닫기
				$("#delModal").modal("hide");
			}
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	});
	
});

//등록버튼 클릭
$("#guestAddBtn").on("click", function(){
	//form이 기능하지 않도록 해줌, 현재 이벤트의 기본 동작 중단
	event.preventDefault();
	//데이터 추출
	var uname = $("#input-uname").val();
	
	var upass = $("#input-pass").val();
	
	var content = $("[name = content]").val();
	
	var guestbookVo = {
			name: uname,
			password: upass,
			content: content
			};
	
	$.ajax({
		url : "${pageContext.request.contextPath }/api/gb/add",		
		type : "post",
		contentType : "application/json",
		data : JSON.stringify(guestbookVo),

		dataType : "json",
		success : function(vo){
			/*성공시 처리해야될 코드 작성*/
			render(vo, "up");
			$("#input-uname").val("");
			$("#input-pass").val("");
			$("[name = content]").val("");
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	});
	
});

//전체리스트 불러오기
function fetchList(){
	$.ajax({
		
		url : "${pageContext.request.contextPath }/api/gb/list",		
		type : "post",
		//contentType : "application/json",
		//data : {name: "홍길동"},
		dataType : "json",
		success : function(guestbookList){
			/*성공시 처리해야될 코드 작성*/
			console.log(guestbookList);
			for(var i=0;i<guestbookList.length;i++) {
				render(guestbookList[i], "up");
			}
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	});
}

//리스트 그리기
function render(guestbookVo, direction) {
	var str = "";
	str += "<table id= 't-"+guestbookVo.no +"'class='guestRead'>";
	str += "<colgroup>";
	str += "	<col style='width: 10%;'>";
	str += "	<col style='width: 40%;'>";
	str += "	<col style='width: 40%;'>";
	str += "	<col style='width: 10%;'>";
	str += "</colgroup>";
	str += "<tr>";
	str += "	<td>" + guestbookVo.no + "</td>";
	str += "	<td>" + guestbookVo.name + "</td>";
	str += "	<td>" + guestbookVo.guestdate + "</td>";
	str += "	<td><a href='' data-delno=" + guestbookVo.no + ">[삭제]</a></td>";
	str += "</tr>";
	str += "<tr>";
	str += "	<td colspan=4 class='text-left' style='white-space: pre-line;'>" + guestbookVo.content + "</td>";
	str += "</tr>";
	str += "</table>";
	str += "";
	
	if(direction == "up"){
		$("#guestbookListArea").prepend(str);
	} else if(direction == "down"){
		$("#guestbookListArea").append(str);
	}
}
</script>
</html>