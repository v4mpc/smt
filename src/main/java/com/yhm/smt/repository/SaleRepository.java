package com.yhm.smt.repository;

import com.yhm.smt.entity.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

    Page<Sale> findByIsSale(boolean isSale, Pageable pageable);

}
