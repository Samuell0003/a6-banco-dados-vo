package com.iftm.exercicio02.controllers;

import com.iftm.exercicio02.data.vo.UserVO;
import com.iftm.exercicio02.models.User;
import com.iftm.exercicio02.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService service;

    // READ - HTTP GET
    // Endpoint: http://localhost:8080/api/v1/user
    @GetMapping
    public List<UserVO> findAll() {
        return service.findAll();
    }

    // READ - HTTP GET
    // Endpoint: http://localhost:8080/api/v1/user/ID
    @GetMapping("/{id}")
    public UserVO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    // CREATE - HTTP POST
    // Endpoint: http://localhost:8080/api/v1/user
    @PostMapping
    public UserVO save(@RequestBody UserVO userVO) {
        return service.save(userVO);
    }

    // UPDATE - HTTP PUT
    // Endpoint: http://localhost:8080/api/v1/user
    @PutMapping
    public UserVO update(@RequestBody UserVO userVO) {
        return service.update(userVO);
    }

    // DELETE - HTTP DELETE
    // Endpoint: http://localhost:8080/api/v1/user/ID
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }
}
