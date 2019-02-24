package com.msl.integration.amqppublisher.amqppublisher.service;

import java.io.IOException;

import com.msl.integration.amqppublisher.amqppublisher.api.dto.PublishMessageDTO;

/**
 * Sample service interface used as template. <b>Please remove for actual
 * project implementation.</b>
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
public interface ApplicationService {

	/**
	 * Creates an application item.
	 * 
	 * @param applicationItem The application item to create.
	 */
    public void  publishInDeviceConfiguration(PublishMessageDTO applicationItem) throws IOException;
}
