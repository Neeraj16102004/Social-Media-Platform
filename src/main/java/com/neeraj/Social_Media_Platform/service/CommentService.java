package com.neeraj.Social_Media_Platform.service;


import com.neeraj.Social_Media_Platform.model.Comment;
import com.neeraj.Social_Media_Platform.model.Post;
import com.neeraj.Social_Media_Platform.model.User;
import com.neeraj.Social_Media_Platform.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final NotificationService notificationService;

    public Comment addComment(User user, Post post, String content) {
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setContent(content);
        Comment savedComment = commentRepository.save(comment);

        // ✅ Trigger notification
        if (!user.equals(post.getUser())) {
            notificationService.createNotification(
                    post.getUser(),
                    user.getUsername() + " commented on your post"
            );
        }

        return savedComment;
    }

    public List<Comment> getCommentsForPost(Long postId) {
        return commentRepository.findByPostId(postId);
    }
}

