package com.sds.apitodb.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.apitodb.domain.SignguDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SignguService {
	@Autowired
	SignguDAO signguDAO;
	
	public void insertAll(List<SignguDTO> signguList ) {
		signguDAO.insertAll(signguList);
	}
	public void delete() {
		signguDAO.delete();
	}
}
