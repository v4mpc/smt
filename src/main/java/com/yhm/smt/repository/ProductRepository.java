package com.yhm.smt.repository;

import com.yhm.smt.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface ProductRepository extends ListPagingAndSortingRepository<Product,Integer> {
}
