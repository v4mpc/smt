package com.yhm.smt.controller;


import com.yhm.smt.domain.TransactionType;
import com.yhm.smt.dto.AdjustDto;
import com.yhm.smt.dto.StockOnhandDto;
import com.yhm.smt.entity.Expense;
import com.yhm.smt.entity.Product;
import com.yhm.smt.service.StockOnhandService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@Validated
@RequestMapping(path = {"/stock-on-hand"})
@RequiredArgsConstructor
public class StockOnhandController {
    private final StockOnhandService stockOnhandService;


    @GetMapping
    public Page<StockOnhandDto> getAll(Pageable pageable) {
        return stockOnhandService.findAll(pageable);
    }


    @PutMapping("/adjust")
    public ResponseEntity<String> adjustStockOnhand(@RequestBody AdjustDto adjustment) {
        stockOnhandService.update(adjustment.toStockEvent());
        return ResponseEntity.ok("Adjusted");
    }


}
