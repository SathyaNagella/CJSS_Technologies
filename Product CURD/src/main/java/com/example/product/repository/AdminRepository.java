package com.example.product.repository;

import com.example.product.entity.AdminEntity;
import com.example.product.model.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,String> {

}
