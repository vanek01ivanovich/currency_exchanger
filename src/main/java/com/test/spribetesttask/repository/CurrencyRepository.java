package com.test.spribetesttask.repository;

import com.test.spribetesttask.entity.CurrencyEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Long> {

  Optional<CurrencyEntity> findByCurrencyName(String currencyName);

  List<CurrencyEntity> findAllByValidIsTrue();

}
