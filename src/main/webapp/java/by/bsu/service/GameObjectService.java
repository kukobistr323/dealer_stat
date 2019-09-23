package by.bsu.service;

import by.bsu.entity.GameObject;

import java.util.List;

public interface GameObjectService {
    GameObject addGameObject(GameObject gameObject);
    void delete(long id);
    GameObject getGameObjectById(long id);
    GameObject editGameObject(long id, GameObject newGameObject);
    List<GameObject> getAll();
}
