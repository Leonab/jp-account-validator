package com.jpmorgan.accounts.validation.domain.service;

import com.jpmorgan.accounts.validation.TestUtils;
import com.jpmorgan.accounts.validation.config.DataProviderConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@SpringBootTest
@EnableConfigurationProperties
@TestPropertySource(locations = "classpath:application.yml")
public class DataProviderServiceTests {

    private DataProviderService dataProviderService;

    @Autowired
    private DataProviderConfig dataProviderConfig;

    @BeforeEach
    public void setup() {
        this.dataProviderService = new DataProviderService(this.dataProviderConfig);
    }

    @Test
    public void validateAccount_validRequest_success() {
        var request = TestUtils.accountValidationRequest();

        var response = dataProviderService.validateAccount(request);

        assertThat(response.getValidationResponses().size(), is(2));
        assertThat(response.getValidationResponses().get(0).getProvider(), is("P1"));
        assertThat(response.getValidationResponses().get(1).getProvider(), is("P2"));
    }


    @Test
    public void validateAccount_emptyProviders_returnDefaultProviders() {
        var request = TestUtils.accountValidationRequestWithoutProviders();

        var response = dataProviderService.validateAccount(request);

        assertThat(response.getValidationResponses().size(), is(3));
        assertThat(response.getValidationResponses().get(0).getProvider(), is("test1"));
        assertThat(response.getValidationResponses().get(1).getProvider(), is("test2"));
        assertThat(response.getValidationResponses().get(2).getProvider(), is("test3"));
    }
}
