package com.neeraj.Social_Media_Platform.repository;

import com.neeraj.Social_Media_Platform.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findBySenderIdAndRecipientIdOrRecipientIdAndSenderIdOrderByCreatedAtAsc(
            Long senderId,
            Long recipientId,
            Long recipientId2,
            Long senderId2
    );
}

