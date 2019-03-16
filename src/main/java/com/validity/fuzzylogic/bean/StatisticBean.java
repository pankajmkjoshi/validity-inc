package com.validity.fuzzylogic.bean;

import lombok.Data;

import java.util.List;

/**
 * Statistic bean behave as a wrapper and carries some other information as well.
 */
@Data
public class StatisticBean {
    private Integer totalItems;
    private Integer numberOfNonDuplicate;
    private Integer numberOfDuplicate;
    private List<PersonBean> nonDuplicate;
    private List<PersonBean> duplicate;
}
