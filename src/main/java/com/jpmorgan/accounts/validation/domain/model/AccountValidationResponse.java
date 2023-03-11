package com.jpmorgan.accounts.validation.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountValidationResponse {

    private List<ValidationResponse> validationResponses;
}
