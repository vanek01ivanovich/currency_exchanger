package com.test.spribetesttask.service;

import com.test.spribetesttask.dto.ExchangeRatesRsDto;
import com.test.spribetesttask.entity.ExchangeRateEntity;
import java.util.List;

public interface ExchangeRateService {

  /*todo
  *  1. using RestTemplate get exchange for currency
  *  2. save fresh into it*/

  ExchangeRatesRsDto getExchangeRateFromApi();

  ExchangeRatesRsDto getExchangeRateFromApi(String baseCurrency);

  void saveAll(List<ExchangeRateEntity> exchangeRateEntities);

}
