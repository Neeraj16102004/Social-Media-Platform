package com.neeraj.Social_Media_Platform.repository;

import com.neeraj.Social_Media_Platform.model.Like;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    @EntityGraph(attributePaths = {"post", "user"})
    Optional<Like> findByUserIdAndPostId(Long userId, Long postId);
}

