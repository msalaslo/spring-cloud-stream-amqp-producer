package com.msl.integration.amqppublisher.amqppublisher.publisher;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import com.msl.integration.amqppublisher.amqppublisher.api.dto.MessageDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Broker to process received messages from Reception Controller Microservice.
 * </p>
 * 
 * @author FaaS [faas@securitasdirect.es]
 *
 */
@Slf4j
@Service
@EnableBinding(value = DeviceConfigChannel.class)
public class AMQPPublisher {

    @Autowired
    private DeviceConfigChannel channel;
    
    /**
     * <p>
     * Method to process received message from Device Configuration.
     * </p>
     * 
     * @param message {@link ConfigurationChangeResponseDTO} message
     * @throws IOException 
     */
    @SendTo(value = DeviceConfigChannel.RABBIT_BINDING_CONSUMER)
    public void publishInDeviceConfiguration(MessageDTO item) throws IOException {
        channel.outputForDeviceConfiguration().send(message(item));
    }
    private static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val).build();
    }
    
}
