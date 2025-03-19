package com.neeraj.Social_Media_Platform.repository;

import com.neeraj.Social_Media_Platform.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUserId(Long userId); // Find posts by user ID
}

