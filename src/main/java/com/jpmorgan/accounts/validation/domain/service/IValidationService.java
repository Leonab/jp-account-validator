package com.jpmorgan.accounts.validation.domain.service;

import com.jpmorgan.accounts.validation.application.dto.AccountValidationRequestDTO;
import com.jpmorgan.accounts.validation.application.dto.AccountValidationResponseDTO;

public interface IValidationService {

    AccountValidationResponseDTO validateAccount(AccountValidationRequestDTO accountValidationRequestDTO);
}
