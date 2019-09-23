package by.bsu.controller;

import by.bsu.entity.Game;
import by.bsu.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/games", method = RequestMethod.POST)
    public Game addGame(@RequestBody Game newGame) {

        return gameService.addGame(newGame);
    }

    @RequestMapping(value = "/games/{id}", method = RequestMethod.PUT)
    public Game editGame(@PathVariable long id, @RequestBody Game newGame) {

        return gameService.editGame(id, newGame);
    }

    @RequestMapping(value = "/games", method = RequestMethod.GET)
    public List<Game> getGames() {

        return gameService.getAll();
    }
}
