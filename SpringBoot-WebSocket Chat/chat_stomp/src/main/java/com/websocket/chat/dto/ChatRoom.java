package com.websocket.chat.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class ChatRoom {

    /**
     * STOMP를 이용한 pub/sub 방식을 통해 구독자 관리가 알아서 되기 때문에 웹소켓 세션 관리가 필요 없어짐
     * 발송(=send)도 알아서 되기 때문에 모든 클라이언트에게 메세지를 보내는 메서드를 직접 구현할 필요가 없어짐
     */

    private String roomId;
    private String name;

    public static ChatRoom create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }

}
