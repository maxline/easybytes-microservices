package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Schema(
        name = "Customer",
        description = "Schema for Customer & Account details"
)
@Data
public class CustomerDto {

    @Schema(description = "Customer name", example = "John Doe")
    @NotEmpty(message = "Name should not be null or empty")
    @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters")
    private String name;

    @Schema(description = "Customer email", example = "gjxY6@example.com")
    @NotEmpty(message = "Email should not be null or empty")
    @Email(message = "Email should be valid")
    private String email;

    @Schema(description = "Customer mobile number", example = "1234567890")
    @NotEmpty(message = "Mobile number should not be null or empty")
    @Pattern(regexp = "[0-9]{1,10}", message = "Mobile number should be up to 10 digits")
    private String mobileNumber;

    @Schema(description = "Account details of the customer")
    private AccountDto accountDto;

}
