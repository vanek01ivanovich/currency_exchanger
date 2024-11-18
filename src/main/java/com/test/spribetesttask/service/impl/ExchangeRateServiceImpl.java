package com.test.spribetesttask.service.impl;

import com.test.spribetesttask.configuration.properties.FixerApiProperties;
import com.test.spribetesttask.dto.ExchangeRatesRsDto;
import com.test.spribetesttask.entity.ExchangeRateEntity;
import com.test.spribetesttask.repository.ExchangeRateRepository;
import com.test.spribetesttask.service.ExchangeRateService;
import com.test.spribetesttask.util.FixerApiUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

  private final RestTemplate restTemplate;
  private final FixerApiProperties fixerApiProperties;
  private final ExchangeRateRepository exchangeRateRepository;

  @Override
  public ExchangeRatesRsDto getExchangeRateFromApi(String baseCurrency) {
    try {
      var url = FixerApiUtil.buildAccessKeyWithBaseCurrencyUrl(fixerApiProperties.getUrl(),
          fixerApiProperties.getApiKey(), baseCurrency);
      return callApiToGetExchangeRates(url);
    } catch (Exception exception) {
      throw new RuntimeException("Unable to receive exchange rate due to exception ", exception);
    }
  }

  @Override
  public ExchangeRatesRsDto getExchangeRateFromApi() {
    try {
      var url = FixerApiUtil.buildAccessKeyUrl(fixerApiProperties.getUrl(),
          fixerApiProperties.getApiKey());
      return callApiToGetExchangeRates(url);
    } catch (Exception exception) {
      throw new RuntimeException("Unable to receive exchange rate due to exception ", exception);
    }
  }

  @Override
  @Transactional
  public void saveAll(List<ExchangeRateEntity> exchangeRateEntities) {
    exchangeRateRepository.saveAll(exchangeRateEntities);
  }

  private ExchangeRatesRsDto callApiToGetExchangeRates(String url) {
    return restTemplate.exchange(
        url,
        HttpMethod.GET,
        new HttpEntity<>(new HttpHeaders()),
        ExchangeRatesRsDto.class).getBody();
  }
}
