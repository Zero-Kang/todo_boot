package org.zerock.todo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.todo.entity.Todo;

import java.util.stream.IntStream;

@SpringBootTest

public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void insertDummies() {

        IntStream.rangeClosed(1,200).forEach(i -> {
            Todo todo = Todo.builder().title("Test..." + i).content("Content...." + i).build();

            todoRepository.save(todo);
        });
    }

}
