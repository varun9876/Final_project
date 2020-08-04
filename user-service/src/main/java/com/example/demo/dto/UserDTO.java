package com.example.demo.dto;
import lombok.Data;
@Data

public class UserDTO {
	private long id;
	private String user_name;
	private String password;
	private String user_type;
	private String email;
	private String mobile_number;
	private boolean confirmed;

}
