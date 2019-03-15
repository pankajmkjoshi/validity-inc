package com.validity.fuzzylogic.service;

import com.validity.fuzzylogic.DataParserUtils;
import com.validity.fuzzylogic.bean.PersonBean;
import com.validity.fuzzylogic.bean.StatisticBean;
import com.validity.fuzzylogic.converter.IDataConverter;
import com.validity.fuzzylogic.exception.CustomException;
import com.validity.fuzzylogic.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogicServiceImpl implements LogicService {
    private final Logger LOGGER = LoggerFactory.getLogger(LogicServiceImpl.class);

    @Autowired
    private IDataConverter<PersonBean, Person> logicModelToBeanConverter;

    @Override
    public StatisticBean processNormalCSV() {
        LOGGER.debug("Processing noral csv.");
        File file = getFile("classpath:input/normal.csv");

        return getStatisticBean(file);
    }


    @Override
    public StatisticBean processAdvanceCSV() {
        LOGGER.debug("Processing advance csv.");
        File file = getFile("classpath:input/advanced.csv");

        return getStatisticBean(file);
    }

    /**
     * Generates a file to process.
     *
     * @param s Name of the file.
     * @return {@link File} instance.
     */
    private File getFile(String s) {
        File file;
        try {
            file = ResourceUtils.getFile(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CustomException("Some thing wrong happend with file..");
        }
        return file;
    }

    /**
     * Prepares statistic bean for requested file.
     *
     * @param file A {@link File} object.
     * @return {@link StatisticBean}.
     */
    private StatisticBean getStatisticBean(final File file) {
        final List<Person> records = DataParserUtils.parseDataFile(file);
        final List<Person> nonDuplicates = getNonDuplicatePeople(records);
        final List<Person> duplicates = getDuplicatePeople(records);
        final StatisticBean statisticBean = new StatisticBean();
        final List<PersonBean> personBeansDuplicates = logicModelToBeanConverter.convertAll(duplicates, new LinkedList<>());
        final List<PersonBean> personBeansNonDuplicates = logicModelToBeanConverter.convertAll(nonDuplicates, new LinkedList<>());

        statisticBean.setTotalItems(records.size());
        statisticBean.setNumberOfNonDuplicate(nonDuplicates.size());
        statisticBean.setNumberOfDuplicate(duplicates.size());
        statisticBean.setDuplicate(personBeansDuplicates);
        statisticBean.setNonDuplicate(personBeansNonDuplicates);

        return statisticBean;
    }

    /**
     * Prepares the list of duplicate persons in requested list.
     *
     * @param records List of persons.
     * @return List of duplicate persons.
     */
    private List<Person> getDuplicatePeople(final List<Person> records) {
        return records.stream().distinct()
                .filter(x -> Collections.frequency(records, x) > 1).collect(Collectors.toList());
    }

    /**
     * Prepares the list of non-duplicate persons in requested list.
     *
     * @param records List of persons.
     * @return List of non-duplicate persons.
     */
    private List<Person> getNonDuplicatePeople(final List<Person> records) {
        return records.stream()
                .filter(x -> Collections.frequency(records, x) == 1).collect(Collectors.toList());
    }
}
