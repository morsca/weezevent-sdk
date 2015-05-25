package com.morsca.weezevent.serialization;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.morsca.weezevent.domain.WeezeventParticipant;
import com.morsca.weezevent.response.WeezeventParticipantsResponse;

public class TestWeezeventGetPaticipants {

	private final ObjectMapper mapper = new ObjectMapper();
	
	private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	@Before
	public void before() {
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		mapper.setDateFormat(new SimpleDateFormat("yyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void testWeezeventGetParticipants() throws Exception {
		WeezeventParticipantsResponse participantsResponse = mapper.readValue(ClassLoader.getSystemResourceAsStream("getParticipants.json"), WeezeventParticipantsResponse.class);
		
		Assert.assertNotNull(participantsResponse);
		Assert.assertNotNull(participantsResponse.getParticipants());
		Assert.assertEquals(dateFormat.parse("23/01/2014 12:52:19"), participantsResponse.getServerTime());
		Assert.assertFalse(participantsResponse.getParticipants().isEmpty());
		
		Iterator<WeezeventParticipant> participantsIterator = participantsResponse.getParticipants().iterator();
		WeezeventParticipant participant = participantsIterator.next();
		Assert.assertEquals(7759645, participant.getIdParticipant());
		Assert.assertEquals(49015, participant.getIdEvent());
		Assert.assertEquals(0, participant.getIdDate());
		Assert.assertEquals(198251, participant.getIdTicket());
		Assert.assertEquals("7448370", participant.getBarcode());
		Assert.assertEquals("T6E49015O5822", participant.getIdWeezTicket());
		Assert.assertEquals(0, participant.getDeleted());
		Assert.assertEquals("", participant.getComment());
		Assert.assertEquals(dateFormat.parse("23/01/2014 12:41:55"), participant.getCreateDate());
		Assert.assertEquals("saisir", participant.getOrigin());
		Assert.assertEquals(2029446, participant.getIdTransaction());
		Assert.assertEquals(0, participant.getControlStatus().getStatus());
		Assert.assertEquals(dateFormat.parse("00/00/0000 00:00:00"), participant.getControlStatus().getScanDate());
		Assert.assertEquals(0, participant.getControlStatus().getScanUser());
		Assert.assertEquals("", participant.getControlStatus().getScanUserName());
		Assert.assertEquals("", participant.getOwner().getFirstName());
		Assert.assertEquals("", participant.getOwner().getLastName());
		Assert.assertEquals("", participant.getOwner().getEmail());
		Assert.assertEquals("", participant.getOwner().getComment());
		Assert.assertEquals("", participant.getOwner().getCustomField());
		Assert.assertEquals("saisir", participant.getOwner().getOrigin());
		
		participant = participantsIterator.next();
		Assert.assertEquals(7759646, participant.getIdParticipant());
		Assert.assertEquals(49015, participant.getIdEvent());
		Assert.assertEquals(0, participant.getIdDate());
		Assert.assertEquals(198251, participant.getIdTicket());
		Assert.assertEquals("7448371", participant.getBarcode());
		Assert.assertEquals("T7E49015O5822", participant.getIdWeezTicket());
		Assert.assertEquals(0, participant.getDeleted());
		Assert.assertEquals("", participant.getComment());
		Assert.assertEquals(dateFormat.parse("23/01/2014 12:41:55"), participant.getCreateDate());
		Assert.assertEquals("saisir", participant.getOrigin());
		Assert.assertEquals(2029446, participant.getIdTransaction());
		Assert.assertEquals(0, participant.getControlStatus().getStatus());
		Assert.assertEquals(dateFormat.parse("00/00/0000 00:00:00"), participant.getControlStatus().getScanDate());
		Assert.assertEquals(0, participant.getControlStatus().getScanUser());
		Assert.assertEquals("", participant.getControlStatus().getScanUserName());
		Assert.assertEquals("", participant.getOwner().getFirstName());
		Assert.assertEquals("", participant.getOwner().getLastName());
		Assert.assertEquals("", participant.getOwner().getEmail());
		Assert.assertEquals("", participant.getOwner().getComment());
		Assert.assertEquals("", participant.getOwner().getCustomField());
		Assert.assertEquals("saisir", participant.getOwner().getOrigin());
	}
}
