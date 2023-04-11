package com.iftm.exercicio02.controllers;

import com.iftm.exercicio02.data.vo.EmailVO;
import com.iftm.exercicio02.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("api/v1/email")
public class EmailController {
    @Autowired
    private EmailService service;

    // READ - HTTP GET
    // Endpoint: http://localhost:8080/api/v1/email
    @GetMapping
    public List<EmailVO> findAll() {
        return service.findAll();
    }

    // READ - HTTP GET
    // Endpoint: http://localhost:8080/api/v1/email/ID
    @GetMapping("/{id}")
    public EmailVO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    // CREATE - HTTP POST
    // Endpoint: http://localhost:8080/api/v1/email
    @PostMapping
    public EmailVO save(@RequestBody EmailVO emailVO) {
        return service.save(emailVO);
    }

    // UPDATE - HTTP PUT
    // Endpoint: http://localhost:8080/api/v1/email
    @PutMapping
    public EmailVO update(@RequestBody EmailVO emailVO) {
        return service.update(emailVO);
    }

    // DELETE - HTTP DELETE
    // Endpoint: http://localhost:8080/api/v1/email/ID
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }
}