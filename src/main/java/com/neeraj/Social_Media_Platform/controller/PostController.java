package com.neeraj.Social_Media_Platform.controller;


import com.neeraj.Social_Media_Platform.model.Post;
import com.neeraj.Social_Media_Platform.model.User;
import com.neeraj.Social_Media_Platform.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // ✅ Create Post
    @PostMapping
    public Post createPost(
            @AuthenticationPrincipal User user,
            @RequestParam String content,
            @RequestParam(required = false) String imageUrl) {
        return postService.createPost(user, content, imageUrl);
    }

    // ✅ Get All Posts for Current User
    @GetMapping
    public List<Post> getPosts(@AuthenticationPrincipal User user) {
        return postService.getPostsByUser(user.getId());
    }

    // ✅ Update Post
    @PutMapping("/{postId}")
    public Post updatePost(
            @PathVariable Long postId,
            @RequestParam String content,
            @RequestParam(required = false) String imageUrl) {
        return postService.updatePost(postId, content, imageUrl);
    }

    // ✅ Delete Post
    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }
}

