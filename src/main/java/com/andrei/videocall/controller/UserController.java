package com.andrei.videocall.controller;

import com.andrei.videocall.domain.User;
import com.andrei.videocall.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {
    private final IUserService service;

    @PostMapping
    public void register(User user) {
        service.register(user);
    }

    @PostMapping("/login")
    public User login(User user) {
        return service.login(user);
    }

    @PostMapping("/logout")
    public void logout(String email) {
        service.logout(email);
    }

    @GetMapping
    public List<User> findAll() {
        return service.findAll();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }
}