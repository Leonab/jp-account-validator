package com.jpmorgan.accounts.validation.domain.service;

import com.jpmorgan.accounts.validation.application.dto.AccountValidationRequestDTO;
import com.jpmorgan.accounts.validation.application.dto.AccountValidationResponseDTO;
import com.jpmorgan.accounts.validation.infrastructure.mapper.AccountValidationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidationService implements IValidationService {

    private final AccountValidationMapper accountValidationMapper;
    private final DataProviderService dataProviderService;

    @Override
    public AccountValidationResponseDTO validateAccount(AccountValidationRequestDTO accountValidationRequestDTO) {
        var request = accountValidationMapper.validationRequestDtoToValidationRequest(accountValidationRequestDTO);

        var response = dataProviderService.validateAccount(request);

        return accountValidationMapper.validationResponseToValidationResponseDto(response);
    }
}
