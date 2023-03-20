package com.dev.agripocket.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    public int id;
    public int userId;
    public String address;
    public String city;
    public String postalCode;
    public String country;
    public String mobile;
    public String telephone;
}
