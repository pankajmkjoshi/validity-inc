package com.validity.fuzzylogic.controller;

import com.validity.fuzzylogic.bean.StatisticBean;
import com.validity.fuzzylogic.service.LogicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validates")
@Api(description = "Service for Validate Data.")
public class LogicController {
    private final Logger LOGGER = LoggerFactory.getLogger(LogicController.class);

    @Autowired
    private LogicService logicService;

    @ApiOperation(value = "Find duplicates and non duplicate from normal CSV.")
    @RequestMapping(value = "/normal", method = RequestMethod.GET)
    public StatisticBean processNormalCSV() {
        LOGGER.debug("Identity duplicates and non duplicates records from normal CSV.");
        return logicService.processNormalCSV();
    }

    @ApiOperation(value = "Find duplicates and non duplicate from advance CSV.")
    @RequestMapping(value = "/advance", method = RequestMethod.GET)
    public StatisticBean processAdvanceCSV() {
        LOGGER.debug("Identity duplicates and non duplicates records from advance CSV.");
        return logicService.processAdvanceCSV();
    }
}
