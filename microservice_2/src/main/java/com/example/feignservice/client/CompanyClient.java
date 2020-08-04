package com.example.feignservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.feignservice.dto.CompanyDTO;

@FeignClient("company")
public interface CompanyClient {
	
	@GetMapping(value= "/Company/{id}")
	public CompanyDTO getCompany(@PathVariable int id);
	
	@GetMapping(value="/Company/pattern/{pattern}")
	public Iterable<CompanyDTO> getCompanyByPattern(@PathVariable String pattern);

}
