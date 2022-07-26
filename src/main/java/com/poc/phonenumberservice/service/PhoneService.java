package com.poc.phonenumberservice.service;

import com.poc.phonenumberservice.model.PhoneNumber;
import com.poc.phonenumberservice.model.User;

public interface PhoneService {

    PhoneNumber getPhoneNumberForAUser(User user);

}
