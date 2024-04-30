package com.yhm.smt.service;


import com.yhm.smt.entity.Product;
import com.yhm.smt.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
