package by.bsu.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.sql.Date;

public class Comments {

    private static final Date DATE = Date.valueOf("2020-02-02");
    private static final String MESSAGE = "test message";
    private static final int POST_ID = 1000;
    private static final int RATING = 4;
    private static final long AUTHOR_ID = 8;

    public static Comment createTestComment() {
        return Comment.builder().creationDate(DATE).message(MESSAGE).postId(POST_ID).rating(RATING)
                .authorId(AUTHOR_ID).build();
    }

    @SneakyThrows
    public static String getJsonOfComment() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(createTestComment());
    }
}
