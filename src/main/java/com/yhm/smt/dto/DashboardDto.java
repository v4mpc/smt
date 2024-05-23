package com.yhm.smt.dto;


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
    private Float totalExpenses;
    private Float totalSalesProfit;
    private Float totalNetProfit;
    private Float totalSellStock;
    private Float productsSold;
    private List<Sale> topSales;
    private List<Expense> topExpenses;
    private List<String> chartLabel;
    private List<Float> salesChartData;
    private List<Float> expensesChartData;


}
