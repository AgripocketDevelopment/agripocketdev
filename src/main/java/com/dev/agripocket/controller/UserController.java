package com.dev.agripocket.controller;
import com.dev.agripocket.model.User;
import com.dev.agripocket.service.UserServiceImpl;
import com.dev.agripocket.utils.MessageUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import java.io.IOException;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    MessageUtils messageUtils;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping(path = "/userById/{userId}")
    public ResponseEntity<String> getUser(@PathVariable Integer userId) {
        try{
            return new ResponseEntity<String>("Hello",  HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/registerUser",
            consumes = "application/json"
    )
    public ResponseEntity<String> registerUser(@RequestBody User userObj){
        System.out.println("user object" + userObj);
        try{
            String user = userServiceImpl.createUser(userObj);
            return new ResponseEntity<String>("Inserting to Mongo DB with user id of : " + user, HttpStatus.OK);
        }catch (Exception e){
            logger.error("[UserController] Exceptions :", e);
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
}
