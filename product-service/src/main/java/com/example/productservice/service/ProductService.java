package com.example.productservice.service;

import com.example.productservice.dto.ProductDto;

public interface ProductService {

    long addProduct(ProductDto productDto);
    ProductDto getProductById(Long id);

    void reduceProductQuantity(Long productId, Long quantity);
}
