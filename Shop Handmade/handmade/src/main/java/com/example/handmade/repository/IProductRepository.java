package com.example.handmade.repository;

import com.example.handmade.dto.ProductCartDto;
import com.example.handmade.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select * from product where is_delete=false order by product.id desc", nativeQuery = true)
    Page<Product> findAllBy(Pageable pageable);

    @Query(value = "select * from product where id = :id and is_delete=false ", nativeQuery = true)
    Product findById(long id);

    @Query(value = "select * from product where is_delete=false and name like concat('%',:name, '%') order by product.id desc ", nativeQuery = true)
    Page<Product> searchByName(Pageable pageable, @Param("name") String name);

    @Query(value = "select * from product where  is_delete=false and name like  concat('%',:name, '%') and type_product=:idType ", nativeQuery = true)
    Page<Product> searchByNameAndTypes(Pageable pageable, @Param("name") String name, @Param("idType") int idType);



}
