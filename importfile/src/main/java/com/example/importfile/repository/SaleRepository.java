package com.example.importfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.importfile.model.Sale;

@Repository
@Transactional
public interface SaleRepository extends JpaRepository<Sale, Long>{
	
}
