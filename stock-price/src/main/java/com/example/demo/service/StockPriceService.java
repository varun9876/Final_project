package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.StockPriceDTO;

public interface StockPriceService {
	
	public Iterable <StockPriceDTO> getAll();
	public StockPriceDTO getStockPriceById(int id);
	public void updateStockPrice(StockPriceDTO dto,int id);
	public void insertStockPrice(StockPriceDTO dto);
	public void deleteStockPrice(int id);
	public void uploadExcel(MultipartFile file);
}
