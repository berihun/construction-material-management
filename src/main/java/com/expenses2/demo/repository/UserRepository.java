package com.expenses2.demo.repository;

import com.expenses2.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByServiceUseId(String serviceUserId);

    User findByEmpid(String empId);
//    User findById(long id);
//    User findById1(long Id);
}
