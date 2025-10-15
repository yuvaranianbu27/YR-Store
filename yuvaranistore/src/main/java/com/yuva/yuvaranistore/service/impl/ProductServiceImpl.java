package com.yuva.yuvaranistore.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.yuva.yuvaranistore.dto.ProductDto;
import com.yuva.yuvaranistore.entity.Product;
import com.yuva.yuvaranistore.repository.ProductRepository;
import com.yuva.yuvaranistore.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
	public List<ProductDto> getProducts() {
		
		// TODO Auto-generated method stub
		return productRepository.findAll().
				stream()
				.map(this::transformToDTO)
				.collect(Collectors.toList());
	}
		
				

	private ProductDto transformToDTO(Product product) {
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(product, productDto);
		productDto.setProductId(product.getId());
		return productDto;
	}
}
