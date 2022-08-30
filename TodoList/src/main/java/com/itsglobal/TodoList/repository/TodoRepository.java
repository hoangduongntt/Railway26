package com.itsglobal.TodoList.repository;

import com.itsglobal.TodoList.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> , JpaSpecificationExecutor<Todo> {

   Optional<Todo> findByIdAndDeleteFlag(Long id, Boolean deleteFlag);

   @Query("SELECT t FROM Todo t WHERE t.taskName LIKE %?1% AND t.deleteFlag = ?2" )
   public List<Todo> findByTaskName(String name , Boolean deleteFlag);
   @Query("SELECT t FROM Todo t WHERE t.deleteFlag = ?1")
   public List<Todo> findAllAndDeleteFlag(Boolean deleteFlag);
}

