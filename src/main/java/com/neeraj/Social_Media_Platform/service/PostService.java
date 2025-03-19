package com.neeraj.Social_Media_Platform.service;


import com.neeraj.Social_Media_Platform.model.Post;
import com.neeraj.Social_Media_Platform.model.User;
import com.neeraj.Social_Media_Platform.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final HashtagService hashtagService;
    // ✅ Create Post
    public Post createPost(User user, String content, String imageUrl) {
        Post post = new Post();
        post.setUser(user);
        post.setContent(content);
        post.setImageUrl(imageUrl);
        postRepository.save(post);
        hashtagService.extractAndSaveHashtags(post);

        return postRepository.save(post);
    }

    // ✅ Get All Posts (for a user)
    public List<Post> getPostsByUser(Long userId) {
        return postRepository.findByUserId(userId);
    }

    // ✅ Update Post
    public Post updatePost(Long postId, String content, String imageUrl) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        post.setContent(content);
        post.setImageUrl(imageUrl);

        postRepository.save(post);

        // ✅ Update hashtags
        hashtagService.extractAndSaveHashtags(post);

        return postRepository.save(post);
    }

    // ✅ Delete Post
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        postRepository.delete(post);
    }
}

