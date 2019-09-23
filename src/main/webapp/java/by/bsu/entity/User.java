package by.bsu.entity;

import by.bsu.entity.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    @Column(name = "first_name")
    private String firstName;
    @NonNull
    @Column(name = "last_name")
    private String lastName;
    @NonNull
    @Column(name = "password")
    private String password;
    @NonNull
    @Column(name = "email")
    private String email;
    @NonNull
    @Column(name = "created_at")
    private Date creationDate;
    @NonNull
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @ToString.Exclude
    @JsonIgnore
    private Set<Comment> comments = new HashSet<>();

    public void addComent(Comment comment) {
        comment.setUser(this);
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @ToString.Exclude
    @JsonIgnore
    private Set<GameObject> gameObjects = new HashSet<>();

    public void addGameObject(GameObject gameObject) {
        gameObject.setUser(this);
        gameObjects.add(gameObject);
    }

    public void removeGameObject(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }
}
