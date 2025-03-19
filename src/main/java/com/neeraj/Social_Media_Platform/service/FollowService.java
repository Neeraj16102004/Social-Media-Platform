package com.neeraj.Social_Media_Platform.service;


import com.neeraj.Social_Media_Platform.model.User;
import com.neeraj.Social_Media_Platform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final UserRepository userRepository;
    private final NotificationService notificationService;

    @Transactional
    public void followUser(User follower, Long userIdToFollow) {
        if (follower.getId().equals(userIdToFollow)) {
            throw new IllegalArgumentException("You cannot follow yourself");
        }

        User userToFollow = userRepository.findById(userIdToFollow)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (!follower.getFollowing().contains(userToFollow)) {
            follower.getFollowing().add(userToFollow);
            userToFollow.getFollowers().add(follower);

            userRepository.save(follower);
            userRepository.save(userToFollow);

            notificationService.createNotification(
                    userToFollow,
                    follower.getUsername() + " started following you"
            );
        }
    }

    @Transactional
    public void unfollowUser(User follower, Long userIdToUnfollow) {
        User userToUnfollow = userRepository.findById(userIdToUnfollow)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (follower.getFollowing().contains(userToUnfollow)) {
            follower.getFollowing().remove(userToUnfollow);
            userToUnfollow.getFollowers().remove(follower);

            userRepository.save(follower);
            userRepository.save(userToUnfollow);
        }
    }
}

