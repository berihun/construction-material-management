package com.expenses2.demo.repository;

import com.expenses2.demo.model.WorkUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkUnitRepository extends JpaRepository<WorkUnit, Long> {
}
