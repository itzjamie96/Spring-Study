package com.example.wschat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration                  // spring configuration class
@EnableWebSocketMessageBroker   // enables WS message handling supported by a message broker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Registers endpoint for SockJS
     * = the SockJS will attempt to connect to /guide-ws and use the best available transport
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/guide-ws").withSockJS();

    }

    /**
     * Configure the message broker
     * @param config
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {

        // enable a simple memory-based message broker to carry the greeting message back to the client
        // on destinations prefixed with "/topic"
        config.enableSimpleBroker("/topic");

        // set prefix "/app" for messages that are bound for methods annotated with @MessageMapping
        // "/app" will be used to define all the message mappings
        // ex) "/app/hello == GreetingController.greet() is mapped to handle
        config.setApplicationDestinationPrefixes("/app");
    }
}
