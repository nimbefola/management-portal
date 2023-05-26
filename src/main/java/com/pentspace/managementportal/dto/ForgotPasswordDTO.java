package com.pentspace.managementportal.dto;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class ForgotPasswordDTO {

    @Email(message = "Invalid Mail")
    private String email;
}
