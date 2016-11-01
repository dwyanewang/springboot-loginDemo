package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

public interface UserDao extends JpaRepository <User, String> {
    List<User> findByUserName(String userName);
    List<User> findByStatus(String status);
    User findById(String uid);
}
