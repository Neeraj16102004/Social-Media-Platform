package com.neeraj.Social_Media_Platform.controller;


import com.neeraj.Social_Media_Platform.model.Comment;
import com.neeraj.Social_Media_Platform.model.Post;
import com.neeraj.Social_Media_Platform.model.User;
import com.neeraj.Social_Media_Platform.repository.PostRepository;
import com.neeraj.Social_Media_Platform.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final PostRepository postRepository;

    @PostMapping("/{postId}")
    public Comment addComment(@AuthenticationPrincipal User user,
                              @PathVariable Long postId,
                              @RequestParam String content) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));
        return commentService.addComment(user, post, content);
    }

    @GetMapping("/{postId}")
    public List<Comment> getComments(@PathVariable Long postId) {
        return commentService.getCommentsForPost(postId);
    }
}

