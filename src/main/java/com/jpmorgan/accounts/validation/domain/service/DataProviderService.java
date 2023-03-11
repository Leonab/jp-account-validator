package com.jpmorgan.accounts.validation.domain.service;

import com.jpmorgan.accounts.validation.config.DataProviderConfig;
import com.jpmorgan.accounts.validation.config.Provider;
import com.jpmorgan.accounts.validation.domain.model.AccountValidationRequest;
import com.jpmorgan.accounts.validation.domain.model.AccountValidationResponse;
import com.jpmorgan.accounts.validation.domain.model.ValidationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
@Slf4j
public class DataProviderService {

    private final DataProviderConfig providerConfig;

    public AccountValidationResponse validateAccount(AccountValidationRequest request) {
        var accountNumber = request.getAccountNumber();
        var providers = Optional.ofNullable(request.getProviders())
                .filter(x -> !x.isEmpty())
                .orElseGet(this::getDefaultProviderNames);

        var validationResponses = providers.stream()
                .map(this::makeHttpCallToProvider)
                .filter(Objects::nonNull)
                .toList();

        return new AccountValidationResponse(validationResponses);
    }

    private List<String> getDefaultProviderNames() {
        return this.providerConfig.getProviders().stream()
                .map(Provider::getName)
                .toList();
    }

    // simulating external call
    private ValidationResponse makeHttpCallToProvider(String provider) {
        try {
            var valid = this.getRandomBoolean(); // assigned randomly
            log.info(String.format("Response for provider %s is %s", provider, valid));
            return new ValidationResponse(provider, valid);
        } catch (Exception ex) {
            log.error("Something went wrong!!", ex);
        }
        return null;
    }

    private Boolean getRandomBoolean() {
        var random = ThreadLocalRandom.current();
        var randomNumber = random.nextInt(1, 11); // random between 1-10
        return randomNumber <= 5;
    }
}
