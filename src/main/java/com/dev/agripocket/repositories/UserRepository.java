package com.dev.agripocket.repositories;

import com.dev.agripocket.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository
        extends MongoRepository<User, String> {
     List<User> findByFirstNameStartsWith(String name);
}


