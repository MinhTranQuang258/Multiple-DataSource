package com.sps.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sps.vn.service.PersistenceService;

@RestController
public class TestController {

	@Autowired
	private PersistenceService persistenceService;
	
	@RequestMapping(value= "/test")
	@Transactional
	public void test() {
		try {
			persistenceService.saveCompany();
			persistenceService.saveEmployee();
		} catch (Exception e) {
			throw e;
		}
	}
	
}
