package com.neeraj.Social_Media_Platform.controller;


import com.neeraj.Social_Media_Platform.model.Message;
import com.neeraj.Social_Media_Platform.model.User;
import com.neeraj.Social_Media_Platform.repository.UserRepository;
import com.neeraj.Social_Media_Platform.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;
    private final UserRepository userRepository;

    // ✅ Send Message
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message sendMessage(@AuthenticationPrincipal User sender, @RequestBody Message message) {
        User recipient = userRepository.findById(message.getRecipient().getId())
                .orElseThrow(() -> new IllegalArgumentException("Recipient not found"));

        return messageService.sendMessage(sender, recipient, message.getContent());
    }

    // ✅ Get Chat History
    @GetMapping("/{recipientId}")
    public List<Message> getChatHistory(
            @AuthenticationPrincipal User sender,
            @PathVariable Long recipientId) {

        User recipient = userRepository.findById(recipientId)
                .orElseThrow(() -> new IllegalArgumentException("Recipient not found"));

        return messageService.getChatHistory(sender, recipient);
    }
}

