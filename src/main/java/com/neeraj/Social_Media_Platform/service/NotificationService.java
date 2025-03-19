package com.neeraj.Social_Media_Platform.service;

import com.neeraj.Social_Media_Platform.model.Notification;
import com.neeraj.Social_Media_Platform.model.User;
import com.neeraj.Social_Media_Platform.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    // ✅ Create Notification
    public void createNotification(User recipient, String message) {
        Notification notification = new Notification();
        notification.setRecipient(recipient);
        notification.setMessage(message);
        notificationRepository.save(notification);
    }

    // ✅ Get Notifications for User
    public List<Notification> getNotifications(User user) {
        return notificationRepository.findByRecipientIdOrderByCreatedAtDesc(user.getId());
    }

    // ✅ Mark Notification as Read
    public void markAsRead(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new IllegalArgumentException("Notification not found"));

        notification.setRead(true);
        notificationRepository.save(notification);
    }
}

