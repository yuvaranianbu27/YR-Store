package com.yuva.yuvaranistore.service;

import java.util.List;
import com.yuva.yuvaranistore.dto.ProductDto;

public interface IProductService {

    List<ProductDto> getProducts();
}