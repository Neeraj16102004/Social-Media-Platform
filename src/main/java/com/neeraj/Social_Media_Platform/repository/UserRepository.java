package com.neeraj.Social_Media_Platform.repository;


import com.neeraj.Social_Media_Platform.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = {"following"})
    Optional<User> findByUsername(String username);
}

