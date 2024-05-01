package com.yhm.smt.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yhm.smt.entity.Sale;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
public class SaleDto extends AdjustDto {

    @NotNull
    private Float saleAdjustment;

    private String description;


}
