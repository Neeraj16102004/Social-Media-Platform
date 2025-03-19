package com.neeraj.Social_Media_Platform.service;

import com.neeraj.Social_Media_Platform.model.Message;
import com.neeraj.Social_Media_Platform.model.User;
import com.neeraj.Social_Media_Platform.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    @Transactional
    public Message sendMessage(User sender, User recipient, String content) {
        Message message = new Message();
        message.setSender(sender);
        message.setRecipient(recipient);
        message.setContent(content);
        return messageRepository.save(message);
    }

    public List<Message> getChatHistory(User user1, User user2) {
        return messageRepository.findBySenderIdAndRecipientIdOrRecipientIdAndSenderIdOrderByCreatedAtAsc(
                user1.getId(), user2.getId(), user1.getId(), user2.getId());
    }
}

