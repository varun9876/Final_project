package com.example.feignservice.dto;

import lombok.Data;

@Data
public class IpoDTO {
	private long id;
	private String company_name;
	private String stock_exchange;
	private String price_per_share;
	private String total_share;
	private String date_time;
	private String remarks;

}
