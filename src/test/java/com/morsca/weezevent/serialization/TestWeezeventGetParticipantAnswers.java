package com.morsca.weezevent.serialization;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.morsca.weezevent.domain.WeezeventAnswer;
import com.morsca.weezevent.response.WeezeventAnswersResponse;

public class TestWeezeventGetParticipantAnswers {

	private final ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void testWeezeventGetParticipantAnswers() throws Exception {
		WeezeventAnswersResponse answersResponse = mapper.readValue(ClassLoader.getSystemResourceAsStream("getParticipantAnswers.json"), WeezeventAnswersResponse.class);
		
		Assert.assertNotNull(answersResponse.getAnswers());
		Assert.assertFalse(answersResponse.getAnswers().isEmpty());
		Iterator<WeezeventAnswer> answersIterator = answersResponse.getAnswers().iterator();
		
		WeezeventAnswer answer = answersIterator.next();
		Assert.assertEquals("Etes-vous accompagn\\u00e9 par un enfant de - de 12 ans sur votre v\\u00e9lo (si\\u00e8ge v\\u00e9lo enfant ou charrette)?", answer.getLabel());
		Assert.assertEquals("Oui", answer.getValue());
		
		answer = answersIterator.next();
		Assert.assertEquals("Si oui, merci de renseigner les coordonn\\u00e9es de l\\\\'enfant de - de 12 ans", answer.getLabel());
		Assert.assertEquals("Nom", answer.getValue());
	}
}
