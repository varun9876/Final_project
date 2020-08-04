package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.IpoDTO;
import com.example.demo.service.IpoService;

@RestController
public class IpoController {
	
	@Autowired
	IpoService iService;
	
	@RequestMapping(value="/Ipo")
	Iterable<IpoDTO> getAll(){
		return iService.getAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/Ipo/{id}")
	IpoDTO getIpoById(@PathVariable int id)
	{
		return iService.getIpoById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/Ipo/{id}")
	void updateIpo(@RequestBody IpoDTO ipoDto , @PathVariable int id)
	{
		iService.updateIpo(ipoDto,id);
	}
	
	@PostMapping(value="/Ipo")
	void insertIpo(@RequestBody IpoDTO ipoDto)
	{
		iService.insertIpo(ipoDto);
	
}
	@RequestMapping(method=RequestMethod.GET,value="/Ipo/name/{cname}")
	IpoDTO getIPODetailBycName(@PathVariable String cname)
	{
		return iService.getIPODetailBycName(cname);
	}
		
	@DeleteMapping(value="/Ipo/{id}")
	void deleteIpo(@PathVariable int id)
	{
		iService.deleteIpo(id);
	}
	


}
