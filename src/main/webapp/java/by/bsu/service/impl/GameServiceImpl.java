package by.bsu.service.impl;

import by.bsu.entity.Game;
import by.bsu.repository.GameRepository;
import by.bsu.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("gameServiceImpl")
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public Game addGame(Game game) {
        return gameRepository.saveAndFlush(game);
    }

    @Override
    public void delete(long id) {
        gameRepository.deleteById(id);
    }

    @Override
    public Game getGameById(long id) {
        return gameRepository.findById(id).orElse(new Game());
    }

    @Override
    public Game editGame(long id,Game newGame) {
        Game game = getGameById(id);
        game.setName(newGame.getName());
        return gameRepository.saveAndFlush(game);
    }

    @Override
    public List<Game> getAll() {
        return gameRepository.findAll();
    }
}
