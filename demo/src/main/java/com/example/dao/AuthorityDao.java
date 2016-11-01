package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.UserAuthority;

public interface AuthorityDao extends JpaRepository <UserAuthority, String> {
    UserAuthority findByAuthority(String authority);
}
