package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.StockPriceDTO;
@FeignClient("stockprice")
public interface StockPriceClient {
	
	@GetMapping(value= "/Stock-price/stock_exchange/{stock_exchange}")
	public Iterable<StockPriceDTO> getListByStockExchange(@PathVariable String stockExchange);

}
