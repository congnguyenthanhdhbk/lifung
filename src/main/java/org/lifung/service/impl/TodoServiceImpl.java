package org.lifung.service.impl;

import org.lifung.entity.Todo;
import org.lifung.payload.TodoDto;
import org.lifung.repository.TodoRepository;
import org.lifung.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper;

    public TodoServiceImpl(
            TodoRepository todoRepository,
            ModelMapper modelMapper
    ) {
        this.todoRepository = todoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        final Todo todo = Todo.builder()
                .assignee(todoDto.getAssignee())
                .category(todoDto.getCategory())
                .name(todoDto.getName())
                .build();
        final Todo savedTodo = this.todoRepository.save(todo);
        return this.modelMapper.map(savedTodo, TodoDto.class);
    }

    @Override
    public List<TodoDto> findByAssignee(Integer assignee, Integer page, Integer limit) {
        final List<Todo> todos = this.todoRepository.findAllByAssignee(assignee, PageRequest.of(page, limit));
        return todos.stream().map(todo -> this.modelMapper.map(todo, TodoDto.class)).collect(Collectors.toList());

    }
}
