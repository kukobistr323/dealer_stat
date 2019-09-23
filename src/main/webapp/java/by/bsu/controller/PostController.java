package by.bsu.controller;

import by.bsu.entity.Post;
import by.bsu.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    public Post addPost(@RequestBody Post newPost) {

        return postService.addPost(newPost);
    }

    @RequestMapping(value = "/my", method = RequestMethod.GET)
    public List<Post> getGames() {

        return postService.getAll();
    }
}
