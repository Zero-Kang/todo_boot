package org.zerock.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.todo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
