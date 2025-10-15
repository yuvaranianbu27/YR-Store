package com.yuva.yuvaranistore.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yuva.yuvaranistore.dto.ProductDto;
import com.yuva.yuvaranistore.service.IProductService;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    private final IProductService iProductService;

    @GetMapping
    public List<ProductDto> getProducts() throws InterruptedException { // DTO Pattern
        List<ProductDto> productList = iProductService.getProducts();

        return productList;
    }
}