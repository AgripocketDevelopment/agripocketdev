package com.dev.agripocket.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class UserPayment {
    public int id;
    public int userId;
    public String paymentType;
    public String provider;
    public String accountNumber;
    public Date expiry;
}
