package com.sps.vn.repository.first;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sps.vn.entities.first.Company;

@Transactional
public interface CompanyRepository extends CrudRepository<Company, Long>{

}
