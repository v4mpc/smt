package com.yhm.smt.controller;


import com.yhm.smt.dto.SaleDto;
import com.yhm.smt.entity.Sale;
import com.yhm.smt.service.SaleService;
import com.yhm.smt.service.StockOnhandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping(path = {"/sales"})
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;
    private final StockOnhandService stockOnhandService;

    @GetMapping
    public Page<Sale> getAllSales(Pageable pageable) {
        return saleService.findAllSales(pageable);
    }

    @PostMapping
    public void save(@Valid @RequestBody SaleDto sale) {
        saleService.save(sale);
    }



    @PostMapping("/bulk")
    public void save(@Valid @RequestBody List<SaleDto> sales) {
        saleService.save(sales);
    }


}
