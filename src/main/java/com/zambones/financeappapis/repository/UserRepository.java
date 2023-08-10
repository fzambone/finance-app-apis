package com.zambones.financeappapis.repository;

import com.zambones.financeappapis.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
