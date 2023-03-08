package com.pentspace.managementportal.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Comment{
    private String id;
    private Date created;
    private Date updated;
    private Long version;
    private Feed feed;
    private String message;
    private String username;

}
