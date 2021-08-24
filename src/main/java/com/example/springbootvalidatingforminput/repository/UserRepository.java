package com.example.springbootvalidatingforminput.repository;

import com.example.springbootvalidatingforminput.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
