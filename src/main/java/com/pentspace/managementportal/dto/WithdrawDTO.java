package com.pentspace.managementportal.dto;

import lombok.Data;

@Data
public class WithdrawDTO {
    private String beneficiaryAccountId;
    private String amount;
    private String transactionPin;
}
