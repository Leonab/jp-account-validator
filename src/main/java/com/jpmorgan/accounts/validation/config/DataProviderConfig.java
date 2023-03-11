package com.jpmorgan.accounts.validation.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "jpmorgan.data", ignoreUnknownFields = false)
@Data
public class DataProviderConfig {

    private List<Provider> providers;
}
