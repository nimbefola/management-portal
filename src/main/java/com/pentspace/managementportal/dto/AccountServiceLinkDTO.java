package com.pentspace.managementportal.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AccountServiceLinkDTO {
    @NotBlank(message = "accountId can not be empty")
    private String accountId;
    @NotBlank(message = "serviceId can not be empty")
    private String serviceId;
}
