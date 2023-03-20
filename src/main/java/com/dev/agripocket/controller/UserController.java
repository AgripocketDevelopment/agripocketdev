package com.dev.agripocket.controller;
import com.dev.agripocket.model.User;
import com.dev.agripocket.service.UserService;
import com.dev.agripocket.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MessageUtils messageUtils;

    @GetMapping(path = "/userById/{userId}")
    public ResponseEntity<String> getUser(@PathVariable Integer userId) {
        try{
            return new ResponseEntity<String>("Hello",  HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/registerUser")
    public ResponseEntity<String> registerUser(@RequestBody User userObj){
        try{
            String user = userService.createUser(userObj);
            String message = messageUtils.composeBodyMessage(user);

            return new ResponseEntity<String>(message, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @GetMapping(path = "/getAllUsers")
    public ResponseEntity getAllUser(){
        try {
             return new ResponseEntity(HttpStatus.OK);
        }catch(Exception e){
             return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping(path = "/getAllUser")
//    public ResponseEntity<User> getAllUsers()
//
//    }
}
