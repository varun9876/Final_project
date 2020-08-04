package com.example.feignservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.feignservice.client.CompanyClient;
import com.example.feignservice.client.IpoClient;
import com.example.feignservice.client.StockPriceClient;
import com.example.feignservice.dto.CompanyDTO;
import com.example.feignservice.dto.IpoDTO;
import com.example.feignservice.dto.StockPriceDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value= "/feign")
public class Feignclientcontroller {
	
	private CompanyClient companyClient;
	private IpoClient ipoClient;
	private StockPriceClient spClient;

	public Feignclientcontroller(CompanyClient companyClient, IpoClient ipoClient, StockPriceClient spClient ) {
		
		this.companyClient = companyClient;
		this.ipoClient= ipoClient;
		this.spClient= spClient;
	}
	
	@GetMapping("/IPO/{cname}")
	public ResponseEntity<IpoDTO> getIPODetailBycName(@PathVariable String cname) {
		return new ResponseEntity<>(ipoClient.getIPODetailByCompany(cname), HttpStatus.OK);
	}
	
	@GetMapping("/Stock-price/{date1}/{date2}/{id}")
	public ResponseEntity<Iterable<StockPriceDTO>> getStockPriceByDate(@PathVariable String date1,@PathVariable String date2,@PathVariable int id) {
		
		return new ResponseEntity<>(spClient.getStockPriceByDate(date1, date2,companyClient.getCompany(id).getCompany_stock_code()), HttpStatus.OK);
	}
	
	
	@GetMapping("/pattern/{pattern}")
	@HystrixCommand(fallbackMethod= "defaultResponseDto")
	public ResponseEntity<Iterable<CompanyDTO>> getCompanyByPattern(@PathVariable String pattern) {
		return new ResponseEntity<>(companyClient.getCompanyByPattern(pattern), HttpStatus.OK);
	}
	
	
	
	@GetMapping("/{id}")
	@HystrixCommand(fallbackMethod= "defaultResponse")
	public ResponseEntity<CompanyDTO> getCompanyDetails(@PathVariable int id) {
		return new ResponseEntity<>(companyClient.getCompany(id), HttpStatus.OK);
	}

	// When we define a fallback-method, the fallback-method must match the same parameters of the method where you define the Hystrix Command using the hystrix-command annotation.
	public ResponseEntity<CompanyDTO> defaultResponse(int e) {
		System.out.println("You are seeing this fallback response because the underlying microservice is down.");
		String err = "Fallback error as the microservice is down.";
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public ResponseEntity<Iterable<CompanyDTO>> defaultResponseDto(String s) {
		System.out.println("You are seeing this fallback response because the underlying microservice is down.");
		String err = "Fallback error as the microservice is down.";
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
}