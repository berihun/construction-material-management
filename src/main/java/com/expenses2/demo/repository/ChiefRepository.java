package com.expenses2.demo.repository;

import com.expenses2.demo.model.Chief;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiefRepository extends JpaRepository<Chief, Long> {
}
