package com.example.demo.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.IpoDTO;
import com.example.demo.model.IpoEntity;

import net.bytebuddy.dynamic.DynamicType.Builder.RecordComponentDefinition.Optional;

@Repository
public interface IpoRepository extends CrudRepository<IpoEntity,Integer> {
	public Optional<IpoEntity> findBycName(String cname);

	
}
