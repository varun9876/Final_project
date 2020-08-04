package com.example.demo.service;
import java.util.Optional;

import com.example.demo.dao.IpoRepository;
import com.example.demo.dto.IpoDTO;
import com.example.demo.model.IpoEntity;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class IpoServiceImpl implements IpoService 
{

	@Autowired
	IpoRepository iRepo;
	
	ModelMapper mapper=new ModelMapper();
	
  
	
	public Iterable <IpoDTO> getAll()
	{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

	java.lang.reflect.Type targetListType = new TypeToken<Iterable<IpoDTO>>() {}.getType();
		  return mapper.map(iRepo.findAll(),targetListType);
		
	}
	
	public IpoDTO getIPODetailBycName(String cname)
	{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		  return mapper.map(iRepo.findBycName(cname),IpoDTO.class);
		
	}
	public IpoDTO getIpoById(int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(iRepo.findById(id).get(),IpoDTO.class);
	}
	
	public void insertIpo(IpoDTO ipoDto)
	{
		iRepo.save(mapper.map(ipoDto,IpoEntity.class));
	}
	
	public void updateIpo(IpoDTO ipoDto,int id)
	{
		iRepo.save(mapper.map(ipoDto,IpoEntity.class));
	}
	
	public void deleteIpo(int id)
	{
		iRepo.deleteById(id);
	}

}
