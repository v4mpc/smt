package com.yhm.smt.service;


import com.yhm.smt.entity.CustomReport;
import com.yhm.smt.entity.Unit;
import com.yhm.smt.exception.ResourceNotFoundException;
import com.yhm.smt.repository.CustomReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomReportService {
    private final CustomReportRepository customReportRepository;


    public List<CustomReport> findAll() {
        return customReportRepository.findAll();
    }

    public void save(CustomReport customReport) {
        customReportRepository.save(customReport);
    }

    public CustomReport update(CustomReport customReport, int id) {
        CustomReport updateReport = customReportRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Report not exist with id " + id));
        updateReport.setReportName(customReport.getReportName());
        updateReport.setReportKey(customReport.getReportKey());
        updateReport.setDescription(customReport.getDescription());
        updateReport.setDisplayOrder(customReport.getDisplayOrder());
        updateReport.setColumnOption(customReport.getColumnOption());
        updateReport.setFilterOption(customReport.getFilterOption());
        updateReport.setQuery(customReport.getQuery());
        updateReport.setActive(customReport.getActive());
        customReportRepository.save(updateReport);
        return updateReport;
    }




}
