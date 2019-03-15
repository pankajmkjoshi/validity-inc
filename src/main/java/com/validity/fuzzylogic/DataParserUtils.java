package com.validity.fuzzylogic;

import com.validity.fuzzylogic.exception.CustomException;
import com.validity.fuzzylogic.model.Person;
import org.apache.commons.codec.language.DoubleMetaphone;
import org.simpleflatmapper.csv.CsvMapper;
import org.simpleflatmapper.csv.CsvMapperFactory;
import org.simpleflatmapper.csv.CsvParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataParserUtils {
    private static Logger LOGGER = Logger.getLogger("DataParserUtils");

    public static List<Person> parseDataFile(File dataFile) {
        LOGGER.info("Parsing CSV.");
        final DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
        CsvMapper<Person> mapper = configureMapper();

        List<Person> people = new ArrayList<>();
        try {
            CsvParser.mapWith(mapper)
                    .stream( dataFile,
                            (s) -> {
                                s.forEach(person -> {

                                    String personString = person.getFirst_name() + person.getLast_name() + person.getCompany() + person.getEmail() + person.getAddress1() + person.getAddress2() + person.getZip() + person.getCity() +
                                            person.getState_long() + person.getState() + person.getPhone();

                                    person.setPhoneticScore(doubleMetaphone.doubleMetaphone(personString));
                                    people.add(person);

                                });
                                return null;
                            });
        } catch (IOException ioe) {
            LOGGER.log(Level.SEVERE, "Parsing CSV failed.", ioe);

            throw new CustomException("Parsing of csv dint work.");
        }

        LOGGER.info("Parsing successful, parsed " + people.size() + " people!");

        return people;
    }

    private static CsvMapper<Person> configureMapper() {
        return CsvMapperFactory
                .newInstance()
                .ignorePropertyNotFound()
                .newMapper(Person.class);
    }
}
