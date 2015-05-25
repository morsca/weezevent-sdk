package com.morsca.weezevent.serialization;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.morsca.weezevent.domain.WeezeventTicketStats;
import com.morsca.weezevent.response.WeezeventTicketStatsResponse;

public class TestWeezeventGetTicketStats {

	private final ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void testWeezeventGetDates() throws Exception {
		WeezeventTicketStatsResponse ticketStatsResponse = mapper.readValue(ClassLoader.getSystemResourceAsStream("getTicketStats.json"), WeezeventTicketStatsResponse.class);
		
		Assert.assertNotNull(ticketStatsResponse.getStats());
		WeezeventTicketStats ticketStats = ticketStatsResponse.getStats();

		Assert.assertEquals(23, ticketStats.getTotal());
		Assert.assertEquals(18, ticketStats.getScanned());
		Assert.assertEquals(18, ticketStats.getIn());
		Assert.assertEquals(0, ticketStats.getOut());
	}
}
