package com.jpmorgan.accounts.validation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpmorgan.accounts.validation.application.dto.AccountValidationRequestDTO;
import com.jpmorgan.accounts.validation.application.dto.AccountValidationResponseDTO;
import com.jpmorgan.accounts.validation.application.dto.ValidationResponseDTO;
import com.jpmorgan.accounts.validation.domain.model.AccountValidationRequest;
import com.jpmorgan.accounts.validation.domain.model.AccountValidationResponse;
import com.jpmorgan.accounts.validation.domain.model.ValidationResponse;

import java.util.List;

public class TestUtils {

    public static AccountValidationRequestDTO accountValidationRequestDTO() {
        var requestDTO = new AccountValidationRequestDTO();
        requestDTO.setAccountNumber("1");
        requestDTO.setProviders(List.of("P1", "P2"));
        return requestDTO;
    }

    public static AccountValidationRequest accountValidationRequest() {
        var request = new AccountValidationRequest();
        request.setAccountNumber("1");
        request.setProviders(List.of("P1", "P2"));
        return request;
    }

    public static AccountValidationRequest accountValidationRequestWithoutProviders() {
        var request = new AccountValidationRequest();
        request.setAccountNumber("1");
        return request;
    }

    public static AccountValidationResponseDTO accountValidationResponseDTO() {
        var validationResponseDTO = new ValidationResponseDTO();
        validationResponseDTO.setValid(true);
        validationResponseDTO.setProvider("P1");
        var accountValidationResponseDTO = new AccountValidationResponseDTO();
        accountValidationResponseDTO.setValidationResponses(List.of(validationResponseDTO));
        return accountValidationResponseDTO;
    }

    public static AccountValidationResponse accountValidationResponse() {
        var validationResponse = new ValidationResponse("P1", true);
        return new AccountValidationResponse(List.of(validationResponse));
    }

    public static String objectAsString(Object obj) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(obj);
    }
}
