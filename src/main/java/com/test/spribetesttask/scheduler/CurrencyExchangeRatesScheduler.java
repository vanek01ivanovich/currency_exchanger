package com.test.spribetesttask.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@Configuration
@RequiredArgsConstructor
@ConditionalOnProperty(name = "job.exchange-rates.enabled", matchIfMissing = true)
public class CurrencyExchangeRatesScheduler {


  @Scheduled(fixedDelayString = "")
  public void execute() {


  }

}
