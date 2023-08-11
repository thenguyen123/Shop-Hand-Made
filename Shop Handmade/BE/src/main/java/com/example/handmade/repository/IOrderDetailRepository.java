package com.example.handmade.repository;

import com.example.handmade.model.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailRepository extends JpaRepository<CartDetail,Long> {
}
