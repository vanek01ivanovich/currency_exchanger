package com.test.spribetesttask.configuration.properties;

import java.time.Duration;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("http-client")
public class HttpClientConfigProperties {

  private Duration requestTimeout;
  private Duration idleConnectionWaitTime;

}
