package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
public class CustomerDto {
    @NotEmpty(message = "Name should not be null or empty")
    @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters")
    private String name;
    @NotEmpty(message = "Email should not be null or empty")
    @Email(message = "Email should be valid")
    private String email;
    @Pattern(regexp = "[0-9]{1,10}", message = "Mobile number should be up to 10 digits")
    private String mobileNumber;
    private AccountDto accountDto;
}
