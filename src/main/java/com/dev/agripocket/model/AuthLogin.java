package com.dev.agripocket.model;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthLogin {
    private String usernameOrEmail;
    private String password;
}