package com.anil.microservices.currencyexcahngeservice.resource;

import com.anil.microservices.currencyexcahngeservice.model.ExchangeValue;
import com.anil.microservices.currencyexcahngeservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment env;
    @Autowired
    private ExchangeValueRepository exhValRep;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){

        ExchangeValue exch= exhValRep.findByFromAndTo(from,to);
        exch.setPort(Integer.parseInt(env.getProperty("server.port")));
        return exch;
    }
}
