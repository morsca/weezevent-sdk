package com.morsca.weezevent.response;

import java.util.Collection;

import com.morsca.weezevent.domain.WeezeventAnswer;

public class WeezeventAnswersResponse {

	private Collection<WeezeventAnswer> answers;

	public Collection<WeezeventAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(Collection<WeezeventAnswer> answers) {
		this.answers = answers;
	}
	
}
