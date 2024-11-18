package com.test.spribetesttask.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "ExchangeRateHistory")
@Table(name = "ExchangeRateHistory", schema = "CurrencyExchangeRate")
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "exchangeRates")
@EqualsAndHashCode(exclude = "exchangeRates")
public class ExchangeRateHistoryEntity {

  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "Success", nullable = false)
  private Boolean success;

  @Column(name = "BaseCurrency", nullable = false)
  private String baseCurrency;

  @Column(name = "RateDate", nullable = false)
  private Instant rateDate;

  @Column(name = "Rates", nullable = false)
  private String rates;

  @OneToMany(
      orphanRemoval = true,
      fetch = FetchType.LAZY,
      mappedBy = "exchangeRateHistory",
      cascade = CascadeType.ALL
  )
  private Set<ExchangeRateEntity> exchangeRates;
}
