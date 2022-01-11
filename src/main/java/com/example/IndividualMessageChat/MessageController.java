package com.example.IndividualMessageChat;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.HtmlUtils;

import com.example.IndividualMessageChat.MyMove;


@Controller
@MessageMapping("/hello")
public class MessageController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    
    @MessageMapping("/helloworld")
	  @SendTo("/topic/greetings")
	  public String shareMove(messageEveryone message) throws Exception {
	    System.out.println(message.toString());//test
	    return message.getSharedUMessage();
	  }

    @MessageMapping("/hellouser")
    public void send(@RequestBody userMessage uMessage) {
    	System.out.println(uMessage.getBodyOfM());
    	
        	
        simpMessagingTemplate.convertAndSendToUser(uMessage.getRecipient(), 
        		"/queue/messages", uMessage );
        
    }
    
    @MessageMapping("/chattext")
    public void sendMoves(@RequestBody userMessage uMessage) {
    	System.out.println(uMessage.getBodyOfM());
    	
        	
        simpMessagingTemplate.convertAndSendToUser(uMessage.getRecipient(), 
        		"/queue/chat", uMessage );
        
    }
}





