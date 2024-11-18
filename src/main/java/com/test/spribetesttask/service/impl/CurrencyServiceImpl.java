package com.test.spribetesttask.service.impl;

import com.test.spribetesttask.entity.CurrencyEntity;
import com.test.spribetesttask.repository.CurrencyRepository;
import com.test.spribetesttask.service.CurrencyService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

  private final CurrencyRepository currencyRepository;

  @Override
  @Transactional
  public void addCurrency(String currencyName) {
    var currencyToSave = CurrencyEntity.builder()
        .currencyName(currencyName)
        .build();
    currencyRepository.save(currencyToSave);
  }

  @Override
  public CurrencyEntity getCurrency(String currencyName) {
    return currencyRepository.findByCurrencyName(currencyName)
        .orElseThrow(() -> new RuntimeException("Currency is not found in DB"));
  }

  @Override
  public List<CurrencyEntity> getAllCurrencies() {
    return currencyRepository.findAll();
  }

  @Override
  public List<CurrencyEntity> getAllValidCurrencies() {
    return currencyRepository.findAllByValidIsTrue();
  }

  @Override
  @Transactional
  public void invalidateCurrency(String currencyName) {
    currencyRepository.findByCurrencyName(currencyName)
        .map(currency -> {
          currency.setValid(false);
          return currencyRepository.save(currency);})
        .orElseThrow(() -> new RuntimeException("Currency is not found in DB"));
  }
}
