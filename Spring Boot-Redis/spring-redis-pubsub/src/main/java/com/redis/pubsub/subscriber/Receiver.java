package com.redis.pubsub.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;


public class Receiver implements MessageListener {

    Logger logger = LoggerFactory.getLogger(Receiver.class);

    // Message = payload from the topic
    @Override
    public void onMessage(Message message, byte[] bytes) {
        logger.info("Consumed event {}", message);
    }
}
