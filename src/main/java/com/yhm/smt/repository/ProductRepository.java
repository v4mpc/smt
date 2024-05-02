package com.yhm.smt.repository;

import com.yhm.smt.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findByNameContainingIgnoreCaseOrderByNameAsc(String name, Pageable pageable);
}
