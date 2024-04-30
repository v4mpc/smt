package com.yhm.smt.service;


import com.yhm.smt.entity.Product;
import com.yhm.smt.entity.Unit;
import com.yhm.smt.exception.ResourceNotFoundException;
import com.yhm.smt.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnitService {
    private final UnitRepository unitRepository;


    public Page<Unit> findAll(Pageable pageable) {
        return unitRepository.findAll(pageable);
    }

    public void save(Unit unit) {
        unitRepository.save(unit);
    }

    public Unit update(Unit unit, int id) {
        Unit updateUnit = unitRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Unit not exist with id " + id));
        updateUnit.setName(unit.getName());
        updateUnit.setName(unit.getName());
        unitRepository.save(updateUnit);
        return updateUnit;
    }
}
