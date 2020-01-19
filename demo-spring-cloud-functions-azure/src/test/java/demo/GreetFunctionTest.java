package demo;

import demo.greeting.Greeting;
import demo.greeting.User;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

import static org.assertj.core.api.Assertions.assertThat;


public class GreetFunctionTest {

    @Test
    public void greetFunctionPlain() {
        Greeting result = new AzureFunctionApp().greet().apply(new User("World"));
        assertThat(result.getMessage()).isEqualTo("Hello, World");
    }

    @Test
    public void greetFunctionBehindAzureRequestHandlerWrapper() {

        try (AzureSpringBootRequestHandler<User, Greeting> handler =
                     new AzureSpringBootRequestHandler<>(AzureFunctionApp.class)) {

            Greeting result = handler.handleRequest(new User("World"), null);
            assertThat(result.getMessage()).isEqualTo("Hello, World");
        }

    }
}