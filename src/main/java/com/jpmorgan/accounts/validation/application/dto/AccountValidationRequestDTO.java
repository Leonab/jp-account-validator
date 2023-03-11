package com.jpmorgan.accounts.validation.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class AccountValidationRequestDTO {

    @NotBlank
    private String accountNumber;
    private List<String> providers;
}
