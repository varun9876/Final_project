package com.example.feignservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.feignservice.dto.StockPriceDTO;

@FeignClient("stockprice")
public interface StockPriceClient {
	
	@GetMapping(value= "/Stock-price/date/{date1}/{date2}/{cCode}")
	public Iterable<StockPriceDTO> getStockPriceByDate(@PathVariable String date1,@PathVariable String date2,@PathVariable String cCode);

}
