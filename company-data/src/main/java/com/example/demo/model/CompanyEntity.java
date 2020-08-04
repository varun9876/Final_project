package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
@Entity
@Table(name="company")
public class CompanyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name ="cname")
	private String company_name;
	@Column(name ="turnover")
	private Float turnover;
	@Column(name ="ceo")
	private String ceo;
	@Column(name ="bod")
	private String bod;
	@Column(name ="listed_stock")
	private String listed_stock;
	@Column(name ="sector")
	private String sector;
	@Column(name ="breif_writing")
	private String breif_writing;
	@Column(name ="company_stock_code")
	private String company_stock_code;
	

}
