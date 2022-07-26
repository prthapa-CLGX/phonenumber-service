package com.poc.phonenumberservice.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@Entity
public class PhoneNumber {

    @EmbeddedId
    private User user;
    private String cellPhone;
    private String workPhone;
}
