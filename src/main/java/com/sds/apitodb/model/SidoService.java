package com.sds.apitodb.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.apitodb.domain.SidoDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SidoService {
	
	@Autowired
	SidoDAO sidoDAO;
	
	public void insertAll(List<SidoDTO> sidoList ) {
		sidoDAO.insertAll(sidoList);
	}
	
	public void delete() {
		sidoDAO.delete();
	}
}
