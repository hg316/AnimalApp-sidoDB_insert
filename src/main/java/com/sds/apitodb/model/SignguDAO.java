package com.sds.apitodb.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sds.apitodb.domain.SidoDTO;
import com.sds.apitodb.domain.SignguDTO;

@Mapper
public interface SignguDAO {
	public void insertAll(List<SignguDTO> signguList );
	public void delete();
}
