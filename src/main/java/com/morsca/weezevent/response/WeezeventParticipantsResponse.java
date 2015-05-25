package com.morsca.weezevent.response;

import java.util.Collection;
import java.util.Date;

import com.morsca.weezevent.domain.WeezeventParticipant;

public class WeezeventParticipantsResponse {

	private Collection<WeezeventParticipant> participants;
	
	private Date serverTime;

	public Collection<WeezeventParticipant> getParticipants() {
		return participants;
	}

	public void setParticipants(Collection<WeezeventParticipant> participants) {
		this.participants = participants;
	}

	public Date getServerTime() {
		return serverTime;
	}

	public void setServerTime(Date serverTime) {
		this.serverTime = serverTime;
	}
	
}
