package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.CompanyDTO;

@FeignClient("company")

public interface CompanyClient {

	@GetMapping(value= "/Company/sector/{sector}")
	public Iterable<CompanyDTO> getCompanyBySector(@PathVariable String sector);
}
