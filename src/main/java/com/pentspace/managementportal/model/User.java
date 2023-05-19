package com.pentspace.managementportal.model;


import com.pentspace.managementportal.JWTToken;
import com.pentspace.managementportal.model.enums.Roles;
import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class User {


    private String id;

    private String firstName;

    private String lastName;

    @Email
    private String email;

    private String password;

    private String phoneNumber;

    private String confirmPassword;

    private String country;

    private Roles roles;

    private JWTToken token;
}
