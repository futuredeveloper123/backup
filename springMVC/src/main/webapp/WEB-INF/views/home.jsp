<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- List를 순회하기 위해서 태그 라이브러리 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- List의 데이터가 있는지 없는지 확인하기 위해서 List의 길이를 확인하기 위해서
태그 라이브러리 설정 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
<!-- css 링크 설정 -->
<!-- 이 파일은 webapp 디렉토리의 css 디렉토리에 style.css 입니다.
이런 이유로 외부 자원의 링크는 절대 경로로 설정하는 경우가 많습니다.-->
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>


	<h3>인터셉터 적용</h3>
	<ul>
		<c:if test="${LOGIN == null }">
			<li><a href="interceptor/login" class="menu">로그인</a></li>
		</c:if>
		<c:if test="${LOGIN != null }">
			<li><a href="interceptor/logout" class="menu">로그아웃</a></li>
		</c:if>
		<li><a href="board/boardlist" class="menu">게시물 보기</a></li>
		<li><a href="board/boardwrite" class="menu">게시물 쓰기</a></li>
		<li><a href="board/noticewrite" class="menu">공지사항 쓰기</a></li>
	</ul>

	<li><a href="hello" class="menu">처음 만들어보는 요청</a><br />
		<li><a href="/detail/1025" class="menu">상세보기</a><br /><li><a href="/param" class="menu">파라미터 입력</a><br />
		
	<li><a href="/forward" class="menu">forwarding - 데이터 전달</a><br />
		
	<li><a href="/redirect" class="menu">redirect - 데이터 전달</a><br />
		
	<li><a href="fileview" class="menu">File list</a>
		
	<li><a href="excel.xls" class="menu">Download excel</a>
		
	<li><a href="excelread" class="menu">엑셀 파일읽기</a></li>
		<li><a href="item.pdf" class="menu">Read PDF</a></li>
		<li><a href="item.json" class="menu">List Of ITEM</a></li>

		<li><a href="item.csv" class="menu">print text</a></li>
		<li><a href="itemrest.json" class="menu">RestControll</a></li>
		<li><a href="item.xml" class="menu">XML 출력</a></li>

		<li><a href="#" class="menu" id="ajax">Request</a></li>
		<li><a href="#" class="menu" id="ajaxxml">Xml Ajax Request </a></li>



		<li><a href="exception" class="menu">Exception Emerge</a></li>
		<li><a href="message" class="menu">spring message print</a></li>

		<li><a href="fileupload" class="menu">파일 업로드 처리</a></li>
<li><a href="user/login" class="menu">로그인</a></li>
		<fieldset>
			<legend> 회원관리 </legend>
			<li><a href="/user/join" class="menu">SIGN UP</a>
		
	</fieldset>
	</ul>
		<div id="disp"></div>

		<div align="center" class="body">
			<h2>상품 목록</h2>
			<table border="1">
				<tr class="header">
					<th align="center" width="100">상품 아이디</th>
					<th align="center" width="320">상품 이름</th>
					<th align="center" width="100">상품 가격</th>
				</tr>

				<!-- list에 데이터가 없는 경우 -->
				<c:if test="${fn:length(list) == 0 }">
					<tr>
						<td colspan="3">데이터가 없습니다.</td>
					</tr>
				</c:if>
				<!-- <!— list에 데이터가 있는 경우 —> -->
				<c:if test="${fn:length(list) != 0 }">
					<c:forEach var="item" items="${list}">
						<tr class="record">
							<td align="center">${item.itemid}</td>
							<td align="left">&nbsp; <!-- <!— 파라미터를 이용해서 데이터를 전달하는 방식 —> -->
								<!-- 
                  <a href="/detail.html?itemid=${item.itemid}">${item.itemname}</a>
                   --> <!-- <!— URL을 이용해서 데이터를 전달하는 방식 —> --> <a
								href="/detail.html/${item.itemid}">${item.itemname}</a>
							</td>
							<td align="right">${item.price}원&nbsp;</td>
						</tr>

					</c:forEach>
				</c:if>

			</table>
		</div>
	</body>
<script>
	//위치에 상관없이 스크립트를 사용하기 위해서 window 에 load 이벤트가 발생한 후 작업 
	window.addEventListener("load", function() {
		//DOM  객체 찾아오기 
		var ajax = document.getElementById("ajax");
		var disp = document.getElementById("disp");

		//확인 용 
		/* alert(ajax);
		alert(disp); */

		//click event  
		ajax.addEventListener("click", function(e) {
			// ajax 요청 객체 생성 
			var request = new XMLHttpRequest();

			// 요청 생성 
			request.open('get', '/itemrest.json')

			// 요청 전송 
			request.send('');

			// 응답이 오면 수행 
			request.addEventListener('load', function(e) {
				// for test 
				/* alert(request.responseText); */

				// json  parsing
				// list 이므로 배열로 생성 
				// 배열을 순회하면서 출력할 내용 만들기 
				var list = JSON.parse(request.responseText);

				var output = '';
				for (i in list) {
					var item = list[i];

					output += "<h3>" + item.itemname + "<h3>";
					output += "<p>" + item.description + "<p>";
				}
				// disp  에 출력
				disp.innerHTML = output;
			});

		});

		// xml 요청 
		var ajaxxml = document.getElementById("ajaxxml")
		ajaxxml.addEventListener('click', function(e) {
			/* alert("print xml"); */

			var request = new XMLHttpRequest();

			request.open('get', '/item.xml')

			request.send('');

			request.addEventListener('load', function(e) {
				//가져온 문자열을 xml 로 변환한 것 
				var list = request.responseXML;
				/* alert(list); */

				//원하는 tag 가져오기 
				var output = ' ';

				var itemnames = list.getElementsByTagName("itemname");
				var descriptions = list.getElementsByTagName("description");
				for (var i = 0; i < itemnames.length; i = i + 1) {
					var itemname = itemnames[i].childNodes[0].nodeValue;
					/* alert(itemname); */

					var description = descriptions[i].childNodes[0].nodeValue;

					output += '<h3>' + itemname + '<h3>';
					output += '<p>' + description + '<p>';
				}

				disp.innerHTML = output;
			});
		})
	});
</script>


</html>