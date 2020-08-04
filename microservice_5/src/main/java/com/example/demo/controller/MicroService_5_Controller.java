package com.example.demo.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.client.CompanyClient;
import com.example.demo.client.StockExchangeClient;
import com.example.demo.client.StockPriceClient;
import com.example.demo.dto.CompanyDTO;
import com.example.demo.dto.StockExchangeDTO;
import com.example.demo.dto.StockPriceDTO;

public class MicroService_5_Controller {
	private StockExchangeClient seClient;
	private StockPriceClient spClient;
	private CompanyClient cClient;


	public MicroService_5_Controller(StockExchangeClient seClient, StockPriceClient spClient ) {
		
		this.seClient = seClient;
		this.spClient = spClient;

	}
	
	
	@GetMapping("/Stock-exchange")
	public ResponseEntity<Iterable<StockExchangeDTO>> getStockExchangeList() {
		return new ResponseEntity<>(seClient.getList(), HttpStatus.OK);
	}
	
	@GetMapping("/Stock-exchange/Company/{stockExchange}")
	public ResponseEntity<Iterable<CompanyDTO>> getStockExchangeCompanyList( @PathVariable String stockExchange) {
		List<CompanyDTO> s=new LinkedList<CompanyDTO>();  
		Iterable<StockPriceDTO> spDto = spClient.getListByStockExchange(stockExchange);
		for(StockPriceDTO spdto:spDto)
		{
			
			s.add(cClient.getCompanyByStockCode(spdto.getCompany_stock_code()));
		}
		
		return new ResponseEntity<>(s, HttpStatus.OK);
	}
	
	@PostMapping("/Stock-exchange")
	public ResponseEntity<Void> addStockExchange(@RequestBody StockExchangeDTO stockExchangeDto) {
		
		seClient.addStockExchange(stockExchangeDto);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}


}
