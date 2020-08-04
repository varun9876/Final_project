package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.CompanyEntity;

import net.bytebuddy.dynamic.DynamicType.Builder.RecordComponentDefinition.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity,Integer> {

	public Iterable<CompanyEntity> findBycNameContaining(String pattern);
	public Iterable<CompanyEntity> findBySector(String sector);
	public Optional<CompanyEntity> findByStockCode(String stockCode);
}
