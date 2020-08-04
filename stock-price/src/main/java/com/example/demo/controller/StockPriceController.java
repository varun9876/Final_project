package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.StockPriceDTO;
import com.example.demo.helper.ExcelHelper;
import com.example.demo.service.StockPriceService;

@RestController
public class StockPriceController {
	
	@Autowired
	StockPriceService cService;
	@PostMapping("/StockPrice/upload")
	  public void uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";

	    if (ExcelHelper.hasExcelFormat(file)) {
	      try {
	    	  cService.uploadExcel(file);

	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        System.out.println(message);
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        System.out.println(message);
	        
	      }
	    }

	    message = "Please upload an excel file!";
	    System.out.println(message);
	  }
	
	@RequestMapping(value="/Stock-price")
	Iterable<StockPriceDTO> getAll(){
		return cService.getAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/Stock-price/{id}")
	StockPriceDTO getStockPriceById(@PathVariable int id)
	{
		return cService.getStockPriceById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/Stock-price/{id}")
	void updateStockPrice(@RequestBody StockPriceDTO companyDto , @PathVariable int id)
	{
		cService.updateStockPrice(companyDto,id);
	}
	
	@PostMapping(value="/Stock-price")
	void insertStockPrice(@RequestBody StockPriceDTO companyDto)
	{
		cService.insertStockPrice(companyDto);
	
}
	
	@DeleteMapping(value="/Stock-price/{id}")
	void deleteStockPrice(@PathVariable int id)
	{
		cService.deleteStockPrice(id);
	}


}
