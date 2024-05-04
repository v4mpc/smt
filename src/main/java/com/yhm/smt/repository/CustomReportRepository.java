package com.yhm.smt.repository;

import com.yhm.smt.entity.CustomReport;
import com.yhm.smt.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomReportRepository extends JpaRepository<CustomReport,Integer> {
}
