package com.test.spribetesttask.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "ExchangeRate")
@Table(name = "ExchangeRates", schema = "CurrencyExchangeRate")
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "exchangeRateHistory")
@EqualsAndHashCode(exclude = "exchangeRateHistory")
public class ExchangeRateEntity {

  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "Currency", nullable = false)
  private String currency;

  @Column(name = "Rate", nullable = false)
  private BigDecimal rate;

  @Column(name = "BaseCurrency", nullable = false)
  private String baseCurrency;

  @Column(name = "RateDate", nullable = false)
  private Instant rateDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_RateHistoryResponseId", referencedColumnName = "ID", nullable = false)
  private ExchangeRateHistoryEntity exchangeRateHistory;

}
