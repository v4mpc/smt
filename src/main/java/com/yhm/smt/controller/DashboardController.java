package com.yhm.smt.controller;


import com.yhm.smt.dto.DashboardDto;
import com.yhm.smt.dto.StockOnhandDto;
import com.yhm.smt.service.DashboardService;
import com.yhm.smt.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.YearMonth;
import java.util.List;

@RestController
@Validated
@RequestMapping(path = {"/dashboard"})
@RequiredArgsConstructor
public class DashboardController {

    public final DashboardService dashboardService;


    @GetMapping
    public ResponseEntity<DashboardDto> getMetrics(@RequestParam(required = false) String m) {
        YearMonth yearMonth = YearMonth.now();
        if (null != m && !m.isEmpty()) {
            yearMonth = DateUtil.fromString(m);
        }
        return ResponseEntity.ok(dashboardService.getMetrics(yearMonth));
    }
}
