package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(name = "Error Response", description = "Schema for Error Response")
@Data
@AllArgsConstructor
public class ErrorResponseDto {
    @Schema(description = "Path of the API", example = "/create")
    private String apiPath;

    @Schema(description = "HTTP Status Code", example = "500")
    private HttpStatus errorCode;

    @Schema(description = "Error Message of error happened", example = "Internal Server Error")
    private String errorMessage;

    @Schema(description = "Time error happened", example = "2023-01-01T00:00:00")
    private LocalDateTime errorTime;

}
