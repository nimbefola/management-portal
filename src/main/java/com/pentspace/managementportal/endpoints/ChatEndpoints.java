package com.pentspace.managementportal.endpoints;

import com.pentspace.managementportal.clients.ChatServiceClient;
import com.pentspace.managementportal.model.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "chat")
public class ChatEndpoints {
    @Autowired
    private ChatServiceClient chatServiceClient;

    @GetMapping(path = "/sender/{senderId}", produces = "application/json")
    public ResponseEntity<List<ChatMessage>> getAllSenderChatMessage(@PathVariable("senderId") String senderId){
        return new ResponseEntity<>(chatServiceClient.getAllSenderChatMessage(senderId), HttpStatus.OK);
    }

    @GetMapping(path = "/sender/{senderId}/pending", produces = "application/json")
    public ResponseEntity<List<ChatMessage>> getAllUnReceivedUserChatMessage(@PathVariable("senderId") String senderId){
        return new ResponseEntity<>(chatServiceClient.getAllUnReceivedUserChatMessage(senderId), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<ChatMessage> getChatMessageById(@PathVariable("id") String id ){
        return new ResponseEntity<>(chatServiceClient.getChatMessageById(id), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<ChatMessage> markChatMessageAsDelivered(@PathVariable("id") String id ){
        return new ResponseEntity<>(chatServiceClient.markChatMessageAsDelivered(id), HttpStatus.OK);
    }

}
