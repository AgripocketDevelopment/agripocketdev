package com.dev.agripocket.repositories;
import com.dev.agripocket.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AdressRepository extends MongoRepository<Address, String> {
    Optional<Address> findById(String s);
    Optional<Address> findByUserId(String s);
}
