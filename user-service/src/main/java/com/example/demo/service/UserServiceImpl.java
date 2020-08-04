package com.example.demo.service;
import java.util.Optional;
import com.example.demo.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.UserEntity;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository uRepo;
	
	ModelMapper mapper=new ModelMapper();
	
  
	
	public Iterable <UserDTO> getAll()
	{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
	java.lang.reflect.Type targetListType = new TypeToken<Iterable<UserDTO>>() {}.getType();
		  return mapper.map(uRepo.findAll(),targetListType);
		
	}
	
	public UserDTO getUserById(int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(uRepo.findById(id).get(),UserDTO.class);
	}
	
	public void insertUser(UserDTO userDto)
	{
		uRepo.save(mapper.map(userDto,UserEntity.class));
	}
	
	public void updateUser(UserDTO userDto,int id)
	{
		uRepo.save(mapper.map(userDto,UserEntity.class));
	}
	
	public void deleteUser(int id)
	{
		uRepo.deleteById(id);
	}

	public UserEntity getUser(String userName)
	{	
		UserEntity userEntity=uRepo.findByUserName(userName);

	    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	    return mapper.map(userEntity, UserEntity.class);
	    
	}
	

}
