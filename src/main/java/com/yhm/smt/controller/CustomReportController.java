package com.yhm.smt.controller;


import com.yhm.smt.entity.CustomReport;
import com.yhm.smt.entity.Unit;
import com.yhm.smt.service.CustomReportService;
import com.yhm.smt.service.UnitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping(path = {"/api/custom-report"})
@RequiredArgsConstructor
public class CustomReportController {
    private final CustomReportService customReportService;

    @GetMapping("")
    public List<CustomReport> getAllUnits() {
        return customReportService.findAll();
    }

    @PostMapping
    public ResponseEntity<CustomReport> save(@Valid @RequestBody CustomReport customReport) {

        customReportService.save(customReport);
        return ResponseEntity.ok(customReport);
    }

    @PutMapping("{id}")
    public ResponseEntity<CustomReport> update(@PathVariable int id, @RequestBody CustomReport customReport) {
        CustomReport c = customReportService.update(customReport, id);
        return ResponseEntity.ok(c);
    }

}
