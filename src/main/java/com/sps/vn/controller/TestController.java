package com.sps.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sps.vn.entities.Company;
import com.sps.vn.repository.first.CompanyRepository;

@RestController
public class TestController {

	@Autowired
	private CompanyRepository companyRepository;
	
	@RequestMapping(value= "/test")
	public void test() {
		System.out.println("Test");
		Company company= new Company();
		company.setName("SPS");
		companyRepository.save(company);
	}
	
}
