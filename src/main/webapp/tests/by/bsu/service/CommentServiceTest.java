package by.bsu.service;

import by.bsu.config.AppConfig;
import by.bsu.entity.Comment;
import by.bsu.entity.Comments;
import by.bsu.entity.User;
import by.bsu.repository.UserRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class CommentServiceTest {

    private static final long TEST_USER_ID = 8;


    @Resource
    private EntityManagerFactory emf;
    private EntityManager em;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;


    @Before
    public void beforeTest() {
        em = emf.createEntityManager();
    }

    @Test
    public void testGetCommentsByUser() {
        commentService.getAllCommentsByUserId(7L).forEach(System.out::println);
    }

    @Test
    public void testAddComment() {
        Comment comment = Comments.createTestComment();
        User user = userService.getUserById(TEST_USER_ID);
        user.addComent(comment);
        commentService.addComment(comment);
    }

    @Test
    public void testGetCommentById() {
        Comment comment = commentService.getCommentById(1);
    }
}