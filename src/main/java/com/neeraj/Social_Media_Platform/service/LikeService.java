package com.neeraj.Social_Media_Platform.service;

import com.neeraj.Social_Media_Platform.model.Like;
import com.neeraj.Social_Media_Platform.model.Post;
import com.neeraj.Social_Media_Platform.model.User;
import com.neeraj.Social_Media_Platform.repository.LikeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final NotificationService notificationService;

    public void likePost(User user, Post post) {
        if (likeRepository.findByUserIdAndPostId(user.getId(), post.getId()).isEmpty()) {
            Like like = new Like();
            like.setUser(user);
            like.setPost(post);
            likeRepository.save(like);

            if (!user.equals(post.getUser())) {
                notificationService.createNotification(
                        post.getUser(),
                        user.getUsername() + " liked your post"
                );
            }
        }
    }
        public void unlikePost(User user, Post post){
            likeRepository.findByUserIdAndPostId(user.getId(), post.getId())
                    .ifPresent(likeRepository::delete);
        }

}
