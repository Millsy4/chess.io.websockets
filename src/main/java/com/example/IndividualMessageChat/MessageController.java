package com.example.IndividualMessageChat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    public void send(SimpMessageHeaderAccessor sha, @Payload String username) {
    	
    	String messageBody = username.substring(username.indexOf("?!~~~!?")+7);
    	String username0 = username.substring(0,username.indexOf("?!~~~!?"));
    	
        String message = "Hello from " + sha.getUser().getName();
        	System.out.println(username);
        simpMessagingTemplate.convertAndSendToUser(username0, "/queue/messages", messageBody);
        
    }
}





