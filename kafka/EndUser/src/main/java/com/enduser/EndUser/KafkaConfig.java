package com.enduser.EndUser;

import io.github.springwolf.bindings.kafka.annotations.KafkaAsyncOperationBinding;
import io.github.springwolf.core.asyncapi.annotations.AsyncListener;
import io.github.springwolf.core.asyncapi.annotations.AsyncOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    @AsyncListener(
            operation = @AsyncOperation(
                    channelName = AppConstants.LOCATION_UPDATE_TOPIC,
                    description = "Consumes location updates from the delivery service"
            )
    )
    @KafkaAsyncOperationBinding
    @KafkaListener(topics=AppConstants.LOCATION_UPDATE_TOPIC , groupId = AppConstants.GROUP_ID )
    public void updatedLocation(String value){

        System.out.println(value);
    }
}
