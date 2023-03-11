package com.jpmorgan.accounts.validation.application.controller;

import com.jpmorgan.accounts.validation.application.dto.AccountValidationRequestDTO;
import com.jpmorgan.accounts.validation.application.dto.AccountValidationResponseDTO;
import com.jpmorgan.accounts.validation.domain.service.IValidationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ValidationController {

    private final IValidationService validationService;

    @PostMapping("/validate")
    public AccountValidationResponseDTO validateAccount(@Valid @RequestBody AccountValidationRequestDTO request) {
        return validationService.validateAccount(request);
    }
}
