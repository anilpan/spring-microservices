package com.anil.microservices.currencyexcahngeservice.repository;

import com.anil.microservices.currencyexcahngeservice.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long> {
    ExchangeValue findByFromAndTo(String from,String to);
}
