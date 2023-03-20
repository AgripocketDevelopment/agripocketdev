package com.dev.agripocket.service;
import com.dev.agripocket.model.User;
import com.dev.agripocket.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class UserServiceImpl extends
        UserServiceOperations implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String createUser(User user) {
        if (user != null) {
            return HttpStatus.NO_CONTENT.toString();
        }
        return super.createUser(user);
    }

    @Override
    public User updateUser(User user, String id) {
        return super.update(user, id);
    }

    @Override
    public List<User> getUserStartWith(String name) {
        return userRepository.findByFirstNameStartsWith(name);
    }

}