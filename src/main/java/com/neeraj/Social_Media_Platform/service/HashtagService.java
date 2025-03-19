package com.neeraj.Social_Media_Platform.service;

import com.neeraj.Social_Media_Platform.model.Hashtag;
import com.neeraj.Social_Media_Platform.model.Post;
import com.neeraj.Social_Media_Platform.repository.HashtagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class HashtagService {

    private final HashtagRepository hashtagRepository;

    private static final Pattern HASHTAG_PATTERN = Pattern.compile("#(\\w+)");

    // ✅ Extract and Associate Hashtags
    @Transactional
    public void extractAndSaveHashtags(Post post) {
        Set<Hashtag> hashtags = new HashSet<>();

        Matcher matcher = HASHTAG_PATTERN.matcher(post.getContent());
        while (matcher.find()) {
            String tag = matcher.group(1).toLowerCase();
            Hashtag hashtag = hashtagRepository.findByTag(tag)
                    .orElseGet(() -> {
                        Hashtag newHashtag = new Hashtag();
                        newHashtag.setTag(tag);
                        return hashtagRepository.save(newHashtag);
                    });
            hashtags.add(hashtag);
        }

        post.setHashtags(hashtags);
    }
}

