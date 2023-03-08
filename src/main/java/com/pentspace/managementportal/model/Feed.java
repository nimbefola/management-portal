package com.pentspace.managementportal.model;

import com.pentspace.managementportal.model.enums.FeedStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Feed  {
    private String id;
    private Date created;
    private Date updated;
    private Long version;
    private String mediaUrl;
    private String message;
    private List<Comment> comments;
    private String username;
    private String feedImageBase64;
    private FeedStatus status;
}
