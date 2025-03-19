package com.neeraj.Social_Media_Platform.controller;

import com.neeraj.Social_Media_Platform.model.Post;
import com.neeraj.Social_Media_Platform.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/hashtag/{tag}")
    public List<Post> searchPostsByHashtag(@PathVariable String tag) {
        return searchService.searchPostsByHashtag(tag);
    }
}

