package com.example.orderservice.external.client;

import com.example.orderservice.external.exception.CustomException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.commons.ServiceNames;
import org.example.dto.productservice.ProductDto;
import org.example.endpoints.product.ProductControllerEndPoints;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient(name = ServiceNames.productService + ProductControllerEndPoints.PATH_GENERAL)
public interface ProductService {

    @PutMapping(ProductControllerEndPoints.PATH_REDUCE_PRODUCT_QUANTITY)
    ResponseEntity reduceProductQuantity(
            @PathVariable Long productId,
            @RequestParam Long quantity);

    @GetMapping(ProductControllerEndPoints.PATH_GET_PRODUCT_BY_ID)
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id);

    default void fallback(Exception e) {
        throw new CustomException(
                "product service is not up",
                "unavailable"
        );
    }
}
