package com.dev.agripocket.service;
import java.util.*;
import com.dev.agripocket.model.User;

public interface UserService {
    String createUser (User user);
    User updateUser (User user, String Id);

    List<User> getUserStartWith(String name);
}

