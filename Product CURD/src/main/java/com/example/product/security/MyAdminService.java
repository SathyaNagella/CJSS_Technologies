package com.example.product.security;

import com.example.product.entity.AdminEntity;
import com.example.product.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class MyAdminService implements UserDetailsService {
    @Autowired
    AdminRepository adminRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AdminEntity> adminEntity=adminRepository.findById(username);
        if(adminEntity.isEmpty()){
            throw  new RuntimeException("Admin Not Found");
        }
        return new MyAdminDetails(adminEntity.get());
    }
}
