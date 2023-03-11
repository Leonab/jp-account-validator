package com.jpmorgan.accounts.validation.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationResponse {

    private String provider;
    private Boolean valid;
}
