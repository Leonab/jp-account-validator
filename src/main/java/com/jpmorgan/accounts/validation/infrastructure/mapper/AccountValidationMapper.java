package com.jpmorgan.accounts.validation.infrastructure.mapper;

import com.jpmorgan.accounts.validation.application.dto.AccountValidationRequestDTO;
import com.jpmorgan.accounts.validation.domain.model.AccountValidationRequest;
import org.mapstruct.Mapper;

@Mapper
public interface AccountValidationMapper {

    AccountValidationRequest validationRequestDtoToValidationRequest(AccountValidationRequestDTO requestDTO);
}
