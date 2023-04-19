package com.example.handmade.repository;

import com.example.handmade.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "select * from product where is_delete=false", nativeQuery = true)
    Page<Product> findAllBy(Pageable pageable);
}
