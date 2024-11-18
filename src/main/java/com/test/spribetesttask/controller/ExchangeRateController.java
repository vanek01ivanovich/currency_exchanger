package com.test.spribetesttask.controller;


import static org.springframework.http.HttpStatus.OK;

import com.test.spribetesttask.dto.ExchangeRatesRsDto;
import com.test.spribetesttask.service.ExchangeRateService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/exchange")
public class ExchangeRateController {

  private final ExchangeRateService exchangeRateService;

  /*todo
  *  Controller with next logic:
  *  1. Get Endpoint that return all exchange Rates for then input currency
  *  2. After adding new currency manual trigger (GET endpoint) to exchange rate for currency*/

  @GetMapping
  public ResponseEntity<Void> exchange(){
    ExchangeRatesRsDto exchangeRateFromApi = exchangeRateService.getExchangeRateFromApi();
    return new ResponseEntity<>(OK);
  }

}
