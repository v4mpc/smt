package com.yhm.smt.repository;

import com.yhm.smt.entity.Product;
import com.yhm.smt.entity.StockOnhand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockOnhandRepository extends JpaRepository<StockOnhand,Integer> {
    Optional<StockOnhand> findFirstByProductIdOrderByCreatedAtDesc(int productId);
}
