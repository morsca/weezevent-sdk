package com.morsca.weezevent.sample;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.morsca.weezevent.WeezeventService;
import com.morsca.weezevent.exception.WeezeventException;
import com.morsca.weezevent.mock.WeezeventClient;
import com.morsca.weezevent.request.WeezeventParticipantsRequest;
import com.morsca.weezevent.response.WeezeventEventsResponse;
import com.morsca.weezevent.response.WeezeventParticipantsResponse;

public class Samples {

	private WeezeventClient client;
	
	private WeezeventService service;
	
	@Before
	public void before() throws WeezeventException {
		client = WeezeventClient.getWeezeventClient("<your API key>");
		service = client.login("username", "password"); //service contains all API methods
	}
	
	@After
	public void after() {
		client.logout();
	}
	
	/**
	 * Example of authentication.
	 * 
	 * @throws WeezeventException
	 */
	@Test
	@SuppressWarnings("unused")
	public void authentication() throws WeezeventException {
		WeezeventClient client = WeezeventClient.getWeezeventClient("<your API key>");
		WeezeventService service = client.login("username", "password"); //service contains all API methods
		WeezeventEventsResponse eventsResponse = service.getEvents();
		//do some stuff...
		client.close();
	}
	
	/**
	 * Example request by id_event, full data.
	 * 
	 * @throws WeezeventException
	 */
	@Test
	@SuppressWarnings("unused")
	public void searchParticipantsByIdEventAndFullData() throws WeezeventException {
		//...
		WeezeventParticipantsRequest weezeventParticipantsRequest = new WeezeventParticipantsRequest();
		weezeventParticipantsRequest.setEventIds(Arrays.asList(11122L, 112331L));
		weezeventParticipantsRequest.setFull(true);
		
		WeezeventParticipantsResponse participantsResponse = service.getParticipants(weezeventParticipantsRequest);
		//do some stuff...
	}
	
	/**
	 * Example request by id_ticket.
	 * 
	 * @throws WeezeventException
	 */
	@Test
	@SuppressWarnings("unused")
	public void searchParticipantsByIdTicket() throws WeezeventException {
		//...
		WeezeventParticipantsRequest weezeventParticipantsRequest = new WeezeventParticipantsRequest();
		weezeventParticipantsRequest.setTicketIds(Arrays.asList(1121223L));
		
		WeezeventParticipantsResponse participantsResponse = service.getParticipants(weezeventParticipantsRequest);
		//do some stuff...
	}
	
	/**
	 * Example request by date_ticket.
	 * 
	 * @throws WeezeventException
	 */
	@Test
	@SuppressWarnings("unused")
	public void searchParticipantsByDateTicket() throws WeezeventException {
		//...
		HashMap<Long, Long> dateIdTicketId = new HashMap<Long, Long>();
		dateIdTicketId.put(138L, 44272L);
		dateIdTicketId.put(138L, 44274L);
		WeezeventParticipantsRequest weezeventParticipantsRequest = new WeezeventParticipantsRequest();
		weezeventParticipantsRequest.setDateIdTicketId(dateIdTicketId);
		
		WeezeventParticipantsResponse participantsResponse = service.getParticipants(weezeventParticipantsRequest);
		//do some stuff...
	}
	
	/**
	 * Example request by date_ticket and id_ticket.
	 * 
	 * @throws WeezeventException
	 */
	@Test
	@SuppressWarnings("unused")
	public void searchParticipantsByDateTicketAndIdTicket() throws WeezeventException {
		//...
		HashMap<Long, Long> dateIdTicketId = new HashMap<Long, Long>();
		dateIdTicketId.put(138L, 44272L);
		dateIdTicketId.put(138L, 44274L);
		WeezeventParticipantsRequest weezeventParticipantsRequest = new WeezeventParticipantsRequest();
		weezeventParticipantsRequest.setDateIdTicketId(dateIdTicketId);
		weezeventParticipantsRequest.setTicketIds(Arrays.asList(1121223L));
		
		WeezeventParticipantsResponse participantsResponse = service.getParticipants(weezeventParticipantsRequest);
		//do some stuff...
	}
	
}
