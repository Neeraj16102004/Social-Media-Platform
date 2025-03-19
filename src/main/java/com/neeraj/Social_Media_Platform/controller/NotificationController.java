package com.neeraj.Social_Media_Platform.controller;

import com.neeraj.Social_Media_Platform.model.Notification;
import com.neeraj.Social_Media_Platform.model.User;
import com.neeraj.Social_Media_Platform.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    // ✅ Get Notifications
    @GetMapping
    public List<Notification> getNotifications(@AuthenticationPrincipal User user) {
        return notificationService.getNotifications(user);
    }

    // ✅ Mark as Read
    @PutMapping("/{notificationId}")
    public void markAsRead(@PathVariable Long notificationId) {
        notificationService.markAsRead(notificationId);
    }
}

