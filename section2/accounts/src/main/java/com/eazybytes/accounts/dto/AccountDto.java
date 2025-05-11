package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Schema(name = "Account details", description = "Schema for Account details of the customer")
@Data
public class AccountDto {

    @Schema(description = "Account number", example = "1234567890")
    @NotEmpty(message = "Account number should not be null or empty")
    @Pattern(regexp = "[0-9]{1,10}", message = "Account number should be up to 10 digits")
    private Long accountNumber;

    @Schema(description = "Account type", example = "Savings")
    @NotEmpty(message = "Account type should not be null or empty")
    private String accountType;

    @Schema(description = "Branch address", example = "Main Street 123")
    @NotEmpty(message = "Branch address should not be null or empty")
    private String branchAddress;

}
