package com.jpmorgan.accounts.validation.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class AccountValidationRequest {

    private String accountNumber;
    private List<String> providers;
}
