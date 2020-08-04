package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.CompanyClient;
import com.example.demo.dto.CompanyDTO;
@RestController
@RequestMapping("/microservice_3")

public class MicroService_3_Controller {
	
	private CompanyClient companyClient;


	public MicroService_3_Controller(CompanyClient companyClient ) {
		
		this.companyClient = companyClient;

	}
	
	@GetMapping("/Sector/{sector}")
	public ResponseEntity<Iterable<CompanyDTO>> getCompanyBySector(@PathVariable String sector) {
		return new ResponseEntity<>(companyClient.getCompanyBySector(sector), HttpStatus.OK);
	}


}
