<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chat</title>
</head>
<body>
	<!-- 별명 입력 -->
	nick:
	<input type="text" id="nickname" />
	<input type="button" id="enterbtn" value="enter" />
	<input type="button" id="exitbtn" value="exit" />

	<h3>chat</h3>
	<div id="chatarea">
		<div id="chatmessagearea"></div>
	</div>

	<h3>message</h3>
	<input type="text" id="message">
	<input type="button" id="sendbtn" value="send" />
</body>

<script>
	window.addEventListener("load", function(e) {
		var nickname = document.getElementById("nickname");

		var enterbtn = document.getElementById("enterbtn");
		var exitbtn = document.getElementById("exitbtn");

		var chatarea = document.getElementById("chatarea");
		var chatmessagearea = document.getElementById("chatmessagearea");

		var message = document.getElementById("message");
		var sendbtn = document.getElementById("sendbtn");

		var websocket;
		enterbtn.addEventListener('click', function(e) {
			websocket = new WebSocket("ws://localhost/chat-ws");

			//연결 되었을 때
			websocket.addEventListener('open', function(e) {
				websocket.send(nickname.value + " 참석");
			})
			//연결 해제할 때
			websocket.addEventListener('close', function(e) {
				websocket.send(nickname.value + " 나갔습니다.");
			})
			//메시지가 왔을 때 
			websocket.addEventListener('message', function(e) {
				//메시지
				var msg = e.data;

				chatmessagearea.innerHTML = msg + "<br/>"
						+ chatmessagearea.innerHTML
			})
		});
		//연결 해제 버튼을 누를 때 
		exitbtn.addEventListener('click', function(e) {
			websocket.close();
		});
		//전송 버튼을 누를 때
		sendbtn.addEventListener('click', function(e) {
			websocket.send(nickname.value + ":" + message.value);
			message.value = "";
		});
		//message에서 Enter를 누를 때 메시지 전송
		message.addEventListener('keypress', function(e) {
			event = e || window.event
			var keycode = (event.keyCode ? event.keyCode : event.which)
			if (keycode == '13') {
				websocket.send(nickname.value + ":" + message.value);
				message.value = "";
			}
		});
	});
</script>
</html>