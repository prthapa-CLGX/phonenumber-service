package com.poc.phonenumberservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poc.phonenumberservice.model.PhoneNumber;
import com.poc.phonenumberservice.model.User;


@SpringBootTest
@RunWith(SpringRunner.class)
class PhoneServiceImplTest {

    @Autowired
    PhoneService phoneService;

    @Test
    void shouldGetPhoneNumberForAUser() {
        User user = new User();
        user.setUserId(1);
        user.setName("Alex Robinson");

        PhoneNumber phoneNumber = phoneService.getPhoneNumberForAUser(user);
        assertThat(phoneNumber.getWorkPhone()).isEqualTo("969-123-4567");
    }
}