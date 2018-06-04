/*
 * Class: TestController
 *
 * Created on Jun 4, 2018
 *
 * (c) Copyright Swiss Post Solution, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package com.sps.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sps.vn.entities.Company;
import com.sps.vn.repository.CompanyRepository;

@RestController
public class TestController {

    @Autowired
    private CompanyRepository companyRepository;
    
    
    @RequestMapping(value= "/test")
    public void test() {
        Company company= new Company();
        company.setName("sps");
        companyRepository.save(company);
    }
    
}
