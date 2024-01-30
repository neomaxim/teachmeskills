package test45.service;

import org.springframework.stereotype.Service;
import test45.Post;
import test45.repository.PostRepository;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void savePost(Post post) {

    }

}