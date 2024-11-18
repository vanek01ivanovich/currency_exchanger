package com.test.spribetesttask.configuration.client;

import com.test.spribetesttask.configuration.properties.HttpClientConfigProperties;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.ConnectionKeepAliveStrategy;
import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactoryBuilder;
import org.apache.hc.client5.http.ssl.TrustAllStrategy;
import org.apache.hc.core5.http.HeaderElement;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.message.BasicHeaderElementIterator;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpClientConfiguration {

  @Bean
  public CloseableHttpClient httpClient(HttpClientConfigProperties httpClientConfigProperties) {
    RequestConfig requestConfig = RequestConfig.custom()
        .setConnectionRequestTimeout(
            Timeout.ofSeconds(httpClientConfigProperties.getRequestTimeout().toSeconds()))
        .build();
    return HttpClients.custom()
        .evictExpiredConnections()
        .evictIdleConnections(
            TimeValue.of(httpClientConfigProperties.getIdleConnectionWaitTime().toSeconds(),
                TimeUnit.SECONDS))
        .setDefaultRequestConfig(requestConfig)
        .build();
  }
}
