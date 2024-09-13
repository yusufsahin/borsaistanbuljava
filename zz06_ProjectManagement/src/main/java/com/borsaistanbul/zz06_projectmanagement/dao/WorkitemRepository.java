package com.borsaistanbul.zz06_projectmanagement.dao;
import com.borsaistanbul.zz06_projectmanagement.dao.model.Workitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkitemRepository extends JpaRepository<Workitem, Long> {

    // Custom query to fetch Workitem with associated tasks by ID
    @Query("SELECT w FROM Workitem w LEFT JOIN FETCH w.tasks WHERE w.id = :id")
    Optional<Workitem> findByIdWithTasks(@Param("id") Long id);

    // Custom query to fetch all Workitems with associated tasks
    @Query("SELECT DISTINCT w FROM Workitem w LEFT JOIN FETCH w.tasks")
    List<Workitem> findAllWithTasks();

    // Find Workitems by Project ID
    List<Workitem> findByProjectId(Long projectId);
}
