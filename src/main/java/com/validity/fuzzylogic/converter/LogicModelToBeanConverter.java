package com.validity.fuzzylogic.converter;

import com.validity.fuzzylogic.bean.PersonBean;
import com.validity.fuzzylogic.model.Person;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * A converter which maps {@link Person} object to {@link PersonBean} object.
 */
@Component
public class LogicModelToBeanConverter extends AbstractDataConverter<PersonBean, Person> {
   @Override
    protected PersonBean performConversion(Person person) {
        final PersonBean personBean = new PersonBean();

        BeanUtils.copyProperties(person, personBean);

        return personBean;
    }
}
