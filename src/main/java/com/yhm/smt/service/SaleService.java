package com.yhm.smt.service;


import com.yhm.smt.entity.Sale;
import com.yhm.smt.exception.ResourceNotFoundException;
import com.yhm.smt.repository.SaleRepository;
import com.yhm.smt.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;

    public Page<Sale> findAll(Pageable pageable) {
        return saleRepository.findAll(pageable);
    }

    public void save(Sale sale) {
        saleRepository.save(sale);
    }


    public Sale update(Sale sale, int id) {
        Sale updateSale = saleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sale not exist with id " + id));
        updateSale.setProductName(sale.getProductName());
        updateSale.setBuyPrice(sale.getBuyPrice());
        updateSale.setSalePrice(sale.getSalePrice());
        updateSale.setQuantity(sale.getQuantity());
        updateSale.setCreatedAt(sale.getCreatedAt());
        updateSale.setDescription(sale.getDescription());
        saleRepository.save(updateSale);
        return updateSale;
    }
}
