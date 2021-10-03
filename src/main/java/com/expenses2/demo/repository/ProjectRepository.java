package com.expenses2.demo.repository;

import com.expenses2.demo.model.Asset;
import com.expenses2.demo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
