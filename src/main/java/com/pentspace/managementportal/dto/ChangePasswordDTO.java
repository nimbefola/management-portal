package com.pentspace.managementportal.dto;

import lombok.Data;

@Data
public class ChangePasswordDTO {

    private String oldPassword;
    private String newPassword;
    private String confirmPassword;

}
