package com.jpmorgan.accounts.validation.application.dto;

import lombok.Data;

@Data
public class ValidationResponseDTO {

    private String provider;
    private Boolean valid;
}
