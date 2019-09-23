package by.bsu.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class Posts {

    private static final int TRADER_ID = 9;
    private static final int RATING = 5;

    public static Post createTestPost() {
        return Post.builder().traderId(9).rating(RATING).build();
    }

    @SneakyThrows
    public static String getJsonOfGame() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(createTestPost());
    }
}
