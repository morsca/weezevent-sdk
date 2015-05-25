package com.morsca.weezevent.request;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class WeezeventParticipantsRequest {

	private Collection<Long> eventIds;
	
	private Collection<Long> ticketIds;
	
	private Map<Long, Long> dateIdTicketId;
	
	private Date lastUpdate;
	
	private Boolean includeDeleted;
	
	private Boolean moderation;
	
	private Boolean includeUnpaid;
	
	private Boolean full;
	
	private Boolean minimized;
	
	private Integer max;
	
	private Integer page;

	public Collection<Long> getEventIds() {
		return eventIds;
	}

	public void setEventIds(Collection<Long> eventIds) {
		this.eventIds = eventIds;
	}

	public Collection<Long> getTicketIds() {
		return ticketIds;
	}

	public void setTicketIds(Collection<Long> ticketIds) {
		this.ticketIds = ticketIds;
	}

	public Map<Long, Long> getDateIdTicketId() {
		return dateIdTicketId;
	}

	public void setDateIdTicketId(Map<Long, Long> dateIdTicketId) {
		this.dateIdTicketId = dateIdTicketId;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Boolean getIncludeDeleted() {
		return includeDeleted;
	}

	public void setIncludeDeleted(Boolean includeDeleted) {
		this.includeDeleted = includeDeleted;
	}

	public Boolean getModeration() {
		return moderation;
	}

	public void setModeration(Boolean moderation) {
		this.moderation = moderation;
	}

	public Boolean getIncludeUnpaid() {
		return includeUnpaid;
	}

	public void setIncludeUnpaid(Boolean includeUnpaid) {
		this.includeUnpaid = includeUnpaid;
	}

	public Boolean getFull() {
		return full;
	}

	public void setFull(Boolean full) {
		this.full = full;
	}

	public Boolean getMinimized() {
		return minimized;
	}

	public void setMinimized(Boolean minimized) {
		this.minimized = minimized;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
	
}
