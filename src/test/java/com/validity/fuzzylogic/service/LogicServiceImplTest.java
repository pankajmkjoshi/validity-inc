package com.validity.fuzzylogic.service;

import com.validity.fuzzylogic.bean.PersonBean;
import com.validity.fuzzylogic.bean.StatisticBean;
import com.validity.fuzzylogic.converter.IDataConverter;
import com.validity.fuzzylogic.model.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public final class LogicServiceImplTest {
    @Autowired
    private LogicService logicService;

    @Autowired
    private IDataConverter<PersonBean, Person> logicModelToBeanConverter;

    @Test
    public void testProcessNormalCSV() {
        final StatisticBean statisticBean = logicService.processNormalCSV();

        Assert.assertThat(statisticBean.getTotalItems(), is(106));
        Assert.assertThat(statisticBean.getNumberOfDuplicate(), is(8));
        Assert.assertThat(statisticBean.getNumberOfNonDuplicate(), is(90));

        assertThat(statisticBean.getDuplicate(), containsInAnyOrder(
                hasProperty("first_name", is("Kale")),
                hasProperty("first_name", is("Barney")),
                hasProperty("first_name", is("Jacquelyn")),
                hasProperty("first_name", is("Rouvin")),
                hasProperty("first_name", is("Gunther")),
                hasProperty("first_name", is("Leonard")),
                hasProperty("first_name", is("Stanfield")),
                hasProperty("first_name", is("Thekla"))

        ));
    }
}
