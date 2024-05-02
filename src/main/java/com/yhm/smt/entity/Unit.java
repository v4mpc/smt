package com.yhm.smt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "units", schema = "public")
public class Unit extends BaseEntity {

    @NotNull
    @Column(name = "code")
    private String code;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "conversion_factor")
    private Float conversionFactor;
}