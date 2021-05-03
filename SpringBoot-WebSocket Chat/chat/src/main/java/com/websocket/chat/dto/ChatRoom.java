package com.websocket.chat.dto;

import com.websocket.chat.service.ChatService;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ChatRoom {

    // 채팅방 pk
    private String roomId;
    // 채팅방 이름
    private String name;
    // 채팅방은 입장한 클라이언트들의 정보를 가지고 있어야하기 때문에 Set of WebSocketSessions
    private Set<WebSocketSession> sessions = new HashSet<>();

    @Builder
    public ChatRoom(String roomId, String name) {
        this.roomId = roomId;
        this.name = name;
    }
    
    // message Type에 따라 다르게 handle하는 메서드
    public void handleActions(WebSocketSession session, ChatMessage chatMessage, ChatService chatService) {

        // if type of msg is ENTER, send welcoming message to all sessions in chatroom
        if (chatMessage.getType().equals(ChatMessage.MessageType.ENTER)) {
            // add current incoming client to sessions
            sessions.add(session);
            chatMessage.setMessage(chatMessage.getSender() + "님이 입장했습니다.");
        }
        // else send message to all sessions in chatroom
        sendMessage(chatMessage, chatService);
    }

    // send message to each session
    public <T> void sendMessage(T message, ChatService chatService) {
        sessions.parallelStream().forEach(session -> chatService.sendMessage(session, message));
    }

}
