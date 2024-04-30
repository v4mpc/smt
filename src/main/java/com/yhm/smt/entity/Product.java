package com.yhm.smt.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product extends BaseEntity {

    @NotNull
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;


    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unit_of_measure_id")
    private Unit unitOfMeasure;

    @NotNull
    @Column(name = "buy_price")
    private Float buyPrice;

    @NotNull
    @Column(name = "sale_price")
    private Float salePrice;

    @NotNull
    @Column(name = "active")
    private Boolean active;

}
