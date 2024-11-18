package com.test.spribetesttask.controller;


import static io.restassured.RestAssured.with;
import static wiremock.org.eclipse.jetty.http.HttpStatus.OK_200;

import com.test.spribetesttask.SpribeTestTaskSpringBootTest;
import com.test.spribetesttask.configuration.properties.FixerApiProperties;
import com.test.spribetesttask.mock.ExchangeRatesApiMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;

class ExchangeRateEntityControllerTest extends SpribeTestTaskSpringBootTest {

  @LocalServerPort
  private int randomServerPort;
  @Autowired
  private FixerApiProperties fixerApiProperties;

  @Test
  void shouldSuccessFullyReturnExchangeRates(){
    ExchangeRatesApiMock.initSuccessMock(fixerApiProperties.getApiKey());
    with()
        .port(randomServerPort)
        .when()
        .get("/exchange")
        .then()
        .log().all()
        .assertThat()
        .statusCode(OK_200);
  }
}
