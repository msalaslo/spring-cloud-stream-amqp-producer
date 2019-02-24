package com.msl.integration.amqppublisher.amqppublisher.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Sample DTO object. <b>Please remove for actual project implementation.</b>
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublishMessageDTO extends BaseDTO {

    @ApiModelProperty(notes = "Number of times to publish the message ", required = true)
    private int numMessages;

    @ApiModelProperty(notes = "Message to publish ", required = true)
    private MessageDTO message;

}
