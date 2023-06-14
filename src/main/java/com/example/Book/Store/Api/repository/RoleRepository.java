package com.example.Book.Store.Api.repository;

import com.example.Book.Store.Api.model.ERole;
import com.example.Book.Store.Api.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
