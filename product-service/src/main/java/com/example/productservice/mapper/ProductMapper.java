package com.example.productservice.mapper;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.entity.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

    Product mapDtoToEntity(ProductDto productDto);
    ProductDto mapEntityToDto(Product product);
}
