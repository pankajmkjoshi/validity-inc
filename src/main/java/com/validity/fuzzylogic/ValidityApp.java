package com.validity.fuzzylogic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Spring boot application.
 */
@SpringBootApplication
public class ValidityApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidityApp.class);

    public static void main(String[] args) {
        LOGGER.debug("Starting Spring Validity Application.");
        SpringApplication.run(ValidityApp.class, args);
    }
}
