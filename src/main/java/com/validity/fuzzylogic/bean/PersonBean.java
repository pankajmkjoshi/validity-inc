package com.validity.fuzzylogic.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Objects;

/**
 * Person bean which act as a DTO to form a response for client.
 */
@Data
@JsonIgnoreProperties(value = { "phoneticScore" })
public class PersonBean {
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
        PersonBean personBean;
        if (!(o instanceof PersonBean)) {
            return false;
        } else {
            personBean = (PersonBean) o;
            if (this.phoneticScore.equals(personBean.getPhoneticScore())) {
                return true;
            }
        }
        return false;
    }
}
