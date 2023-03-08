package com.pentspace.managementportal.model;

import lombok.Data;

import java.util.Date;

@Data
public class Service{
    private String id;
    private Date created;
    private Date updated;
    private Long version;
    private String title;
    private String description;
    private String serviceImageUrl;

}
