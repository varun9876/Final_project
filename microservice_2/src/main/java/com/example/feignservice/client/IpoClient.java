package com.example.feignservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.feignservice.dto.IpoDTO;


@FeignClient("ipodetails")
public interface IpoClient {
	
	@GetMapping(value= "/Ipo/name/{cname}")
	public IpoDTO getIPODetailByCompany(@PathVariable String cname);

}
