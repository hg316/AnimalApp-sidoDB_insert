package com.sds.apitodb.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sds.apitodb.domain.SidoDTO;
import com.sds.apitodb.domain.SignguDTO;
import com.sds.apitodb.model.SidoApiService;
import com.sds.apitodb.model.SidoService;
import com.sds.apitodb.model.SignguApiService;
import com.sds.apitodb.model.SignguService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

	@Autowired
	SidoApiService sidoApiService;

	@Autowired
	SignguApiService signguApiService;

	@Autowired
	SidoService sidoService;

	@Autowired
	SignguService signguService;

	@GetMapping("/")
	public String getMain(Model model) {
		return "main/index";
	}

	@GetMapping("/call/sido")
	public String getCallSido(Model model) throws IOException {
		
		signguService.delete();
		sidoService.delete();
		
		List<SidoDTO> sidoList = sidoApiService.call();

		sidoService.insertAll(sidoList);
		
		
		
		for (SidoDTO sido : sidoList) {
			log.info("시도코드=="+sido.getOrgCd());
			List<SignguDTO> signguList = signguApiService.call(sido.getOrgCd());
			if(signguList != null) {
				log.info("시군구코드=="+signguList.get(0).getOrgCd());
				signguService.insertAll(signguList);
			}
		}

		return "main/index";
	}
}
