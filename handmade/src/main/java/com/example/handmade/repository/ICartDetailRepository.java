package com.example.handmade.repository;

import com.example.handmade.model.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICartDetailRepository extends JpaRepository<CartDetail,Long> {
 @Query(value = "SELECT * FROM shop_hand_made2.cart_detail where is_flag=false", nativeQuery = true)
 List<CartDetail> findAll();
}
