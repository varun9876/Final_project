package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StockExchangeEntity;

@Repository
public interface StockExchangeRepository extends CrudRepository<StockExchangeEntity,Integer> {

}
