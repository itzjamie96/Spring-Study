package com.websocket.chat.service;

import com.websocket.chat.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RedisPublisher {
    private final RedisTemplate<String, Object> redisTemplate;
    
    /*
    채팅방에 입장해 메세지를 작성하면 해당 메세지를 Redis Topic에 발행하는 기능
    대기하고 있던 redis 구독서비스가 메세지를 처리
     */
    public void publish(ChannelTopic topic, ChatMessage message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}
