package org.lifung.service;

import org.lifung.payload.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(final TodoDto todoDto);
    List<TodoDto> findByAssignee(final Integer assignee, final Integer page, final Integer limit);
}
