package com.neeraj.Social_Media_Platform.controller;

import com.neeraj.Social_Media_Platform.model.User;
import com.neeraj.Social_Media_Platform.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/follow")
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;

    // ✅ Follow User
    @PostMapping("/{userId}")
    public void followUser(
            @AuthenticationPrincipal User user,
            @PathVariable Long userId) {
        followService.followUser(user, userId);
    }

    // ✅ Unfollow User
    @DeleteMapping("/{userId}")
    public void unfollowUser(
            @AuthenticationPrincipal User user,
            @PathVariable Long userId) {
        followService.unfollowUser(user, userId);
    }
}

