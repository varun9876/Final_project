package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
@Entity
@Table(name="stockprice")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPriceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name ="company_stock_code")
	private String company_stock_code;
	@Column(name ="stock_exchange")
	private String stock_exchange;
	@Column(name ="current_price")
	private Float current_price;
	@Column(name ="date")
	private Date date;
	@Column(name ="time")
	private Time time;

}
