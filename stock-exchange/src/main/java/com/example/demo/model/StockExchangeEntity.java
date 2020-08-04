package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
@Entity
@Table(name="stockexchange")

public class StockExchangeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name ="stock_exchange")
	private String stock_exchange;
	@Column(name ="brief")
	private String brief;
	@Column(name ="contact_address")
	private String contact_adress;
	@Column(name ="remarks")
	private String remarks;
	

}
