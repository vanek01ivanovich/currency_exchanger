package com.test.spribetesttask.service.facade;

import com.test.spribetesttask.entity.CurrencyEntity;
import com.test.spribetesttask.service.CurrencyService;
import com.test.spribetesttask.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CurrencyExchangeRatesFacade {

  private final CurrencyService currencyService;
  private final ExchangeRateService exchangeRateService;

  /*todo
   *  1. Get from CurrencyRepository all valid currency (1t service)
   *  2. Using restTemplate get list of currencies exchanges (2d service)
   *  3. Before saving fresh rates, using currencies from DB - need to clear old ExchangeRates (3d service)
   *  4. After need to save into ExchangeRateHistory table all the history (4h service)
   *  5. Parse rates from Json and save fresh into ExchangeRate*/

  @Transactional
  public void execute() {
    currencyService.getAllValidCurrencies().stream()
        .map(CurrencyEntity::getCurrencyName)
        .forEach(currency -> {
          var exchangeRatesRsDto = exchangeRateService.getExchangeRateFromApi(currency);
          /*todo implement logic above*/
        });
  }

}
