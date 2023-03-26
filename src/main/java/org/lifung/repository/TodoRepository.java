package org.lifung.repository;

import org.lifung.entity.Todo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TodoRepository extends CrudRepository<Todo, Long>, PagingAndSortingRepository<Todo, Long> {
    List<Todo> findAllByAssignee(Integer assignee, Pageable pageable);
}
