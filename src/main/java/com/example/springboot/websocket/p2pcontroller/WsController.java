package com.example.springboot.websocket.p2pcontroller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	@MessageMapping("/chat")
	public void handleChat(Principal principal,String msg){
		if("wsx".equals(principal.getName())){
			messagingTemplate.convertAndSendToUser("zb", "/queue/notify","wsx send to zb"+ msg);
		}else{
			messagingTemplate.convertAndSendToUser("wsx", "/queue/notify","zb send to wsx"+ msg);
		}
	}
}
