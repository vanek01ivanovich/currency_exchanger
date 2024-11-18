package com.test.spribetesttask.service;

import com.test.spribetesttask.entity.CurrencyEntity;
import java.util.List;

public interface CurrencyService {

  void addCurrency(String currency);

  CurrencyEntity getCurrency(String currency);

  List<CurrencyEntity> getAllCurrencies();

  List<CurrencyEntity> getAllValidCurrencies();

  void invalidateCurrency(String currency);

}
