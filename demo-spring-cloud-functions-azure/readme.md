Example for running Spring Cloud Function on Azure
----

# Build
Note that Azure functions currently only supports Java 8.

```
mvn package
```

# Install the azure function tools

See:
https://docs.microsoft.com/en-us/azure/azure-functions/functions-run-local#v2

# Testing

## Test locally
```
mvn azure-functions:run

curl -d '{"name":"World"}' http://localhost:7071/api/greet
```

## Debug locally
```
mvn clean package azure-functions:run -DenableDebug=true

# Attach remote debugger to 

```


# Deploy to Azure 

```
# login to azure  
az login

mvn azure-functions:deploy

curl -d '{"name":"World"}' https://thomasdarimont-jm-article-spring-function.azurewebsites.net:7071/api/greet
```
