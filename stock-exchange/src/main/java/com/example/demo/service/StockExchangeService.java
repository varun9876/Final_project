package com.example.demo.service;

import com.example.demo.dto.StockExchangeDTO;

public interface StockExchangeService {
	
	public Iterable <StockExchangeDTO> getAll();
	public StockExchangeDTO getStockExchangeById(int id);
	public void updateStockExchange(StockExchangeDTO dto,int id);
	public void insertStockExchange(StockExchangeDTO dto);
	public void deleteStockExchange(int id);

}
