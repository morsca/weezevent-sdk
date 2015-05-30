package com.morsca.weezevent.serialization;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.morsca.weezevent.domain.WeezeventCategory;
import com.morsca.weezevent.domain.WeezeventEvent;
import com.morsca.weezevent.domain.WeezeventTicket;
import com.morsca.weezevent.response.WeezeventEventsResponse;

public class TestWeezeventGetTickets {

	private final ObjectMapper mapper = new ObjectMapper();
	
	@Before
	public void before() {
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		mapper.setDateFormat(new SimpleDateFormat("yyy-MM-dd HH:mm:ss", Locale.ROOT));
	}
	
	@Test
	public void testWeezeventGetTickets() throws Exception {
		WeezeventEventsResponse eventsResponse = mapper.readValue(ClassLoader.getSystemResourceAsStream("getTickets.json"), WeezeventEventsResponse.class);
		
		Assert.assertNotNull(eventsResponse.getEvents());
		Assert.assertFalse(eventsResponse.getEvents().isEmpty());
		
		Iterator<WeezeventEvent> eventsIterator = eventsResponse.getEvents().iterator();
		WeezeventEvent event = eventsIterator.next();
		
		Assert.assertEquals(11435, event.getId());
		Assert.assertEquals("Event 1", event.getName());
		Assert.assertNotNull(event.getTickets());
		Assert.assertFalse(event.getTickets().isEmpty());
		
		Iterator<WeezeventTicket> ticketsIterator = event.getTickets().iterator();
		WeezeventTicket ticket = ticketsIterator.next();
		Assert.assertEquals("75632", ticket.getId());
		Assert.assertEquals("b1", ticket.getName());
		Assert.assertEquals(10, ticket.getPrice(), 0);
		Assert.assertEquals(110, ticket.getParticipants());
		Assert.assertEquals(400, ticket.getQuota());
		
		Assert.assertTrue(ticketsIterator.hasNext());
		ticket = ticketsIterator.next();
		Assert.assertEquals("ABCDE125632", ticket.getId());
		Assert.assertEquals("Tarif 2", ticket.getName());
		Assert.assertEquals(12, ticket.getPrice(), 0);
		Assert.assertEquals(800, ticket.getParticipants());
		Assert.assertEquals(1200, ticket.getQuota());
		
		Iterator<WeezeventCategory> categoryIterator = event.getCategories().iterator();
		WeezeventCategory category = categoryIterator.next();
		Assert.assertEquals(11745, category.getId());
		Assert.assertEquals("Categorie 1", category.getName());
		
		ticketsIterator = category.getTickets().iterator();
		ticket = ticketsIterator.next();
		Assert.assertEquals("44272", ticket.getId());
		Assert.assertEquals("b2", ticket.getName());
		Assert.assertEquals(9.99, ticket.getPrice(), 0);
		Assert.assertEquals(99, ticket.getParticipants());
		Assert.assertEquals(0, ticket.getQuota());
		
		categoryIterator = category.getCategories().iterator();
		category = categoryIterator.next();
		Assert.assertEquals(11746, category.getId());
		Assert.assertEquals("Sous Categorie 1", category.getName());
		
		ticketsIterator = category.getTickets().iterator();
		ticket = ticketsIterator.next();
		Assert.assertEquals("65632", ticket.getId());
		Assert.assertEquals("b3", ticket.getName());
		Assert.assertEquals(0, ticket.getPrice(), 0);
		Assert.assertEquals(210, ticket.getParticipants());
		Assert.assertEquals(0, ticket.getQuota());
		
		Assert.assertTrue(ticketsIterator.hasNext());
		ticket = ticketsIterator.next();
		Assert.assertEquals("65638", ticket.getId());
		Assert.assertEquals("b4", ticket.getName());
		Assert.assertEquals(10, ticket.getPrice(), 0);
		Assert.assertEquals(190, ticket.getParticipants());
		Assert.assertEquals(0, ticket.getQuota());
		
		Assert.assertTrue(eventsIterator.hasNext());
		event = eventsIterator.next();
		Assert.assertEquals(10473, event.getId());
		Assert.assertEquals("Event 2", event.getName());
		
		ticketsIterator = event.getTickets().iterator();
		ticket = ticketsIterator.next();
		Assert.assertEquals("40413", ticket.getId());
		Assert.assertEquals("Billet 1", ticket.getName());
		Assert.assertEquals(10, ticket.getPrice(), 0);
		Assert.assertEquals(0, ticket.getParticipants());
		Assert.assertEquals(100, ticket.getQuota());
		
		categoryIterator = event.getCategories().iterator();
		category = categoryIterator.next();
		Assert.assertEquals(4654, category.getId());
		Assert.assertEquals("Categorie 1", category.getName());
		
		ticketsIterator = category.getTickets().iterator();
		ticket = ticketsIterator.next();
		Assert.assertEquals("42637", ticket.getId());
		Assert.assertEquals("Billet 2", ticket.getName());
		Assert.assertEquals(0, ticket.getPrice(), 0);
		
		categoryIterator = category.getCategories().iterator();
		category = categoryIterator.next();
		Assert.assertEquals(4655, category.getId());
		Assert.assertEquals("Sous categorie 1", category.getName());
		
		ticketsIterator = category.getTickets().iterator();
		ticket = ticketsIterator.next();
		Assert.assertEquals("42638", ticket.getId());
		Assert.assertEquals("Billet 3", ticket.getName());
		Assert.assertEquals(10, ticket.getPrice(), 0);
		Assert.assertEquals(110, ticket.getParticipants());
		Assert.assertEquals(110, ticket.getQuota());
	}
}
