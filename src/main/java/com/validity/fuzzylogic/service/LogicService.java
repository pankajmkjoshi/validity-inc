package com.validity.fuzzylogic.service;


import com.validity.fuzzylogic.bean.StatisticBean;
import org.springframework.stereotype.Service;

/**
 * A logic service.
 */
public interface LogicService {

    /**
     * Process normal CSV.
     *
     * @return A {@link StatisticBean} object.
     */
    StatisticBean processNormalCSV();

    /**
     * Process advance CSV.
     *
     * @return A {@link StatisticBean} object.
     */
    StatisticBean processAdvanceCSV();
}
