package com.example.demo.dto;

import lombok.Data;

@Data
public class CompanyDTO {
	
	private long id;
	private String company_name;
	private Float turnover;
	private String bod;
	private String listed_stock;
	private String sector;
	private String breif_writing;
	private String company_stock_code;


}
