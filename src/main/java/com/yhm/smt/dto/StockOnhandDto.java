package com.yhm.smt.dto;


import com.yhm.smt.entity.Product;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockOnhandDto {

    private Product product;
    private float stockOnhand;

}
