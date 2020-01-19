Fn Project Example
-----

Follow the [quickstart instructions](https://github.com/fnproject/fn#quickstart) 

# Running the example

Start FN Server via `fn start`. This will download the fn server docker image and start the server container.

```
fn start
```

> Create a Java example project
```
fn init --runtime java hello-fn
```

> We need to create an "app" which acts as a top-level collection of functions and other elements
```
cd hello-fn
fn create app hello-fn-app
```

> Deploy your function
```
fn deploy --app hello-fn-app --local
```
Note: --local flag will skip the push to remote container registry making local development faster

> Invoke your function via command line
```
fn invoke hello-fn-app hello-fn
```

> Optionally start fn Project UI
```
docker run --rm -it --link fnserver:api -p 4000:4000 --name ui -e "FN_API_URL=http://api:8080" fnproject/ui
```
Browse to http://localhost:4000

Click hello-fn-app, click "Run Function" for hello-fn.


> Optionally use Apache Bench to check concurrent function execution
```
echo Demo > postBody.txt
ab -k -c 5 -n 1000 -p postBody.txt http://localhost:8080/invoke/01DYWHZY34NG8G00GZJ0000AS7
 ```
[Explain Shell for ab](https://explainshell.com/explain?cmd=ab+-k+-c+5+-n+1000+-p+postBody.txt+http%3A%2F%2Flocalhost%3A8080%2Finvoke%2Fxyz)

While this command runs look at the docker-containers spawned on the docker host `docker ps`. 
You should see a few containers that remain there for at least 30 seconds before they are remove by the fn server.

> Delete the function
```
fn delete function hello-fn-app hello-fn
```

> Delete the app
```
fn delete app hello-app
```

> Stop server
```
fn stop
```
