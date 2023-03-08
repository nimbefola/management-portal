package com.pentspace.managementportal.model;


import com.pentspace.managementportal.model.enums.ProjectStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
public class Project {
    private String id;
    private Date created;
    private Date updated;
    private Long version;
    private String accountId;
    private String title;
    private String description;
    private String supportingImageUrl;
    private BigDecimal amountExpected;
    private BigDecimal amountContributed;
    private LocalDate endDate;
    private ProjectStatus status;
    private String projectBase64Image;
}
