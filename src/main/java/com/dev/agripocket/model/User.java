package com.dev.agripocket.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Document
@AllArgsConstructor
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Address address;
    private String mobileNumber;
    private Date createdAt;
    private Date modifiedAt;
}
