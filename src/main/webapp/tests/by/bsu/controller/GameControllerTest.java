package by.bsu.controller;

import by.bsu.config.AppConfig;
import by.bsu.entity.Games;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class GameControllerTest {

    private static final int TEST_ID = 3;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void beforeTest() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetGames() throws Exception {
        mockMvc.perform(get("/games")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testEditGame() throws Exception {
        mockMvc.perform(put("/games/{id}", TEST_ID)
                .contentType(MediaType.APPLICATION_JSON).content(Games.getJsonOfGame()))
                .andDo(print()).andExpect(status().isOk());
    }
}