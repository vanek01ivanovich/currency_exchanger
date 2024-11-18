package com.test.spribetesttask.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.test.spribetesttask.deserializer.RateDtoDeserializer;
import java.math.BigDecimal;
import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRatesRsDto {

  @JsonProperty(value = "success")
  private Boolean success;
  @JsonProperty(value = "timestamp")
  private BigDecimal timestamp;
  @JsonProperty(value = "base")
  private String base;
  @JsonProperty(value = "date")
  private String date;
  @JsonProperty(value = "rates")
  @JsonDeserialize(using = RateDtoDeserializer.class)
  private HashMap<String, BigDecimal> rates;

}
