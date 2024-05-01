package com.yhm.smt.service;


import com.yhm.smt.dto.SaleDto;
import com.yhm.smt.entity.Product;
import com.yhm.smt.entity.Sale;
import com.yhm.smt.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductService productService;
    private final StockOnhandService stockOnhandService;

    public Page<Sale> findAllSales(Pageable pageable) {
        return saleRepository.findByIsSale(true, pageable);
    }

    public Page<Sale> findAllBuys(Pageable pageable) {
        return saleRepository.findByIsSale(false, pageable);
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
                        .isSale(sale.isSale())
                        .createdAt(sale.getAdjustmentDate())
                        .build()
        );
        stockOnhandService.update(sale.toStockEvent());
    }


    @Transactional
    public void save(List<SaleDto> sales) {
        for (SaleDto sale : sales) {
            save(sale);
        }
    }
}
