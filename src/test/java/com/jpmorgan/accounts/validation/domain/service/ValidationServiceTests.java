package com.jpmorgan.accounts.validation.domain.service;

import com.jpmorgan.accounts.validation.TestUtils;
import com.jpmorgan.accounts.validation.application.dto.AccountValidationRequestDTO;
import com.jpmorgan.accounts.validation.application.dto.AccountValidationResponseDTO;
import com.jpmorgan.accounts.validation.infrastructure.mapper.AccountValidationMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
public class ValidationServiceTests {

    @Mock
    private DataProviderService dataProviderService;

    @Mock
    private AccountValidationMapper accountValidationMapper;

    @InjectMocks
    private ValidationService validationService;

    @Test
    public void validateAccount_validInput_success() {
        AccountValidationRequestDTO request = TestUtils.accountValidationRequestDTO();

        when(dataProviderService.validateAccount(any())).thenReturn(TestUtils.accountValidationResponse());
        when(accountValidationMapper.validationRequestDtoToValidationRequest(any())).thenReturn(TestUtils.accountValidationRequest());
        when(accountValidationMapper.validationResponseToValidationResponseDto(any())).thenReturn(TestUtils.accountValidationResponseDTO());

        AccountValidationResponseDTO response = validationService.validateAccount(request);

        assertThat(response.getValidationResponses().size(), is(1));
        assertThat(response.getValidationResponses().get(0).getProvider(), is("P1"));
        assertTrue(response.getValidationResponses().get(0).getValid());
    }
}
