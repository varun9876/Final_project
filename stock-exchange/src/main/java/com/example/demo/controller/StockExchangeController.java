package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StockExchangeDTO;
import com.example.demo.service.StockExchangeService;

@RestController
public class StockExchangeController {
	
	@Autowired
	StockExchangeService cService;
	
	@RequestMapping(value="/Stock-exchange")
	Iterable<StockExchangeDTO> getAll(){
		return cService.getAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/Stock-exchange/{id}")
	StockExchangeDTO getStockExchangeById(@PathVariable int id)
	{
		return cService.getStockExchangeById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/Stock-exchange/{id}")
	void updateStockExchange(@RequestBody StockExchangeDTO companyDto , @PathVariable int id)
	{
		cService.updateStockExchange(companyDto,id);
	}
	
	@PostMapping(value="/Stock-exchange")
	void insertCompany(@RequestBody StockExchangeDTO companyDto)
	{
		cService.insertStockExchange(companyDto);
	
}
	
	@DeleteMapping(value="/Stock-exchange/{id}")
	void deleteStockExchange(@PathVariable int id)
	{
		cService.deleteStockExchange(id);
	}


}
