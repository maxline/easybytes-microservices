package com.eazybytes.loans.controller;

import com.eazybytes.loans.service.ILoanService;
import com.eazybytes.loans.constants.LoanConstants;
import com.eazybytes.loans.dto.ErrorResponseDto;
import com.eazybytes.loans.dto.LoanDto;
import com.eazybytes.loans.dto.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for Loans in EazyBank",
        description = "CRUD REST APIS in EazyBank to CREATE, UPDATE, FETCH and DELETE account details"
)
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class LoanController {

    private ILoanService iLoanService;

    @Operation(summary = "Create a loan REST API",
            description = "Create a new Loan REST API in EazyBank"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(@RequestParam
                                                  @Pattern(regexp = "(^$|[0-9]{1,10})", message = "Mobile number must be 10 digits")
                                                  String mobileNumber) {
        iLoanService.createLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(LoanConstants.STATUS_201, LoanConstants.MESSAGE_201));
    }

    @Operation(summary = "Fetch Loan details REST API",
            description = "Fetch Loan based on mobile number REST API"
    )
    @GetMapping("/fetch")
    public ResponseEntity<LoanDto> fetchAccountDetails(@RequestParam
                                                       @Pattern(regexp = "[0-9]{1,10}", message = "Mobile number should be up to 10 digits")
                                                       String mobileNumber) {
        LoanDto customerDto = iLoanService.fetchLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDto);
    }

    @Operation(summary = "Update Loan details REST API",
            description = "Update Loan based on a account number REST API in EazyBank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status 200 OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "HTTP Status Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody LoanDto loanDto) {
        boolean isUpdated = iLoanService.updateLoan(loanDto);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoanConstants.STATUS_417, LoanConstants.MESSAGE_417_UPDATE));
        }
    }

    @Operation(summary = "Delete Loan details REST API",
            description = "Delete Loan based on mobile number REST API"
    )
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccountDetails(@RequestParam
                                                            @Pattern(regexp = "[0-9]{1,10}", message = "Mobile number should be up to 10 digits")
                                                            String mobileNumber) {
        boolean isDeleted = iLoanService.deleteLoan(mobileNumber);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoanConstants.STATUS_417, LoanConstants.MESSAGE_417_DELETE));
        }
    }

}
