package by.bsu.service.impl;

import by.bsu.entity.Post;
import by.bsu.repository.PostRepository;
import by.bsu.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post addPost(Post post) {
        return postRepository.saveAndFlush(post);
    }

    @Override
    public Post getPostById(long id) {
        return postRepository.findById(id).orElse(new Post());
    }

    @Override
    public void delete(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post editPost(long id, Post newPost) {
        Post post = getPostById(id);
        post.setRating(newPost.getRating());
        post.setApproved(newPost.isApproved());
        post.setTraderId(newPost.getTraderId());
        return postRepository.saveAndFlush(post);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }
}
