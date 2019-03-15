package com.validity.fuzzylogic.converter;

import com.validity.fuzzylogic.bean.PersonBean;
import com.validity.fuzzylogic.model.Person;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component(LogicModelToBeanConverter.BEAN_NAME)
public class LogicModelToBeanConverter extends AbstractDataConverter<PersonBean, Person> {
    /**
     * Denotes the bean name used to manage this component.
     */
    static final String BEAN_NAME = "logicModelToBeanConverter";

    @Override
    protected PersonBean performConversion(Person person) {
        final PersonBean personBean = new PersonBean();

        BeanUtils.copyProperties(person, personBean);

        return personBean;
    }
}
