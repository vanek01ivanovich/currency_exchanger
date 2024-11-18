package com.test.spribetesttask.service.impl;

import com.test.spribetesttask.entity.ExchangeRateEntity;
import com.test.spribetesttask.entity.ExchangeRateHistoryEntity;
import com.test.spribetesttask.repository.ExchangeRateHistoryRepository;
import com.test.spribetesttask.service.ExchangeRateHistoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeRateHistoryServiceImpl implements ExchangeRateHistoryService {

  private final ExchangeRateHistoryRepository exchangeRateHistoryRepository;

  @Override
  public void addExchangeRateHistory(ExchangeRateHistoryEntity exchangeRateHistoryEntity) {
    exchangeRateHistoryRepository.save(exchangeRateHistoryEntity);
  }

  @Override
  public List<ExchangeRateEntity> getAllExchangeRatesHistory() {
    return null;
  }
}
