package com.dev.agripocket.service;
import com.dev.agripocket.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.dev.agripocket.model.User;
import java.util.*;

@Service
public class UserServiceOperations {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    private UserRepository userRepository;

    public String createUser(User user){
        return userRepository.save(user).getId();
    }
    public User update(User user, String id){
        return mongoTemplate.save(user, id);
    }

    public List<User> retrieveAllUser(){
        return (List<User>) userRepository.findAll(Sort.by(
                Sort.Direction.ASC, "lastname"));
    }

}
