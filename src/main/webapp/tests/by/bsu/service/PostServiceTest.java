package by.bsu.service;

import by.bsu.config.AppConfig;
import by.bsu.entity.Posts;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class PostServiceTest {

    private static final int TEST_ID = 1;

    @Resource
    private EntityManagerFactory emf;
    private EntityManager em;

    @Autowired
    private PostService postService;

    @Before
    public void beforeTest() {
        em = emf.createEntityManager();
    }

    @Test
    public void testEditPost() {
        postService.editPost(1, Posts.createTestPost());
    }
}