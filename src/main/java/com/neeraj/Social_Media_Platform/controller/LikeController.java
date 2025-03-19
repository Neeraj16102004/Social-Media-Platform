package com.neeraj.Social_Media_Platform.controller;

import com.neeraj.Social_Media_Platform.model.Post;
import com.neeraj.Social_Media_Platform.model.User;
import com.neeraj.Social_Media_Platform.repository.PostRepository;
import com.neeraj.Social_Media_Platform.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;
    private final PostRepository postRepository;

    @PostMapping("/{postId}")
    public void likePost(@AuthenticationPrincipal User user, @PathVariable Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));
        likeService.likePost(user, post);
    }

    @DeleteMapping("/{postId}")
    public void unlikePost(@AuthenticationPrincipal User user, @PathVariable Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));
        likeService.unlikePost(user, post);
    }
}

