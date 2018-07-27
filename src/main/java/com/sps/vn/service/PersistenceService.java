package com.sps.vn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sps.vn.entities.first.Company;
import com.sps.vn.entities.second.Employee;
import com.sps.vn.repository.first.CompanyRepository;
import com.sps.vn.repository.second.EmployeeRepository;

@Service
public class PersistenceService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository; 
	
	@Transactional
	public void saveCompany() {
		Company company= new Company();
		company.setName("company");
		companyRepository.save(company);
	}
	
	@Transactional
	public void saveEmployee() {
		Employee employee= new Employee();
		employee.setName("employee");
		if(employee.getName().equals("employee")) {
			throw new RuntimeException();
		}
		employeeRepository.save(employee);
	}
}
