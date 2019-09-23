package by.bsu.service;

import by.bsu.entity.Game;

import java.util.List;

public interface GameService {
    Game addGame(Game game);

    void delete(long id);

    Game getGameById(long id);

    Game editGame(long id, Game game);

    List<Game> getAll();
}
