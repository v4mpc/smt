package com.yhm.smt.service;

import com.yhm.smt.entity.Expense;
import com.yhm.smt.entity.Product;
import com.yhm.smt.exception.ResourceNotFoundException;
import com.yhm.smt.repository.ExpenseRepository;
import com.yhm.smt.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;


    public Page<Expense> findAll(Pageable pageable) {
        return expenseRepository.findAll(pageable);
    }

    public void save(Expense expense) {
        expenseRepository.save(expense);
    }


    public Expense update(Expense expense, int id) {
        Expense updateExpense = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not exist with id " + id));
        updateExpense.setName(expense.getName());
        updateExpense.setAmount(expense.getAmount());
        updateExpense.setCreatedAt(expense.getCreatedAt());
        updateExpense.setDescription(expense.getDescription());
        expenseRepository.save(updateExpense);
        return updateExpense;
    }
}
