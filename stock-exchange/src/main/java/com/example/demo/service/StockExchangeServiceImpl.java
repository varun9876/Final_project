package com.example.demo.service;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StockExchangeRepository;
import com.example.demo.dto.StockExchangeDTO;
import com.example.demo.model.StockExchangeEntity;

@Service
public class StockExchangeServiceImpl implements StockExchangeService {
	
	@Autowired
	StockExchangeRepository seRepo;
	
	ModelMapper mapper=new ModelMapper();
	
  
	
	public Iterable <StockExchangeDTO> getAll()
	{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
	java.lang.reflect.Type targetListType = new TypeToken<Iterable<StockExchangeDTO>>() {}.getType();
		  return mapper.map(seRepo.findAll(),targetListType);
		
	}
	
	public StockExchangeDTO getStockExchangeById(int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(seRepo.findById(id).get(),StockExchangeDTO.class);
	}
	
	public void insertStockExchange(StockExchangeDTO stockDto)
	{
		seRepo.save(mapper.map(stockDto,StockExchangeEntity.class));
	}
	
	public void updateStockExchange(StockExchangeDTO stockDto,int id)
	{
		seRepo.save(mapper.map(stockDto,StockExchangeEntity.class));
	}
	
	public void deleteStockExchange(int id)
	{
		seRepo.deleteById(id);
	}


}
