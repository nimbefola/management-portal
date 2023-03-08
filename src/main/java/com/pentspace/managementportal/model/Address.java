package com.pentspace.managementportal.model;
;
import lombok.Data;

import java.util.Date;


@Data
public class Address{
    private String id;
    private Date created;
    private Date updated;
    private Long version;
    private String line1;
    private String line2;
    private String state;
    private String country;

}
