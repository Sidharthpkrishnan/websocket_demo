package com.example.websocket_demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker; // <-- Add this import
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // <-- THIS IS THE FIX
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // Broadcasts to clients
        config.setApplicationDestinationPrefixes("/app"); // Prefixes for @MessageMapping
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        // Registers the /ws endpoint for connections
        registry.addEndpoint("/ws").withSockJS();
    }
}