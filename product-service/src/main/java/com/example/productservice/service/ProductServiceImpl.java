package com.example.productservice.service;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.entity.Product;
import com.example.productservice.exception.NotFoundExceptionHandler;
import com.example.productservice.exception.ValidationExceptionHandler;
import com.example.productservice.mapper.ProductMapper;
import com.example.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public long addProduct(ProductDto productDto) {
        Product product = productRepository.save(productMapper.mapDtoToEntity(productDto));
        return product.getId();
    }

    @Override
    public ProductDto getProductById(Long id) {
       return productRepository.findById(id)
               .map(pr -> productMapper.mapEntityToDto(pr))
               .orElseThrow(() -> new NotFoundExceptionHandler("product not found with id: " + id));
    }

    @Override
    public void reduceProductQuantity(Long productId, Long quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new NotFoundExceptionHandler("product not found with id: " + productId));

        if (product.getQuantity() < quantity)
            throw new ValidationExceptionHandler("product does not have quantity with: " + quantity);

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
    }
}
