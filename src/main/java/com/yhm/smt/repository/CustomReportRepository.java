package com.yhm.smt.repository;

import com.yhm.smt.entity.CustomReport;
import com.yhm.smt.entity.Expense;
import com.yhm.smt.entity.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomReportRepository extends JpaRepository<CustomReport, Integer> {


    Optional<CustomReport> findFirstByReportKey(String reportKey);


}
