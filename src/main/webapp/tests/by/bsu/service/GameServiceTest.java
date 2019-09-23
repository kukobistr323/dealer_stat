package by.bsu.service;

import by.bsu.config.AppConfig;
import by.bsu.entity.Game;
import by.bsu.repository.GameRepository;
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

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class GameServiceTest {

    @Resource
    private EntityManagerFactory emf;
    private EntityManager em;

    @Autowired
    private GameService gameService;

    @Before
    public void beforeTest() {
        em = emf.createEntityManager();
    }

    @Test
    public void testAdd() {
        Game game = new Game();
        game.setName("name");
        gameService.addGame(game);
    }

    @Test
    public void testGetGame() {
        gameService.getAll().forEach(System.out::println);
    }
}