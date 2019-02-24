package com.msl.integration.amqppublisher.amqppublisher.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.msl.integration.amqppublisher.amqppublisher.api.dto.MessageDTO;
import com.msl.integration.amqppublisher.amqppublisher.api.dto.PublishMessageDTO;
import com.msl.integration.amqppublisher.amqppublisher.publisher.AMQPPublisher;
import com.msl.integration.amqppublisher.amqppublisher.service.ApplicationService;

import lombok.extern.slf4j.Slf4j;

/**
 * Sample service implementation.
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
@Service
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private AMQPPublisher publisher;

	@Override
	public void publishInDeviceConfiguration(PublishMessageDTO publishMessage) throws IOException {
		int numPub = publishMessage.getNumMessages();
		for (int i = 0; i < numPub; i++) {
			publisher.publishInDeviceConfiguration(publishMessage.getMessage());
		}
	}

	@Async
	private void publishMessage(MessageDTO message) throws IOException {
		publisher.publishInDeviceConfiguration(message);
	}

}
