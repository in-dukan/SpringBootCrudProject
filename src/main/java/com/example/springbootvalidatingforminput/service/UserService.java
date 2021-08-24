package com.example.springbootvalidatingforminput.service;

import com.example.springbootvalidatingforminput.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User insertByUser(User user);

    User update(User user);

    User delete(Long id);

    User findById(Long id);

}
