package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.UserEntity;

public interface UserService{
	
	public Iterable <UserDTO> getAll();
	public UserDTO getUserById(int id);
	public void updateUser(UserDTO dto,int id);
	public void insertUser(UserDTO dto);
	public void deleteUser(int id);
	public UserEntity getUser(String userName);

}
