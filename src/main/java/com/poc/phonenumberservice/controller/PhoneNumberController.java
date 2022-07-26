package com.poc.phonenumberservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.phonenumberservice.model.PhoneNumber;
import com.poc.phonenumberservice.model.User;
import com.poc.phonenumberservice.service.PhoneService;

@RestController
public class PhoneNumberController {

    @Autowired
    PhoneService phoneService;

    @PostMapping("/phone")
    public PhoneNumber getPhoneNumber(@RequestBody User user) {
        return phoneService.getPhoneNumberForAUser(user);
    }
}
