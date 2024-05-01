package com.yhm.smt.controller;


import com.yhm.smt.domain.TransactionType;
import com.yhm.smt.entity.Sale;
import com.yhm.smt.entity.StockOnhand;
import com.yhm.smt.service.SaleService;
import com.yhm.smt.service.StockOnhandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(path = {"/sales"})
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;
    private final StockOnhandService stockOnhandService;

    @GetMapping
    public Page<Sale> getAllSales(Pageable pageable) {
        return saleService.findAll(pageable);
    }

    @PostMapping
    public void save(@Valid @RequestBody Sale sale) {
        saleService.save(sale);
    }

    @PutMapping("{id}")
    public ResponseEntity<Sale> update(@PathVariable int id, @RequestBody Sale sale) {
        Sale e = saleService.update(sale, id);
        return ResponseEntity.ok(e);
    }


    @GetMapping("/stockOnhand/{id}")
    public ResponseEntity<String> getStockOnhand(@PathVariable int id) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        stockOnhandService.update(id, LocalDate.parse("2026-01-01",formatter),9.5f, TransactionType.CREDIT);
        return ResponseEntity.ok("done");
    }
}
