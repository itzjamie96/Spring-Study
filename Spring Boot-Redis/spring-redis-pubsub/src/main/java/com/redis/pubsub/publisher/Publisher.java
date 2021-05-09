package com.redis.pubsub.publisher;

import com.redis.pubsub.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Publisher {

    // inject redis template
    @Autowired
    private RedisTemplate template;

    @Autowired
    private ChannelTopic topic;

    // publish the even
    @PostMapping("/publish")
    public String publish(@RequestBody Product product) {
        // convert and send to "topic" about "message"
        template.convertAndSend(topic.getTopic(), product.toString());
        return "Event published!";
    }
}
