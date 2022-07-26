package com.poc.phonenumberservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.phonenumberservice.model.PhoneNumber;
import com.poc.phonenumberservice.model.User;
import com.poc.phonenumberservice.repository.PhoneRepository;
import com.sun.istack.NotNull;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    PhoneRepository phoneRepository;

    @Override
    public PhoneNumber getPhoneNumberForAUser(User user) {
        Optional<PhoneNumber> optionalPhoneNumber =  phoneRepository.findById(user);
        if(optionalPhoneNumber.isPresent()) {
            return optionalPhoneNumber.get();
        }
        log.info("Phone number does not exist in the repository for the given user."
            + " Returning Empty response");
        return emptyPhoneNumber();
    }



    public PhoneNumber emptyPhoneNumber() {
        PhoneNumber phoneNumber = new PhoneNumber();
        User user = new User();
        user.setUserId(-1);
        user.setName("");
        phoneNumber.setCellPhone("");
        phoneNumber.setWorkPhone("");
        phoneNumber.setUser(user);
        return phoneNumber;
    }
}
