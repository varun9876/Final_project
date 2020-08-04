package com.example.demo.service;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.StockPriceRepository;
import com.example.demo.dto.StockPriceDTO;
import com.example.demo.helper.ExcelHelper;
import com.example.demo.model.StockPriceEntity;


@Service
public class StockPriceServiceImpl implements StockPriceService {
	@Autowired
	StockPriceRepository spRepo;
	
	ModelMapper mapper=new ModelMapper();
	
  
	
	public Iterable <StockPriceDTO> getAll()
	{	  mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
	java.lang.reflect.Type targetListType = new TypeToken<Iterable<StockPriceDTO>>() {}.getType();
		  return mapper.map(spRepo.findAll(),targetListType);
		
	}
	public Iterable<StockPriceDTO> getByDateRange(String date1,String date2,String cCode)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		java.lang.reflect.Type targetListType = new TypeToken<Iterable<StockPriceDTO>>() {}.getType();
			  return mapper.map(spRepo.findAllByDateLessThanEqualAndDateGreaterThanEqualAndCompanyCode( Date.valueOf(date1),Date.valueOf(date2),cCode),targetListType);
	}
	
	
	public StockPriceDTO getStockPriceById(int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(spRepo.findById(id).get(),StockPriceDTO.class);
	}
	
	public void insertStockPrice(StockPriceDTO stockpriceDto)
	{
		spRepo.save(mapper.map(stockpriceDto,StockPriceEntity.class));
	}
	
	public void updateStockPrice(StockPriceDTO stockpriceDto,int id)
	{
		spRepo.save(mapper.map(stockpriceDto,StockPriceEntity.class));
	}
	
	public void deleteStockPrice(int id)
	{
		spRepo.deleteById(id);
	}

	public void uploadExcel(MultipartFile file) {
	    try {
	      List<StockPriceEntity> stockPrice = ExcelHelper.excelToTutorials(file.getInputStream());
	      spRepo.saveAll(stockPrice);
	    } catch (Exception e) {
	    	System.out.println("failed in service");
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }


}
