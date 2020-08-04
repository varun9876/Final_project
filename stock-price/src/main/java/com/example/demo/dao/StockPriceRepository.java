package com.example.demo.dao;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.StockPriceDTO;
import com.example.demo.model.StockPriceEntity;

@Repository
public interface StockPriceRepository extends CrudRepository<StockPriceEntity,Integer> {

	Iterable<StockPriceDTO> findAllByDateLessThanEqualAndDateGreaterThanEqualAndCompanyCode(Date sd,Date ed,String cCode);
	Iterable<StockPriceEntity> findAllByStockExchange(String stockExchange);
}
