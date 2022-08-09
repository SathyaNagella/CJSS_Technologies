package com.example.demo.security;

import com.example.demo.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class MyUserDetails implements UserDetails {
    @Autowired
    EmployeeEntity employeeEntity;
    public MyUserDetails(EmployeeEntity employeeEntity){
        this.employeeEntity=employeeEntity;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(employeeEntity.getEmpDesg());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return employeeEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return employeeEntity.getEmpName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
