package com.yhm.smt.controller;


import com.yhm.smt.entity.Product;
import com.yhm.smt.exception.ResourceNotFoundException;
import com.yhm.smt.repository.ProductRepository;
import com.yhm.smt.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(path = {"/products"})
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;

    @GetMapping
    public Page<Product> getAllProducts(Pageable pageable) {
        return productService.findAll(pageable);
    }

    @PostMapping
    public void save(@Valid @RequestBody Product product) {
        productService.save(product);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> update(@PathVariable int id, @RequestBody Product product) {
        Product updateProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not exist with id " + id));
        updateProduct.setName(product.getName());
        updateProduct.setBuyPrice(product.getBuyPrice());
        updateProduct.setSalePrice(product.getSalePrice());
        updateProduct.setUnitOfMeasure(product.getUnitOfMeasure());
        updateProduct.setActive(product.getActive());
        updateProduct.setDescription(product.getDescription());
        productRepository.save(updateProduct);
        return ResponseEntity.ok(updateProduct);
    }
}
