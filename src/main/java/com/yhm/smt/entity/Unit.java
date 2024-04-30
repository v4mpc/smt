package com.yhm.smt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "units", schema = "public")
public class Unit extends BaseEntity {

    @NotNull
    @Column(name = "code", length = Integer.MAX_VALUE)
    private String code;

    @NotNull
    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "conversion_factor")
    private Float conversionFactor;
}