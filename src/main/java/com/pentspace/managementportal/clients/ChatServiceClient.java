package com.pentspace.managementportal.clients;

import com.pentspace.managementportal.model.ChatMessage;
import com.pentspace.managementportal.model.Transaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "ChatServiceClient", url = "http://localhost:30306/chat")
public interface ChatServiceClient {

    @GetMapping(path = "/sender/{senderId}", produces = "application/json")
    List<ChatMessage> getAllSenderChatMessage(@PathVariable("senderId") String senderId);

    @GetMapping(path = "/sender/{senderId}/pending", produces = "application/json")
    List<ChatMessage> getAllUnReceivedUserChatMessage(@PathVariable("senderId") String senderId);

    @GetMapping(path = "/{id}", produces = "application/json")
    ChatMessage getChatMessageById(@PathVariable("id") String id );

    @PutMapping(path = "/{id}", produces = "application/json")
    ChatMessage markChatMessageAsDelivered(@PathVariable("id") String id );

}
