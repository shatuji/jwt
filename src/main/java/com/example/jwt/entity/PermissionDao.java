package com.example.jwt.entity;

import java.util.List;

public interface PermissionDao {
    List<Permission> findAll();
    List<Permission> findByUserId(String userId);
    List<Permission> findAll2();
}
