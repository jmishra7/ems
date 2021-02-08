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

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(
  methods = {POST, GET, OPTIONS, PUT, DELETE, PATCH},
  maxAge = 3600,
  allowedHeaders = {"x-requested-with", "origin", "content-type", "accept"},
  origins = "*" 
)
@RequestMapping("/api/v1/exceptions/")
public class ExceptionsRestController {
    
    private ExceptionsRepositoryCassandra repo;

    public ExceptionsRestController(ExceptionsRepositoryCassandra exceptionsRepo) {
        this.repo = exceptionsRepo;
    }


     @GetMapping
    public List<ExceptionsEntity> findAll(HttpServletRequest req) {
         List<ExceptionsEntity> exceptions = new ArrayList<>();
         repo.findAll().forEach(e->exceptions.add(e));
         return exceptions;

    }


}






