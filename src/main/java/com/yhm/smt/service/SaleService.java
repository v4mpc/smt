package com.yhm.smt.service;


import com.yhm.smt.domain.StockEvent;
import com.yhm.smt.domain.TransactionType;
import com.yhm.smt.dto.AdjustDto;
import com.yhm.smt.dto.SaleDto;
import com.yhm.smt.entity.Product;
import com.yhm.smt.entity.Sale;
import com.yhm.smt.exception.ResourceNotFoundException;
import com.yhm.smt.repository.SaleRepository;
import com.yhm.smt.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductService productService;
    private final StockOnhandService stockOnhandService;

    public Page<Sale> findAll(Pageable pageable) {
        return saleRepository.findAll(pageable);
    }

    @Transactional
    public void save(SaleDto sale) {
        Product dbProduct = productService.getProduct(sale.getProductId());
        saleRepository.save(
                Sale.
                        builder()
                        .saleAdjustment(sale.getSaleAdjustment())
                        .salePrice(dbProduct.getSalePrice())
                        .buyPrice(dbProduct.getBuyPrice())
                        .productName(dbProduct.getName())
                        .description(sale.getDescription())
                        .quantity(sale.getAdjustmentQuantity())
                        .createdAt(sale.getAdjustmentDate())
                        .build()
        );
        stockOnhandService.update(sale.toStockEvent());
    }
}
