package by.bsu.entity;

import by.bsu.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "game_object")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class GameObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    @Column(name = "title")
    private String title;
    @NonNull
    @Column(name = "text")
    private String text;
    @NonNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "author_id", insertable = false, updatable = false)
    private long authorId;
    @NonNull
    @Column(name = "created_at")
    private Date creationDate;
    @NonNull
    @Column(name = "updated_at")
    private Date updateDate;
    @Column(name = "game_id", insertable = false, updatable = false)
    private long gameId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "author_id", nullable = false)
    @ToString.Exclude
    @JsonIgnore
    @NonNull
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "game_id", nullable = false)
    @ToString.Exclude
    @JsonIgnore
    @NonNull
    private Game game;
}
