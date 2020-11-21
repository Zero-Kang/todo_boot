package org.zerock.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.todo.entity.Todo;
import org.zerock.todo.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos/")
@RequiredArgsConstructor
public class TodoController {


    private final TodoRepository todoRepository;

    @PostMapping("")
    public ResponseEntity<Long> register(@RequestBody Todo todo){

        todoRepository.save(todo);

        return new ResponseEntity<>(todo.getTno(), HttpStatus.OK);
    }

    @GetMapping("/{tno}")
    public ResponseEntity<Todo> register(@PathVariable("tno") Long tno){

        Optional<Todo> result = todoRepository.findById(tno);

        return new ResponseEntity<>(result.get(), HttpStatus.OK);
    }

    @GetMapping("/pages")
    public ResponseEntity<Page<Todo>> getList( String page){


        Pageable pageable = PageRequest.of( Integer.parseInt(page) -1, 10, Sort.by("tno").descending());

        Page<Todo> result = todoRepository.findAll(pageable);

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @DeleteMapping("/{tno}")
    public ResponseEntity<String> remove(@PathVariable("tno") Long tno){

        todoRepository.deleteById(tno);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Long> modify(@RequestBody Todo todo){

        todoRepository.save(todo);

        return new ResponseEntity<>(todo.getTno(), HttpStatus.OK);
    }


}












