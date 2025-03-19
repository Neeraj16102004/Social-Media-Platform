package com.neeraj.Social_Media_Platform.service;


import com.neeraj.Social_Media_Platform.model.Post;
import com.neeraj.Social_Media_Platform.repository.HashtagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final HashtagRepository hashtagRepository;

    public List<Post> searchPostsByHashtag(String tag) {
        return hashtagRepository.findByTag(tag)
                .map(hashtag -> List.copyOf(hashtag.getPosts()))
                .orElse(List.of());
    }
}

