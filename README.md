# weezevent-sdk

Weezevent Java SDK Client is a Java helper tool to communicate with [Weezevent API](https://api.weezevent.com), 
which gives access to basic functionalities of the Weezevent Ticketing solution.

This project is based on :
* Jackson 2.5.3
* Apache HttpClient 4.4.1 (or Spring RestTemplate)

## compile

The project uses Maven.

```shell
$ mvn install
```

## dependency

Add the Maven dependency in your pom.xml file :

```xml
<dependency>
	<groupId>com.morsca.weezevent</groupId>
	<artifactId>weezevent-sdk</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>
```

## samples

### authentication

```java
WeezeventClient client = WeezeventClient.getWeezeventClient("<your API key>");
WeezeventService service = client.login("username", "password"); //service contains all API methods
WeezeventEventsResponse eventsResponse = service.getEvents();
//do some stuff...
client.close();
```

### Example request by id_event, full data.

```java
//...
WeezeventParticipantsRequest weezeventParticipantsRequest = new WeezeventParticipantsRequest();
weezeventParticipantsRequest.setEventIds(Arrays.asList(11122L, 112331L));
weezeventParticipantsRequest.setFull(true);

WeezeventParticipantsResponse participantsResponse = service.getParticipants(weezeventParticipantsRequest);
//do some stuff...
```

### Example request by id_ticket.

```java
//...
WeezeventParticipantsRequest weezeventParticipantsRequest = new WeezeventParticipantsRequest();
weezeventParticipantsRequest.setTicketIds(Arrays.asList(1121223L));

WeezeventParticipantsResponse participantsResponse = service.getParticipants(weezeventParticipantsRequest);
//do some stuff...
```

### Example request by date_ticket.

```java
//...
HashMap<Long, Long> dateIdTicketId = new HashMap<Long, Long>();
dateIdTicketId.put(138L, 44272L);
dateIdTicketId.put(138L, 44274L);
WeezeventParticipantsRequest weezeventParticipantsRequest = new WeezeventParticipantsRequest();
weezeventParticipantsRequest.setDateIdTicketId(dateIdTicketId);

WeezeventParticipantsResponse participantsResponse = service.getParticipants(weezeventParticipantsRequest);
//do some stuff...
```

### Example request by date_ticket and id_ticket.

```java
//...
HashMap<Long, Long> dateIdTicketId = new HashMap<Long, Long>();
dateIdTicketId.put(138L, 44272L);
dateIdTicketId.put(138L, 44274L);
WeezeventParticipantsRequest weezeventParticipantsRequest = new WeezeventParticipantsRequest();
weezeventParticipantsRequest.setDateIdTicketId(dateIdTicketId);
weezeventParticipantsRequest.setTicketIds(Arrays.asList(1121223L));

WeezeventParticipantsResponse participantsResponse = service.getParticipants(weezeventParticipantsRequest);
//do some stuff...
```