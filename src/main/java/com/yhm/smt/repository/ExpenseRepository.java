package com.yhm.smt.repository;

import com.yhm.smt.entity.Expense;
import com.yhm.smt.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Integer> {
    @Query("SELECT s FROM Expense s WHERE MONTH(s.createdAt) = :month AND YEAR(s.createdAt) = :year")
    List<Expense> findByMonthAndYear(@Param("month") int month, @Param("year") int year);
}
