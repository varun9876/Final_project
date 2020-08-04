package com.example.demo.service;
import java.util.Optional;
import com.example.demo.dto.CompanyDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CompanyRepository;
import com.example.demo.model.CompanyEntity;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	CompanyRepository cRepo;
	
	ModelMapper mapper=new ModelMapper();
	
  
	
	public Iterable <CompanyDTO> getAll()
	{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
	java.lang.reflect.Type targetListType = new TypeToken<Iterable<CompanyDTO>>() {}.getType();
		  return mapper.map(cRepo.findAll(),targetListType);
		
	}
	
	public CompanyDTO getCompanyById(int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(cRepo.findById(id).get(),CompanyDTO.class);
	}
	
	public void insertCompany(CompanyDTO companyDto)
	{
		cRepo.save(mapper.map(companyDto,CompanyEntity.class));
	}
	
	public void updateCompany(CompanyDTO companyDto,int id)
	{
		cRepo.save(mapper.map(companyDto,CompanyEntity.class));
	}
	
	public void deleteCompany(int id)
	{
		cRepo.deleteById(id);
	}
	public Iterable<CompanyDTO> getCompanyBycName(String pattern)
	{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
	java.lang.reflect.Type targetListType = new TypeToken<Iterable<CompanyDTO>>() {}.getType();
		  return mapper.map(cRepo.findBycNameContaining(pattern),targetListType);
		
	}

	public CompanyDTO getCompanyByStockCode(String stockCode)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(cRepo.findByStockCode(stockCode),CompanyDTO.class);
	}
	
	public Iterable<CompanyDTO> getCompanyBySector(String sector)
	{
		java.lang.reflect.Type targetListType = new TypeToken<Iterable<CompanyDTO>>() {}.getType();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(cRepo.findBySector(sector),targetListType);
	}

}
		


