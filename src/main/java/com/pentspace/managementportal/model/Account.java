package com.pentspace.managementportal.model;

import com.pentspace.managementportal.JWTToken;
import com.pentspace.managementportal.model.enums.AccountStatus;
import com.pentspace.managementportal.model.enums.AccountType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


@Data
@NoArgsConstructor
public class Account{
    private String id;
    private Date created;
    private Date updated;
    private Long version;
    private String name;
    private String businessName;
    @Email(message = "Please provide a valid Email")
    private String email;
    private String username;
    private String password;
    private String pin;
    private String profilePictureUrl;
    private String msisdn;
    private AccountStatus status;
    private AccountType accountType;
    private String profileImageBase64;
    private Set<Service> services;
    private Address address;
    private BankDetail bankDetail;
    private BigDecimal balance;
    private JWTToken token;

}
