package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CompanyDTO;
import com.example.demo.service.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	CompanyService cService;
	
	@RequestMapping(value="/Company")
	Iterable<CompanyDTO> getAll(){
		return cService.getAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/Company/{id}")
	CompanyDTO getCompanyById(@PathVariable int id)
	{
		return cService.getCompanyById(id);
	}
	@RequestMapping(method=RequestMethod.GET,value="/Company/pattern/{pattern}")
	Iterable<CompanyDTO> getCompanyBycName(@PathVariable String pattern){
		return cService.getCompanyBycName(pattern);
	}

	@RequestMapping(method=RequestMethod.GET,value="/Company/company_stock_code/{company_stock_code}")
	CompanyDTO getCompanyByStockCode(@PathVariable String stockCode)
	{
		return cService.getCompanyByStockCode(stockCode);
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/Company/sector/{sector}")
	Iterable<CompanyDTO> getCompanyBySector(@PathVariable String sector)
	{
		return cService.getCompanyBySector(sector);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/Company/{id}")
	void updateCompany(@RequestBody CompanyDTO companyDto , @PathVariable int id)
	{
		cService.updateCompany(companyDto,id);
	}
	
	@PostMapping(value="/Company")
	void insertCompany(@RequestBody CompanyDTO companyDto)
	{
		cService.insertCompany(companyDto);
	
}
	
	@DeleteMapping(value="/Company/{id}")
	void deleteCompany(@PathVariable int id)
	{
		cService.deleteCompany(id);
	}
	
	
	

}