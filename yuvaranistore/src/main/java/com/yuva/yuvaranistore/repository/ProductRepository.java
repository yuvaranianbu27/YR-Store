package com.yuva.yuvaranistore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yuva.yuvaranistore.entity.Product;

public interface ProductRepository extends
		JpaRepository<Product, Long> {

}
