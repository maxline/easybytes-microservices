package com.eazybytes.accounts.dto;

import lombok.*;

@Data
public class AccountDto {
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
