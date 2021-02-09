package com.datastax.workshop.exceptions;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;
import static org.springframework.web.bind.annotation.RequestMethod.PATCH;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import com.datastax.workshop.todo.Todo;
import com.datastax.workshop.todo.TodoEntity;
import com.sun.jdi.event.ExceptionEvent;
import org.apache.commons.collections.iterators.FilterIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(
  methods = {POST, GET, OPTIONS, PUT, DELETE, PATCH},
  maxAge = 3600,
  allowedHeaders = {"x-requested-with", "origin", "content-type", "accept"},
  origins = "*" 
)
@RequestMapping("/api/v1/exceptions/")
public class ExceptionsRestController {

    @Autowired
    private ExceptionsRepositoryCassandra repo;

    public ExceptionsRestController(ExceptionsRepositoryCassandra exceptionsRepo) {
        this.repo = exceptionsRepo;
    }


    @GetMapping
    public List<ExceptionsEntity> findAll(HttpServletRequest req) {
         List<ExceptionsEntity> exceptions = new ArrayList<>();
        exceptions.addAll(repo.findAll());
         return exceptions;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExceptionsEntity> findById(HttpServletRequest req, @PathVariable(value = "id") String rundateerrorcode) {
        var e = repo.findById(rundateerrorcode);
        if (e.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(e.get());
    }

    @GetMapping("/{rundate}/{errorcode}")
    public ResponseEntity<ExceptionsEntity> findById(HttpServletRequest req, @PathVariable(value = "rundate") String rundate,
                                                     @PathVariable(value = "errorcode") String errorcode) {
        var e = repo.findById(rundate + errorcode);
        if (e.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(e.get());
    }


    @PostMapping
    public ResponseEntity<Void> create(HttpServletRequest req, @RequestBody List<ExceptionsEntity> exceptionsReq)
            throws URISyntaxException {
        repo.saveAll(exceptionsReq);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }



}






