package com.websocket.chat.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.websocket.chat.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RedisSubscriber implements MessageListener {

    private final ObjectMapper objectMapper;
    private final RedisTemplate redisTemplate;
    private final SimpMessageSendingOperations messageSendingOperations;

    /*
    Redis에서 메세지가 publish되면 대기하고 있던 onMessage가 해당 메세지를 받아서 처리
    1) publish된 메세지를 ChatMessage로 변환
    2) 변환한 ChatMessage를 messagingTemplate을 이용해 채팅방의 모든 webSocket 클라이언트에게 전달
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            // redis에서 발행된 데이터를 받아 deserialize
            String publishMessage = (String) redisTemplate.getStringSerializer().deserialize(message.getBody());
            // ChatMessage 객체로 매핑
            ChatMessage roomMessage = objectMapper.readValue(publishMessage, ChatMessage.class);
            // WebSocket 구독자에게 채팅 메세지 보내기
            messageSendingOperations.convertAndSend("/sub/chat/room" + roomMessage.getRoomId(), roomMessage);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
