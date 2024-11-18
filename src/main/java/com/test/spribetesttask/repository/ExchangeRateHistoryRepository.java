package com.test.spribetesttask.repository;

import com.test.spribetesttask.entity.ExchangeRateHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateHistoryRepository extends JpaRepository<ExchangeRateHistoryEntity, Long> {

}
