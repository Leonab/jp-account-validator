package com.jpmorgan.accounts.validation.application.controller;

import com.jpmorgan.accounts.validation.TestUtils;
import com.jpmorgan.accounts.validation.application.dto.AccountValidationRequestDTO;
import com.jpmorgan.accounts.validation.domain.service.IValidationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ValidationControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IValidationService validationService;

    @Test
    public void validateAccount_validRequest_success() throws Exception {
        var request = TestUtils.accountValidationRequestDTO();

        when(validationService.validateAccount(request)).thenReturn(TestUtils.accountValidationResponseDTO());

        this.mockMvc.perform(post("/api/v1/validate")
                        .content(TestUtils.objectAsString(request))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(TestUtils.objectAsString(TestUtils.accountValidationResponseDTO()))));
    }

    @Test
    public void validateAccount_emptyAccountNumber_throwsBadRequest() throws Exception {
        var request = new AccountValidationRequestDTO();

        this.mockMvc.perform(post("/api/v1/validate")
                        .content(TestUtils.objectAsString(request))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andExpect(status().isBadRequest());
    }
}
