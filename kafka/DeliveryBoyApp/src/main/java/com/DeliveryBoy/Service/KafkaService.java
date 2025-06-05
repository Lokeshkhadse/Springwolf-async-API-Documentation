package com.DeliveryBoy.Service;

import com.DeliveryBoy.config.AppConstants;
import com.DeliveryBoy.dto.LocationDTO;
import io.github.springwolf.bindings.kafka.annotations.KafkaAsyncOperationBinding;
import io.github.springwolf.core.asyncapi.annotations.AsyncOperation;
import io.github.springwolf.core.asyncapi.annotations.AsyncPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {       //this is service is used to send msg

    @Autowired
    private KafkaTemplate<String,String>kafkaTemplate;  //by using this we can send msg

    private Logger logger = LoggerFactory.getLogger(KafkaService.class);


    @AsyncPublisher(
            operation = @AsyncOperation(
                    channelName = AppConstants.LOCATION_TOPIC_NAME,
                    description = "Publishes location updates",
                    payloadType = LocationDTO.class
            )
    )
    @KafkaAsyncOperationBinding
    public boolean updateLocation(String location) {
        kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, location);
        logger.info("Location update sent: {}", location);
        return true;
    }
}
