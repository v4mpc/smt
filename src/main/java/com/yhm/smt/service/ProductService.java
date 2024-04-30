package com.yhm.smt.service;


import com.yhm.smt.entity.Product;
import com.yhm.smt.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public void save(Product product){
        productRepository.save(product);
    }
}
