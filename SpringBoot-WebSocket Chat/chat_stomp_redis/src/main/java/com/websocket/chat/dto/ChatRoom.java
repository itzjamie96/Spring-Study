package com.websocket.chat.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class ChatRoom implements Serializable {

    /**
     * Redis에 저장되는 객체들은 Serialize 가능해야 하기때문에 implemet Serializable
     */

    private static final long serilaVersionUID = 1234567890L;

    private String roomId;
    private String name;

    public static ChatRoom create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }

}
