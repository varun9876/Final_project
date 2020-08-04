package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
@Entity
@Table(name="ipo")

public class IpoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name ="company_name")
	private String company_name;
	@Column(name ="stock_exchange")
	private String stock_exchange;
	@Column(name ="price_per_share")
	private String price_per_share;
	@Column(name ="total_share")
	private String total_share;
	@Column(name ="date_time")
	private String date_time;
	@Column(name ="remarks")
	private String remarks ;
	

}
