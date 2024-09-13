package com.borsaistanbul.zz06_projectmanagement.dao;

import com.borsaistanbul.zz06_projectmanagement.dao.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository  extends JpaRepository<Task,Long> {
    List<Task> findByWorkitemId(Long workItemId);
}
