package com.sps.vn.repository.first;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sps.vn.entities.Company;

@Transactional
public interface CompanyRepository extends CrudRepository<Company, Long>{

}
