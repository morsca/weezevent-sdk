# weezevent-sdk

Weezevent Java SDK Client is a Java helper tool to communicate with [Weezevent API](https://api.weezevent.com), 
wich gives access to basic functionalities of the Weezevent Ticketing solution.

This project is based on :
* Jackson 2.5.3
* Apache HttpClient 4.4.1

# compile

The project uses Maven.

```shell
$ mvn install
```

# basic usage

```java
WeezeventClient client = WeezeventClient.getWeezeventClient("<your API key>");
WeezeventService service = client.login("username", "password"); //service contains all API methods
WeezeventEventsResponse eventsResponse = service.getEvents();
//do some stuff...
client.close();
```
