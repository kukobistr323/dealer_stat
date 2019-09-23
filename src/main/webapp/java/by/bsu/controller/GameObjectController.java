package by.bsu.controller;

import by.bsu.entity.Game;
import by.bsu.entity.GameObject;
import by.bsu.entity.User;
import by.bsu.service.GameObjectService;
import by.bsu.service.GameService;
import by.bsu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameObjectController {

    @Autowired
    private GameObjectService gameObjectService;

    @Autowired
    private UserService userService;

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/object/{id}", method = RequestMethod.PUT)
    public GameObject editGameObject(@PathVariable long id, @RequestBody GameObject gameObject) {

        return gameObjectService.editGameObject(id, gameObject);
    }

    @RequestMapping(value = "/object", method = RequestMethod.POST)
    public GameObject addGameObject(@RequestBody GameObject newGameObject) {

        User user = userService.getUserById(newGameObject.getAuthorId());
        user.addGameObject(newGameObject);

        Game game = gameService.getGameById(newGameObject.getGameId());
        game.addGameObject(newGameObject);

        return gameObjectService.addGameObject(newGameObject);
    }

    @RequestMapping(value = "/object", method = RequestMethod.GET)
    public List<GameObject> getGameObjects() {

        return gameObjectService.getAll();
    }

    @RequestMapping(value = "/object/{id}", method = RequestMethod.DELETE)
    public void deleteGameObject(@PathVariable long id){

        GameObject gameObject = gameObjectService.getGameObjectById(id);

        User user = userService.getUserById(gameObject.getAuthorId());
        user.removeGameObject(gameObject);

        Game game = gameService.getGameById(gameObject.getGameId());
        game.removeGameObject(gameObject);

        gameObjectService.delete(id);
    }

}
