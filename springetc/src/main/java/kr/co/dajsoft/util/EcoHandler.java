package kr.co.dajsoft.util;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
@Component
public class EcoHandler extends TextWebSocketHandler {

	@Override
	public void afterConnectionEstablished(
			WebSocketSession session) {
		try {
			System.out.println(session.getId()+"connect");
			
		}catch(Exception e) {
			System.out.println("1:"+ e.getLocalizedMessage());
		}
	}
	@Override
	public void handleTextMessage(
			WebSocketSession session,TextMessage message) {
		try {
			System.out.println(session.getId()+"from"+message.getPayload()+"get");
			session.sendMessage((new TextMessage("echo:"+message.getPayload())));
			
		}catch(Exception e) {
			System.out.println("2:"+e.getLocalizedMessage());
		}
	}
	@Override
	public void afterConnectionClosed(
			WebSocketSession session,CloseStatus status) {
		try {
			System.out.println(session.getId()+"disconnect");
					
		}catch(Exception e) {
			System.out.println("2:"+e.getLocalizedMessage());
		}
	}
	
	
}
