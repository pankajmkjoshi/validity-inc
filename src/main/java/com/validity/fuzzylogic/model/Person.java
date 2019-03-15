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

    @Override
    public int hashCode() {
        return Objects.hash(phoneticScore);
    }

    @Override
    public boolean equals(Object o) {
        Person person;
        if (!(o instanceof Person)) {
            return false;
        } else {
            person = (Person) o;
            if (this.phoneticScore.equals(person.getPhoneticScore())) {
                return true;
            }
        }
        return false;
    }
}
