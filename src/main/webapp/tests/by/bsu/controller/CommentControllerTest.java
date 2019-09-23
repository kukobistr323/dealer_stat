package by.bsu.controller;

import by.bsu.config.AppConfig;
import by.bsu.entity.Comment;
import by.bsu.entity.Comments;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class CommentControllerTest {

    private static final long TEST_POST_ID = 1;
    private static final long TEST_USER_ID = 8;
    private static final long TEST_COMMENT_ID = 8;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void beforeTest() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testAddNewComment() throws Exception {
        mockMvc.perform(post("/articles/{id}/comments", TEST_POST_ID)
                .contentType(MediaType.APPLICATION_JSON).content(Comments.getJsonOfComment()))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testGetCommentsByUserId() throws Exception {
        mockMvc.perform(get("/users/{id}/comments", TEST_USER_ID)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCommentById() throws Exception {
        mockMvc.perform(get("/users/{user_id}/comments/{comment_id}", TEST_USER_ID, TEST_COMMENT_ID))
                .andDo(print()).andExpect(status().isOk());
    }
}