package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
@Entity
@Table(name="user")

public class UserEntity {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name ="user_name")
	private String user_name;
	@Column(name ="password")
	private String password;
	@Column(name ="user_type")
	private String user_type;
	@Column(name ="email")
	private String email;
	@Column(name ="mobile_number")
	private String mobile_number;
	@Column(name ="confirmed")
	private boolean confirmed ;
	

}
