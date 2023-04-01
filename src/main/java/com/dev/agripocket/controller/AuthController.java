package com.dev.agripocket.controller;
import com.dev.agripocket.model.AuthLogin;
import com.dev.agripocket.service.AuthLoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login/auth")
public class AuthController {
    private AuthLoginService authLoginService;
    public AuthController(AuthLoginService authLoginService){
        this.authLoginService = authLoginService;
    }

    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<String> login(@RequestBody AuthLogin authLogin){
        try{
            String response = authLoginService.login(authLogin);
            return new ResponseEntity<String>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }
}
