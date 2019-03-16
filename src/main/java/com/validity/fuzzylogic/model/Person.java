package com.validity.fuzzylogic.model;

import lombok.Data;

import java.util.Objects;

/**
 * Person model instance.
 */
@Data
public class Person {
    private String id;
    private String first_name;
    private String last_name;
    private String company;
    private String email;
    private String address1;
    private String address2;
    private String zip;
    private String city;
    private String state_long;
    private String state;
    private String phone;
    private String phoneticScore;
}
