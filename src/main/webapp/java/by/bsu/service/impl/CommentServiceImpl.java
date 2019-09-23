package by.bsu.service.impl;

import by.bsu.entity.Comment;
import by.bsu.entity.User;
import by.bsu.repository.CommentRepository;
import by.bsu.repository.UserRepository;
import by.bsu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }

    @Override
    public void delete(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment editComment(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }

    @Override
    public Comment getCommentById(long id) {
        return commentRepository.findById(id).orElse(new Comment());
    }

    @Override
    public Set<Comment> getAllCommentsByUserId(long id) {
        return (userRepository.findById(id).orElse(new User())).getComments();
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }
}
