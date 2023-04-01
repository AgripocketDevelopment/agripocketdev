package com.dev.agripocket.service.impl;
import com.dev.agripocket.controller.UserController;
import com.dev.agripocket.model.Role;
import com.dev.agripocket.model.User;
import com.dev.agripocket.repositories.UserRepository;
import com.dev.agripocket.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserServiceOperations userServiceOperations;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Override
    public String createUser(User userEntity) {
        /**
         * Update object of {address.userId} userId document
         * according to userId collections...
         * **/
        userEntity.getAddress()
                .setUserId(Integer.parseInt(userServiceOperations.getUserId()));
        /**
         * Map User Object to insert User DB collection
         * **/
        User user = new User();
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setCreatedAt(LocalDate.now());
        user.setMobileNumber(userEntity.getMobileNumber());
        user.setAddress(userEntity.getAddress());
        user.setRole(Collections.singleton(Role.USER));
        return userServiceOperations.createUser(user);
    }

    @Override
    public User updateUser(User user, String id) {
        return userServiceOperations.update(user, id);
    }

    @Override
    public List<User> getUserStartWith(String name) {
        return userRepository.findByFirstNameStartsWith(name);
    }

}