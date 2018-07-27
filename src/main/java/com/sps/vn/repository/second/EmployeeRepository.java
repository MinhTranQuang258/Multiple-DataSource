package com.sps.vn.repository.second;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sps.vn.datasource.GeneralConfiguration;
import com.sps.vn.entities.second.Employee;

@Transactional(transactionManager= GeneralConfiguration.Second.TRANSACTION_MANAGER)
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
