package by.bsu.config;

import by.bsu.entity.User;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConfigTest {

    @Test
    public void createObjectFromConfiguration() {
        ApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(AppConfig.class);
        User user = applicationContext.getBean(User.class);
        System.out.println(user);
    }
}