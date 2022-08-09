package com.example.demo.security;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public class MyUserService implements UserDetailsService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Long i=Long.valueOf(username);
       Optional<EmployeeEntity> employeeEntity=  employeeRepository.findById(i);
        if(employeeEntity.get()==null){
            throw new RuntimeException("Could not found the user");
        }return new MyUserDetails(employeeEntity.get());
    }
}
