package com.sds.apitodb.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sds.apitodb.domain.SidoDTO;

@Mapper
public interface SidoDAO {
	public void insertAll(List<SidoDTO> sidoList );
	
	public void delete();
}
