package com.pentspace.managementportal.dto;

import lombok.Data;

@Data
public class TransferDTO {
    private String sourceAccountId;
    private String beneficiaryAccountId;
    private String amount;
    private String transactionPin;
}
