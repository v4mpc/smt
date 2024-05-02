package com.yhm.smt.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yhm.smt.entity.Expense;
import com.yhm.smt.entity.Sale;
import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashboardDto {
    private Float totalSales;
    private Float totalExpense;
    private Float totalProfit;
    private Float productsSold;
    private List<Sale> topSales;
    private List<Expense> topExpenses;
    private List<String> chartLabel;
    private List<Float> salesChartData;
    private List<Float> expensesChartData;

}
