package com.yhm.smt.controller;


import com.yhm.smt.domain.TransactionType;
import com.yhm.smt.dto.AdjustDto;
import com.yhm.smt.entity.Expense;
import com.yhm.smt.service.StockOnhandService;
import lombok.RequiredArgsConstructor;
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

    @PutMapping("/adjust")
    public ResponseEntity<String> adjustStockOnhand(@RequestBody AdjustDto adjustment) {
        stockOnhandService.update(adjustment.toStockEvent());
        return ResponseEntity.ok("Adjusted");
    }


//    @PostMapping("/update")
//    public ResponseEntity<String> createOrUpdateStockOnhand(@PathVariable int id) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        stockOnhandService.update(id, LocalDate.parse("2026-01-01",formatter),9.5f, TransactionType.CREDIT);
//        return ResponseEntity.ok("done");
//    }
}
