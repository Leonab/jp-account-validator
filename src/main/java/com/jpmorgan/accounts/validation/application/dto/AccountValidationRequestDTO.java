package com.jpmorgan.accounts.validation.application.dto;

import java.util.List;

import lombok.Data;

@Data
public class AccountValidationRequestDTO {

    private Integer accountNumber;
    private List<String> providers;
}
