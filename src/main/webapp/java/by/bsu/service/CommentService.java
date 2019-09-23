package by.bsu.service;

import by.bsu.entity.Comment;

import java.util.List;
import java.util.Set;

public interface CommentService {
    Comment addComment(Comment comment);

    void delete(long id);

    Comment editComment(Comment comment);

    Comment getCommentById(long id);

    Set<Comment> getAllCommentsByUserId(long id);

    List<Comment> getAll();
}
