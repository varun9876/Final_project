package com.example.demo.service;

import com.example.demo.dto.CompanyDTO;

public interface CompanyService {
	
	public Iterable <CompanyDTO> getAll();
	public CompanyDTO getCompanyById(int id);
	public void updateCompany(CompanyDTO dto,int id);
	public void insertCompany(CompanyDTO dto);
	public void deleteCompany(int id);
	public Iterable<CompanyDTO> getCompanyBycName(String pattern);
	public CompanyDTO getCompanyByStockCode(String stockCode);
	public Iterable<CompanyDTO> getCompanyBySector(String sector);
	

}
