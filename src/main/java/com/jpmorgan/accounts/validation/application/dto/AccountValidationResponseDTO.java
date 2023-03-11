package com.jpmorgan.accounts.validation.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class AccountValidationResponseDTO {

    private List<ValidationResponseDTO> validationResponses;
}
