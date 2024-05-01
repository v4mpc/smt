package com.yhm.smt.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockEvent {


    @NotNull
    private int productId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate eventDate;

    @NotNull
    private float quantity;

    @NotNull
    TransactionType tx;
}
