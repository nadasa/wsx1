package com.example.springboot.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.springboot.domain.WebSocketResponse;
import com.example.springboot.domain.WebsocketRequestMsg;

@Controller
public class TestWebSocket {
	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public WebSocketResponse response(WebsocketRequestMsg msg) throws InterruptedException{
		Thread.sleep(1000);
		return new WebSocketResponse("welcome::"+msg.getName());
	}
}
