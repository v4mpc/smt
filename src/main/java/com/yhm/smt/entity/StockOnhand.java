package com.yhm.smt.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stock_on_hand", schema = "public",uniqueConstraints = {@UniqueConstraint(columnNames = {"product_id","created_at"})})
public class StockOnhand extends BaseEntity {




    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @NotNull
    @Column(name = "quantity")
    private Float quantity;


    @Column(name = "created_at")
    @JsonIgnore(value = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;


    @Override
    protected void onCreate() {
        setUpdatedAt(LocalDate.now());
    }
}
