package com.dev.agripocket.service;
import com.dev.agripocket.model.Role;
import com.dev.agripocket.model.User;
import com.dev.agripocket.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserServiceOperations userServiceOperations;

    @Override
    public String createUser(User userEntity) {
        /*
        * Create object of users
        * */
        User user = new User();
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setCreatedAt(LocalDate.now());
        user.setMobileNumber(userEntity.getMobileNumber());
        user.setAddress(userEntity.getAddress());
        user.setRole(Role.USER);
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