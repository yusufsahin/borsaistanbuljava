package com.borsaistanbul.zz06_projectmanagement.dao;

import com.borsaistanbul.zz06_projectmanagement.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
