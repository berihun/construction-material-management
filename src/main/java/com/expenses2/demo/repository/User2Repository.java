package com.expenses2.demo.repository;

import com.expenses2.demo.model.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface User2Repository extends JpaRepository<User2, Long> {
    Optional<User2> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
