package com.pentspace.managementportal.dto;


import com.pentspace.managementportal.JWTToken;
import com.pentspace.managementportal.model.enums.Roles;
import lombok.Data;

@Data
public class UserSignUpResponseDto {

    private String id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String country;

    private String email;

    private Roles role;

}
