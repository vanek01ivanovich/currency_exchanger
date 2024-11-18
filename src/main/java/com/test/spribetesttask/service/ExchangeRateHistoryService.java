package com.test.spribetesttask.service;

import com.test.spribetesttask.entity.ExchangeRateEntity;
import com.test.spribetesttask.entity.ExchangeRateHistoryEntity;
import java.util.List;

public interface ExchangeRateHistoryService {

  void addExchangeRateHistory(ExchangeRateHistoryEntity exchangeRateHistoryEntity);

  List<ExchangeRateEntity> getAllExchangeRatesHistory();

}
