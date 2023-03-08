package com.pentspace.managementportal.model;

import com.pentspace.managementportal.model.enums.MessageStatus;
import lombok.Data;

import java.util.Date;

@Data
public class ChatMessage {
    private String id;
    private Date created;
    private Date updated;
    private Long version;
    private String senderId;
    private String recipientId;
    private String senderUsername;
    private String recipientUsername;
    private String content;
    private MessageStatus status;
}
