package com.yhm.smt.service;

import com.yhm.smt.domain.TransactionType;
import com.yhm.smt.entity.Product;
import com.yhm.smt.entity.StockOnhand;
import com.yhm.smt.exception.BadRequestException;
import com.yhm.smt.exception.ResourceNotFoundException;
import com.yhm.smt.repository.StockOnhandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StockOnhandService {

    private final StockOnhandRepository stockOnhandRepository;
    private final ProductService productService;


    public void save(StockOnhand stockOnhand) {
        stockOnhandRepository.save(stockOnhand);
    }


    public void update(int productId, LocalDate stockDate, float quantity, TransactionType tx) {

//        TODO :: add check to for only active Products

        Product dbProduct = productService.getProduct(productId);
        Optional<StockOnhand> optionalStockOnhand = stockOnhandRepository.findFirstByProductIdOrderByCreatedAtDesc(productId);
        if (optionalStockOnhand.isEmpty()) {
            StockOnhand newStockOnHand = StockOnhand.builder()
                    .quantity(quantity)
                    .createdAt(stockDate)
                    .product(dbProduct)
                    .build();
            save(newStockOnHand);
            return;
        }
        StockOnhand dbStockOnhand = optionalStockOnhand.get();
        dbStockOnhand.setCreatedAt(stockDate);
        if (TransactionType.CREDIT == tx) {
            if (dbStockOnhand.getQuantity() < quantity) {
                throw new BadRequestException("Quantity do decrease is greater than the current stock on hand");
            }
            dbStockOnhand.setQuantity(dbStockOnhand.getQuantity() - quantity);
        } else if (TransactionType.DEBIT == tx) {
            dbStockOnhand.setQuantity(dbStockOnhand.getQuantity() + quantity);
        } else {
            throw new BadRequestException("Unknown TransactionType");
        }
        save(dbStockOnhand);
    }


    public float get(int productId, LocalDate stockDate, float quantity, TransactionType tx){
        return 0f;
    }
}
