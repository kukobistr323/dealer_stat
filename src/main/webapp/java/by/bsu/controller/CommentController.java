package by.bsu.controller;

import by.bsu.entity.Comment;
import by.bsu.entity.Post;
import by.bsu.entity.User;
import by.bsu.service.CommentService;
import by.bsu.service.PostService;
import by.bsu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/articles/{id}/comments", method = RequestMethod.POST)
    public Comment addComment(@PathVariable long id, @RequestBody Comment newComment) {

        Post post = postService.getPostById(id);
        post.setRating((post.getComments().stream().mapToInt(Comment::getRating).sum() + post.getRating())
                / (post.getComments().size() + 1));
        postService.addPost(post);
        post.addComment(newComment);

        User user = userService.getUserById(newComment.getAuthorId());
        user.addComent(newComment);

        return commentService.addComment(newComment);
    }

    @RequestMapping(value = "/articles/{id}/comments", method = RequestMethod.PUT)
    public Comment editComment(@PathVariable long id, @RequestBody Comment comment) {

        Post post = postService.getPostById(id);
        post.setRating(post.getComments().stream().mapToInt(Comment::getRating).sum() / post.getComments().size());
        postService.editPost(id, post);
        return commentService.editComment(comment);
    }

    @RequestMapping(value = "/users/{id}/comments", method = RequestMethod.GET)
    public Set<Comment> getCommentsByUserId(@PathVariable long id) {

        return commentService.getAllCommentsByUserId(id);
    }

    @RequestMapping(value = "/users/{user_id}/comments/{comment_id}", method = RequestMethod.GET)
    public Comment getCommentById(@PathVariable("user_id") long userId,
                                  @PathVariable("comment_id") long commentId) {

        return commentService.getCommentById(commentId);
    }

    @RequestMapping(value = "/users/{user_id}/comments/{comment_id}", method = RequestMethod.DELETE)
    public void deleteCommentById(@PathVariable("user_id") long userId,
                                  @PathVariable("comment_id") long commentId) {

        commentService.delete(commentId);
    }
}
