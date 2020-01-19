package demo.azure;


import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import demo.greeting.Greeting;
import demo.greeting.User;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

import java.util.Optional;

public class GreetingHandler extends AzureSpringBootRequestHandler<User, Greeting> {

    @FunctionName("greet")
    public Greeting execute(
            @HttpTrigger(name = "request", methods = HttpMethod.POST, authLevel = AuthorizationLevel.ANONYMOUS)
            HttpRequestMessage<Optional<User>> request,
            ExecutionContext context) {

        String username = request.getBody().map(User::getName).orElse("unknown");
        context.getLogger().info(String.format("Handle greeting for username: %s", username));

        // this invokes our greet function
        return handleRequest(request.getBody().get(), context);
    }
}