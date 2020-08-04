package com.example.feignservice.dto;

import lombok.Data;

@Data
public class StockPriceDTO {
	
	private long id;
	private String company_stock_code;
	private String stock_exchange;
	private Float current_price;
	private String date;
	private String time;

}
