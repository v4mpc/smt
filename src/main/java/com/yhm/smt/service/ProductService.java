package com.yhm.smt.service;


import com.yhm.smt.entity.Product;
import com.yhm.smt.exception.ResourceNotFoundException;
import com.yhm.smt.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product getProduct(int productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not exist with id " + productId));
    }


    public Product update(Product product, int id) {
        Product updateProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not exist with id " + id));
        updateProduct.setName(product.getName());
        updateProduct.setBuyPrice(product.getBuyPrice());
        updateProduct.setSalePrice(product.getSalePrice());
        updateProduct.setUnitOfMeasure(product.getUnitOfMeasure());
        updateProduct.setActive(product.getActive());
        updateProduct.setDescription(product.getDescription());
        productRepository.save(updateProduct);
        return updateProduct;
    }
}
