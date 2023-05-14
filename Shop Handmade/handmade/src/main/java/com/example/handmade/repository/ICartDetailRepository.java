package com.example.handmade.repository;

import com.example.handmade.dto.CartDetailDto;
import com.example.handmade.dto.ProductCartDto;
import com.example.handmade.model.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICartDetailRepository extends JpaRepository<CartDetail,Long> {
 @Query(value = "SELECT * FROM shop_hand_made2.cart_detail where is_flag=false", nativeQuery = true)
 List<CartDetail> findAll();
 @Query(value = "SELECT * FROM shop_hand_made2.cart_detail where is_flag=false and order_id=:idCart", nativeQuery = true)
 List<CartDetail> findByIdCart(@Param("idCart") Long idCart);
 @Query(value = " select cart.id as idCart,cart_detail.id as idDetail, product.id as id,product.quantity as quantity, product.name as name, product.prices as prices, cart_detail.amount as amount from product join cart_detail on  product.id=cart_detail.product_id\n" +
         "            join cart on cart.id=cart_detail.order_id join app_user on app_user.id=cart.id_user where app_user.email like :userName  and cart_detail.is_flag=false", nativeQuery = true)
 List<ProductCartDto> findCart(@Param("userName") String userName);
 @Query(value = " select cart.id as idCart,cart_detail.id as idDetail, product.id as id,cart_detail.day_pay_pal as dayPayPal, product.name as name, product.prices as prices, cart_detail.amount as amount from product join cart_detail on  product.id=cart_detail.product_id\n" +
         "            join cart on cart.id=cart_detail.order_id join app_user on app_user.id=cart.id_user where app_user.email like :userName  and cart_detail.is_flag=true", nativeQuery = true)
 List<CartDetailDto> findBuy(@Param("userName") String userName);
 @Transactional
 @Modifying
 @Query(value = "UPDATE `shop_hand_made2`.`cart_detail` SET `is_flag` = true, `day_pay_pal`=:dayPayPal WHERE `id`= :id", nativeQuery = true)
 void payPal(@Param("id")Long id, @Param("dayPayPal") String dayPayPal);
}
