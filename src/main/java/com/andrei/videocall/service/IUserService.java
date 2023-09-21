package com.andrei.videocall.service;

import com.andrei.videocall.domain.User;

import java.util.List;

public interface IUserService {
    void register(User user);
    User login(User user);
    void logout(String email);
    List<User> findAll();
}
