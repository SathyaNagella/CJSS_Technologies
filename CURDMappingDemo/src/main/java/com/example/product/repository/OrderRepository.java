package com.example.product.repository;

import com.example.product.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
   List<OrderEntity> findAllByUserId(String userId);
}
