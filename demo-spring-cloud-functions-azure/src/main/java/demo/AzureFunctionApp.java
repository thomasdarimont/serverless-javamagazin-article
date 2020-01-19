package demo;

import demo.greeting.Greeting;
import demo.greeting.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class AzureFunctionApp {

    public static void main(String[] args) {
        SpringApplication.run(AzureFunctionApp.class, args);
    }

    @Bean
    public Function<User, Greeting> greet() {
        return user -> new Greeting(String.format("Hello, %s", user.getName()));
    }
}
