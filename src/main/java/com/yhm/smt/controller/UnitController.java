package com.yhm.smt.controller;


import com.yhm.smt.entity.Product;
import com.yhm.smt.entity.Unit;
import com.yhm.smt.service.ProductService;
import com.yhm.smt.service.UnitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(path = {"/units"})
@RequiredArgsConstructor
public class UnitController {
    private final UnitService unitService;

    @GetMapping
    public Page<Unit> getAllUnits(Pageable pageable) {
        return unitService.findAll(pageable);
    }

    @PostMapping
    public ResponseEntity<Unit> save(@Valid @RequestBody Unit unit) {

        unitService.save(unit);
        return ResponseEntity.ok(unit);
    }

    @PutMapping("{id}")
    public ResponseEntity<Unit> update(@PathVariable int id, @RequestBody Unit unit) {
        Unit u = unitService.update(unit, id);
        return ResponseEntity.ok(u);
    }
}
