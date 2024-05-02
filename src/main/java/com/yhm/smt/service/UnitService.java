package com.yhm.smt.service;


import com.yhm.smt.entity.Product;
import com.yhm.smt.entity.Unit;
import com.yhm.smt.exception.ResourceNotFoundException;
import com.yhm.smt.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitService {
    private final UnitRepository unitRepository;


    public Page<Unit> findAll(Pageable pageable) {
        return unitRepository.findAll(pageable);
    }

    public List<Unit> findAll() {
        return unitRepository.findAll();
    }

    public void save(Unit unit) {
        unitRepository.save(unit);
    }

    public Unit update(Unit unit, int id) {
        Unit updateUnit = unitRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Unit not exist with id " + id));
        updateUnit.setCode(unit.getCode());
        updateUnit.setName(unit.getName());
        unitRepository.save(updateUnit);
        return updateUnit;
    }
}
