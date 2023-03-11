package com.jpmorgan.accounts.validation.infrastructure.mapper;

import com.jpmorgan.accounts.validation.application.dto.AccountValidationRequestDTO;
import com.jpmorgan.accounts.validation.application.dto.AccountValidationResponseDTO;
import com.jpmorgan.accounts.validation.domain.model.AccountValidationRequest;
import com.jpmorgan.accounts.validation.domain.model.AccountValidationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountValidationMapper {

    AccountValidationRequest validationRequestDtoToValidationRequest(AccountValidationRequestDTO requestDTO);

    AccountValidationResponseDTO validationResponseToValidationResponseDto(AccountValidationResponse response);
}
