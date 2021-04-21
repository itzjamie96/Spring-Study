package com.websocket.chat.config;

import com.websocket.chat.handler.WebSocketHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@RequiredArgsConstructor
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final WebSocketHandler webSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // set endpoint for websocket
        // CORS: setAllowedOrigins("*") <= allows access from anywhere
        registry.addHandler(webSocketHandler, "/ws/chat").setAllowedOrigins("*");
        // websocket은 별개의 프로토콜 => http가 아닌 ws로 시작
        // ex: ws:localhost:8080/ws/chat
    }
}
