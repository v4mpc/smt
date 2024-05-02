package com.yhm.smt.service;

import com.yhm.smt.domain.StockEvent;
import com.yhm.smt.domain.TransactionType;
import com.yhm.smt.dto.StockOnhandDto;
import com.yhm.smt.entity.Product;
import com.yhm.smt.entity.StockOnhand;
import com.yhm.smt.exception.BadRequestException;
import com.yhm.smt.repository.StockOnhandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StockOnhandService {

    private final StockOnhandRepository stockOnhandRepository;
    private final ProductService productService;


    public void save(StockOnhand stockOnhand) {
        stockOnhandRepository.save(stockOnhand);
    }


    public void update(StockEvent event) {

//        TODO :: add check to for only active Products

        Product dbProduct = productService.getProduct(event.getProductId());
        Optional<StockOnhand> optionalStockOnhand = stockOnhandRepository.findFirstByProductIdOrderByCreatedAtDesc(event.getProductId());
        if (optionalStockOnhand.isEmpty()) {
            StockOnhand newStockOnHand = StockOnhand.builder()
                    .quantity(event.getQuantity())
                    .createdAt(event.getEventDate())
                    .product(dbProduct)
                    .build();
            save(newStockOnHand);
            return;
        }
        StockOnhand dbStockOnhand = optionalStockOnhand.get();
        dbStockOnhand.setCreatedAt(event.getEventDate());
        if (TransactionType.CREDIT == event.getTx()) {
            if (dbStockOnhand.getQuantity() < event.getQuantity()) {
                throw new BadRequestException("Quantity do decrease is greater than the current stock on hand");
            }
            dbStockOnhand.setQuantity(dbStockOnhand.getQuantity() - event.getQuantity());
        } else if (TransactionType.DEBIT == event.getTx()) {
            dbStockOnhand.setQuantity(dbStockOnhand.getQuantity() + event.getQuantity());
        } else {
            throw new BadRequestException("Unknown TransactionType");
        }
        save(dbStockOnhand);
    }


    public float get(int productId, LocalDate stockDate) {
        Product dbProduct = productService.getProduct(productId);
        Optional<StockOnhand> optionalStockOnhand = stockOnhandRepository.findFirstByProductIdAndCreatedAtLessThanEqualOrderByCreatedAtDesc(dbProduct.getId(), stockDate);
        if (optionalStockOnhand.isEmpty()) {
            return 0;
        }
        return optionalStockOnhand.get().getQuantity();
    }

    public StockOnhandDto toStockOnhandDto(Product product) {
        return StockOnhandDto.builder()
                .product(product)
                .stockOnhand(get(product.getId(), LocalDate.now()))
                .build();
    }


    public Page<StockOnhandDto> findAll(Pageable pageable) {
        Page<Product> productsPage = productService.findAll(pageable);
        List<Product> products = productsPage.getContent();
        Pageable productsPageable = productsPage.getPageable();
        long productsTotal = productsPage.getTotalElements();
        List<StockOnhandDto> soh = products.stream().map(this::toStockOnhandDto).toList();
        return new PageImpl<>(soh, productsPageable, productsTotal);
    }


    public boolean hasNonZeroStock(StockOnhandDto sohDto) {
        return sohDto.getStockOnhand() > 0;
    }


    public List<StockOnhandDto> findAll(boolean nonZeroSoh) {
        List<Product> products = productService.findAll();
        if (nonZeroSoh) {
            return products.stream().map(this::toStockOnhandDto).filter(this::hasNonZeroStock).toList();
        }
        return products.stream().map(this::toStockOnhandDto).toList();
    }


}
