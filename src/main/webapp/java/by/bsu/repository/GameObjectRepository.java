package by.bsu.repository;

import by.bsu.entity.GameObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameObjectRepository extends JpaRepository<GameObject, Long> {
}
