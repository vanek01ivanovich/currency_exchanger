package com.test.spribetesttask.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("fixer")
public class FixerApiProperties {

  private String url;
  private String apiKey;

}
