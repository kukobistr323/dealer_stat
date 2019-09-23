package by.bsu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    @Column(name = "message")
    private String message;
    @Column(name = "post_id", insertable = false, updatable = false)
    private long postId;
    @Column(name = "author_id", insertable = false, updatable = false)
    private long authorId;
    @NonNull
    @Column(name = "created_at")
    private Date creationDate;
    @Column(name = "approved", columnDefinition = "TINYINT(1)")
    private boolean approved;
    @Column(name = "rating")
    private int rating;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "author_id")
    @ToString.Exclude
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "post_id")
    @ToString.Exclude
    @JsonIgnore
    private Post post;

}
