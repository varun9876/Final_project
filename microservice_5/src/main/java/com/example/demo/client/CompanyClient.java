package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.CompanyDTO;

@FeignClient("company")

public interface CompanyClient {
	

	@GetMapping(value= "/Company/company_stock_code/{company_stock_code}")
	public CompanyDTO getCompanyByStockCode(@PathVariable String stockCode);

}
