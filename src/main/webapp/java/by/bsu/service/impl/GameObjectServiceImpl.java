package by.bsu.service.impl;

import by.bsu.entity.GameObject;
import by.bsu.repository.GameObjectRepository;
import by.bsu.service.GameObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameObjectServiceImpl implements GameObjectService {

    @Autowired
    private GameObjectRepository gameObjectRepository;

    @Override
    public GameObject addGameObject(GameObject gameObject) {
        return gameObjectRepository.saveAndFlush(gameObject);
    }

    @Override
    public void delete(long id) {
        gameObjectRepository.deleteById(id);
    }

    @Override
    public GameObject getGameObjectById(long id) {
        return gameObjectRepository.findById(id).orElse(new GameObject());
    }

    @Override
    public GameObject editGameObject(long id, GameObject newGameObject) {
        GameObject gameObject = getGameObjectById(id);
        gameObject.setCreationDate(newGameObject.getCreationDate());
        gameObject.setStatus(newGameObject.getStatus());
        gameObject.setText(newGameObject.getText());
        gameObject.setTitle(newGameObject.getTitle());
        gameObject.setUpdateDate(newGameObject.getUpdateDate());
        return gameObjectRepository.saveAndFlush(gameObject);
    }

    @Override
    public List<GameObject> getAll() {
        return gameObjectRepository.findAll();
    }
}
