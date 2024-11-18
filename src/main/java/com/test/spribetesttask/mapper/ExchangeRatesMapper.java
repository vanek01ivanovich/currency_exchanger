package com.test.spribetesttask.mapper;

import com.test.spribetesttask.dto.ExchangeRatesRsDto;
import com.test.spribetesttask.entity.ExchangeRateEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExchangeRatesMapper {

  ExchangeRatesMapper INSTANCE = Mappers.getMapper(ExchangeRatesMapper.class);


  @Mapping(target = "id", ignore = true)
  ExchangeRateEntity toExchangeRateEntity(ExchangeRatesRsDto exchangeRatesRsDto);


}
