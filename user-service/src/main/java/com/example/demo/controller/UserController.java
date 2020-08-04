package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.UserEntity;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService uService;
	
	@RequestMapping(value="/User")
	Iterable<UserDTO> getAll(){
		return uService.getAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/User/{id}")
	UserDTO getUserById(@PathVariable int id)
	{
		return uService.getUserById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/User/{id}")
	void updateUser(@RequestBody UserDTO userDto , @PathVariable int id)
	{
		uService.updateUser(userDto,id);
	}
	
	@PostMapping(value="/User")
	void insertUser(@RequestBody UserDTO userDto)
	{
		uService.insertUser(userDto);
	
}
	
	@DeleteMapping(value="/User/{id}")
	void deleteUser(@PathVariable int id)
	{
		uService.deleteUser(id);
	}
	
	
	@RequestMapping(value="/User/{user_name}",method = RequestMethod.GET)
	public UserEntity getUser(@PathVariable String userName)
	{
		return uService.getUser(userName);
	}


}
