package com.poc.phonenumberservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.phonenumberservice.model.PhoneNumber;
import com.poc.phonenumberservice.model.User;

public interface PhoneRepository extends JpaRepository<PhoneNumber, User> {
    Optional<PhoneNumber> findByUser(User user);
}
