package com.pentspace.managementportal.model;

import com.pentspace.managementportal.model.enums.TransactionStatus;
import com.pentspace.managementportal.model.enums.TransactionType;;
import lombok.Data;;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Transaction{
    private String id;
    private Date created;
    private Date updated;
    private Long version;
    private TransactionStatus status;
    private TransactionType transactionType;
    private String sourceAccount;
    private String destinationAccount;
    private BigDecimal amount;
    private String otp;
    private String otpStatus;
    private String metaData;
}
