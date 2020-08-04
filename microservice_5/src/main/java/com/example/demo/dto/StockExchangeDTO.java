package com.example.demo.dto;

import lombok.Data;

@Data

public class StockExchangeDTO {
	
	private long id;
	private String stock_exchange;
	private String brief ;
	private String contact_address;
	private String remarks;

}
