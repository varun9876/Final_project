package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.StockExchangeDTO;


@FeignClient("stockexchange")
public interface StockExchangeClient {
	@GetMapping(value= "/Stock-exchange")
	public Iterable<StockExchangeDTO> getList();
	
	@PostMapping(value= "/Stock-exchange")
	public void addStockExchange(@RequestBody StockExchangeDTO stockExchangeDto);

}
