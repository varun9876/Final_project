package com.example.demo.service;

import com.example.demo.dto.IpoDTO;
import com.example.demo.model.IpoEntity;

import net.bytebuddy.dynamic.DynamicType.Builder.RecordComponentDefinition.Optional;

public interface IpoService {
	public Iterable <IpoDTO> getAll();
	public IpoDTO getIpoById(int id);
	public void updateIpo(IpoDTO dto,int id);
	public void insertIpo(IpoDTO dto);
	public void deleteIpo(int id);
	public IpoDTO getIPODetailBycName(String cname);

}
