package com.example.wschat.controller;

import com.example.wschat.dto.Greeting;
import com.example.wschat.dto.NameMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")       // if a msg is sent to /hello, call greet()
    @SendTo("/topic/greetings")     // return value is broadcast to all subscribers of /topic/greetings
    public Greeting greet(NameMessage name) throws Exception {

        Thread.sleep(1000);     // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(name.getName()) + "!");
    }
}
