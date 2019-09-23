package by.bsu.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class Games {

    private static final String NAME = "league of legends";

    public static Game createTestGame() {
        return Game.builder().name(NAME).build();
    }

    @SneakyThrows
    public static String getJsonOfGame() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(createTestGame());
    }
}
