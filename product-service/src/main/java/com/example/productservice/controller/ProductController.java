package com.example.productservice.controller;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.endpoints.product.ProductControllerEndPoints;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Log4j2
@RequestMapping(ProductControllerEndPoints.PATH_GENERAL)
public class ProductController {
    private final ProductService productService;

    @PostMapping(ProductControllerEndPoints.PATH_ADD)
    public ResponseEntity<Long> addProduct(@RequestBody ProductDto productDto) {
        long productId = productService.addProduct(productDto);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping(ProductControllerEndPoints.PATH_GET_PRODUCT_BY_ID)
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        ProductDto productDto = productService.getProductById(id);
        return new ResponseEntity<>(
                productDto,
                HttpStatus.OK
        );
    }

    @PutMapping(ProductControllerEndPoints.PATH_REDUCE_PRODUCT_QUANTITY)
    public ResponseEntity reduceProductQuantity(
            @PathVariable Long productId,
            @RequestParam Long quantity) {
        productService.reduceProductQuantity(productId, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
