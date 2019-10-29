package com.msl.integration.amqppublisher.amqppublisher.api.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.msl.integration.amqppublisher.amqppublisher.api.dto.MessageDTO;
import com.msl.integration.amqppublisher.amqppublisher.api.dto.PublishMessageDTO;
import com.msl.integration.amqppublisher.amqppublisher.service.ApplicationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * Sample controller used as template. <b>Please remove for actual project implementation.</b>
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
@Slf4j
@RestController
@RequestMapping("/application")
@Api(value = "Application demo")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;
       
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create an application item")
    public void createAlert(@Valid @RequestBody PublishMessageDTO request) throws IOException{
        LOGGER.info("Creating an item: {}", request.toString());
        applicationService.publishInDeviceConfiguration(request);
    }
    
    @GetMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    @ApiOperation(value = "Get an application item")
    public MessageDTO testGet() throws IOException{
        LOGGER.debug("test GET: {}");
        MessageDTO item = new MessageDTO();
        item.setApplicationCode("1");
        item.setApplicationDescription("appDescription");
        LOGGER.debug("test GET: {}", item);

        return item;
    }
   
}
