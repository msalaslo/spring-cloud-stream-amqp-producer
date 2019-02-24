package com.msl.integration.amqppublisher.amqppublisher.publisher;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * <p>Publisher.</p>
 * 
 * @author FaaS [faas@securitasdirect.es]
 *
 */
public interface DeviceConfigChannel {
    
    /**
     * <p>Channel for received messages from Device Configuration</p>
     */
    public static final String RABBIT_BINDING_CONSUMER = "ouput1";
   
    
    /**
     *  Method to process received message from Device Configuration.
     * 
     * @return {@link SubscribableChannel}
     */
    @Output(RABBIT_BINDING_CONSUMER)
    public MessageChannel outputForDeviceConfiguration();
    
    
}
