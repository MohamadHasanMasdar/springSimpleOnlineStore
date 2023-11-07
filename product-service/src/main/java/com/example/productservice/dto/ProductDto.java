package com.example.productservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

    private Long id;
    private String productName;
    private Long price;
    private Long quantity;
}
