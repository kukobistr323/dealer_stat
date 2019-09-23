package by.bsu.service;

import by.bsu.entity.Post;

import java.util.List;

public interface PostService {

    Post addPost(Post post);

    Post getPostById(long id);

    void delete(long id);

    Post editPost(long id, Post newPost);

    List<Post> getAll();
}
