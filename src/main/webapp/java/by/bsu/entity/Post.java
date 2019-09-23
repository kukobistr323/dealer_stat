package by.bsu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "trader_id")
    private long traderId;
    @Column(name = "rating")
    private int rating;
    @Column(name = "approved", columnDefinition = "TINYINT(1)")
    private boolean approved;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, orphanRemoval = true)
    @ToString.Exclude
    @JsonIgnore
    private Set<Comment> comments = new HashSet<>();

    public void addComment(Comment comment) {
        comment.setPost(this);
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }
}
