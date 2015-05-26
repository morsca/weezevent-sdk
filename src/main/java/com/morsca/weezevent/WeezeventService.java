package com.morsca.weezevent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import com.morsca.weezevent.domain.WeezeventScanSettings;
import com.morsca.weezevent.exception.WeezeventException;
import com.morsca.weezevent.request.WeezeventEventRequest;
import com.morsca.weezevent.request.WeezeventEventSearchRequest;
import com.morsca.weezevent.request.WeezeventParticipantsRequest;
import com.morsca.weezevent.response.WeezeventAnswersResponse;
import com.morsca.weezevent.response.WeezeventDatesResponse;
import com.morsca.weezevent.response.WeezeventEventCategoriesResponse;
import com.morsca.weezevent.response.WeezeventEventDetailsResponse;
import com.morsca.weezevent.response.WeezeventEventSearchResponse;
import com.morsca.weezevent.response.WeezeventEventsResponse;
import com.morsca.weezevent.response.WeezeventParticipantsResponse;
import com.morsca.weezevent.response.WeezeventScanUserResponse;
import com.morsca.weezevent.response.WeezeventTicketStatsResponse;

public class WeezeventService {

	private final WeezeventClient weezeventClient;
	
	private final DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
	
	protected WeezeventService(final WeezeventClient weezeventClient) {
		this.weezeventClient = weezeventClient;
	}
	
	/**
	 * Returns all events to which the current user (identified by the access token) has access. 
	 * By default, only published events with at least one participant will be returned.
	 * 
	 * @return WeezeventEventsResponse
	 * @throws WeezeventException 
	 */
	public WeezeventEventsResponse getEvents() throws WeezeventException {
		return weezeventClient.get("/events", WeezeventEventsResponse.class);
	}
	
	/**
	 * Returns all events to which the current user (identified by the access token) has access. 
	 * By default, only published events with at least one participant will be returned.
	 * 
	 * @param weezeventEventRequest
	 * @return WeezeventEventsResponse
	 * @throws WeezeventException 
	 */
	public WeezeventEventsResponse getEvents(final WeezeventEventRequest weezeventEventRequest) throws WeezeventException {
		HashMap<String, String> params = new HashMap<String, String>();
		if(weezeventEventRequest.getIncludeNotPublished() != null) { params.put("include_not_published", Boolean.toString(weezeventEventRequest.getIncludeNotPublished())); }
		if(weezeventEventRequest.getIncludeClosed() != null) { params.put("include_closed", Boolean.toString(weezeventEventRequest.getIncludeClosed())); }
		if(weezeventEventRequest.getIncludeWithoutSales() != null) { params.put("include_without_sales", Boolean.toString(weezeventEventRequest.getIncludeWithoutSales())); }
		return weezeventClient.get("/events", params, WeezeventEventsResponse.class);
	}
	
	/**
	 * Events can have either one single or multiple dates. This is indicated in the response of 
	 * get/events with the variable multiple_dates. You can obtain a list of dates for these 
	 * events (multiple_events=1) with this function. Each date is associated with multiple 
	 * tickets (price categories).
	 * 
	 * @param eventId an event identifier
	 * @return WeezeventDatesResponse
	 * @throws WeezeventException 
	 */
	public WeezeventDatesResponse getDates(final String eventId) throws WeezeventException {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("id_event", eventId);
		return weezeventClient.get("/dates", params, WeezeventDatesResponse.class);
	}
	
	/**
	 * Events can have either one single or multiple dates. This is indicated in the response of 
	 * get/events with the variable multiple_dates. You can obtain a list of dates for these 
	 * events (multiple_events=1) with this function. Each date is associated with multiple 
	 * tickets (price categories).
	 * 
	 * @param eventIds a collection of event id
	 * @return WeezeventDatesResponse
	 * @throws WeezeventException 
	 */
	public WeezeventDatesResponse getDates(final Collection<String> eventIds) throws WeezeventException {
		HashMap<String, String> params = new HashMap<String, String>();
		for(String eventId : eventIds) {
			params.put("id_event[]", eventId);
		}
		return weezeventClient.get("/dates", params, WeezeventDatesResponse.class);
	}

	/**
	 * This function returns a list of tickets associated with one or multiple events. Tickets 
	 * represent different price categories (e.g. Tarif Adult, Tarif Enfant) for an event. 
	 * Tickets can be nested into categories and sub-categories. The id of a ticket is most of the 
	 * time an integer value, however in the case of external tickets (distributors) the id can be 
	 * a string.
	 * 
	 * @param eventId an event identifier
	 * @return WeezeventEventsResponse
	 * @throws WeezeventException 
	 */
	public WeezeventEventsResponse getTickets(final String eventId) throws WeezeventException {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("id_event", eventId);
		return weezeventClient.get("/tickets", params, WeezeventEventsResponse.class);
	}
	
	/**
	 * This function returns a list of tickets associated with one or multiple events. Tickets 
	 * represent different price categories (e.g. Tarif Adult, Tarif Enfant) for an event. 
	 * Tickets can be nested into categories and sub-categories. The id of a ticket is most of the 
	 * time an integer value, however in the case of external tickets (distributors) the id can be 
	 * a string.
	 * 
	 * @param eventId a collection of event identifier
	 * @return WeezeventEventsResponse
	 * @throws WeezeventException 
	 */
	public WeezeventEventsResponse getTickets(final Collection<String> eventIds) throws WeezeventException {
		HashMap<String, String> params = new HashMap<String, String>();
		for(String eventId : eventIds) {
			params.put("id_event[]", eventId);
		}
		return weezeventClient.get("/tickets", params, WeezeventEventsResponse.class);
	}
	
	/**
	 * This function is solely used for access control scenarios. It returns the scan statistic for 
	 * one price category.
	 * 
	 * @param ticketId a ticket identifier
	 * @return WeezeventTicketStatsResponse
	 * @throws WeezeventException 
	 */
	public WeezeventTicketStatsResponse getTicketStats(final long ticketId) throws WeezeventException {
		return weezeventClient.get("/tickets/" + ticketId + "/stats", WeezeventTicketStatsResponse.class);
	}
	
	/**
	 * This function returns a list of participants for one or multiple events, one or multiple tickets 
	 * or ticket/date combinations. Depending on the type of inscription form used during the order 
	 * process, either the buyer or the participant himself is indicated as “owner".
	 * 
	 * @param weezeventParticipantsRequest
	 * @return WeezeventParticipantsResponse
	 * @throws WeezeventException 
	 */
	public WeezeventParticipantsResponse getParticipants(final WeezeventParticipantsRequest weezeventParticipantsRequest) throws WeezeventException {
		HashMap<String, String> params = new HashMap<String, String>();
		if(weezeventParticipantsRequest.getEventIds() != null) {
			for(Long eventId : weezeventParticipantsRequest.getEventIds()) {
				params.put("id_event[]", Long.toString(eventId));
			}
		}
		if(weezeventParticipantsRequest.getTicketIds() != null) {
			for(Long ticketId : weezeventParticipantsRequest.getTicketIds()) {
				params.put("id_ticket[]", Long.toString(ticketId));
			}
		}
		if(weezeventParticipantsRequest.getDateIdTicketId() != null) {
			for(Entry<Long, Long> entry : weezeventParticipantsRequest.getDateIdTicketId().entrySet()) {
				params.put("date_ticket[" + Long.toString(entry.getKey()) + "][]",  Long.toString(entry.getValue()));
			}
		}
		if(weezeventParticipantsRequest.getLastUpdate() != null) {params.put("last_update", dateFormat.format(weezeventParticipantsRequest.getLastUpdate())); }
		if(weezeventParticipantsRequest.getIncludeDeleted() != null) { params.put("include_deleted", Boolean.toString(weezeventParticipantsRequest.getIncludeDeleted())); }
		if(weezeventParticipantsRequest.getModeration() != null) { params.put("moderation", Boolean.toString(weezeventParticipantsRequest.getModeration())); }
		if(weezeventParticipantsRequest.getIncludeUnpaid() != null) { params.put("include_unpaid", Boolean.toString(weezeventParticipantsRequest.getIncludeUnpaid())); }
		if(weezeventParticipantsRequest.getFull() != null) { params.put("full", Boolean.toString(weezeventParticipantsRequest.getFull())); }
		if(weezeventParticipantsRequest.getMinimized() != null) { params.put("minimized", Boolean.toString(weezeventParticipantsRequest.getMinimized())); }
		if(weezeventParticipantsRequest.getMax() != null) { params.put("max", Integer.toString(weezeventParticipantsRequest.getMax())); }
		if(weezeventParticipantsRequest.getPage() != null) { params.put("page", Integer.toString(weezeventParticipantsRequest.getPage())); }
		return weezeventClient.get("/participants", params, WeezeventParticipantsResponse.class);
	}
	
	/**
	 * This function returns an array of question/answer data for one participant. If no data was 
	 * collected for this participant, the answers of the buyer are returned.
	 * 
	 * @param participantId a participant identifier
	 * @return WeezeventAnswersResponse
	 * @throws WeezeventException 
	 */
	public WeezeventAnswersResponse getAnswers(final long participantId) throws WeezeventException {
		return weezeventClient.get("/participant/" + participantId + "/answers", WeezeventAnswersResponse.class);
	}
	
	/**
	 * This function is solely used for access control applications. For each user account, the 
	 * settings of the client application can be stored on the Weezevent server.
	 * 
	 * @return WeezeventScanSettings
	 * @throws WeezeventException 
	 */
	public WeezeventScanSettings getScanSettings() throws WeezeventException {
		return weezeventClient.get("/scan/settings", WeezeventScanSettings.class);
	}
	
	/**
	 * This function is solely used for access control applications. Each client application 
	 * (identified by access_token) can give itself a custom name which will be used to 
	 * identify the control station.
	 * 
	 * @param user Name of the user
	 * @return WeezeventScanUserResponse
	 * @throws WeezeventException 
	 */
	public WeezeventScanUserResponse postScanUser(final String user) throws WeezeventException {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("user", user);
		return weezeventClient.post("/scan/settings", params, WeezeventScanUserResponse.class);
	}
	
	/**
	 * This resource Is used for retrieving details for specific event. It returns an array with 
	 * all details.
	 * 
	 * @param eventId an event id
	 * @return WeezeventEventDetailsResponse
	 * @throws WeezeventException 
	 */
	public WeezeventEventDetailsResponse getEventDetails(final long eventId) throws WeezeventException {
		return weezeventClient.get("/event/" + eventId + "/details", WeezeventEventDetailsResponse.class);
	}
	
	/**
	 * This resource Is used for retrieving events depending on some criteria. It returns an array 
	 * with all matching events.
	 * 
	 * @param weezeventEventSearchRequest
	 * @return WeezeventEventSearchResponse
	 * @throws WeezeventException 
	 */
	public WeezeventEventSearchResponse getEventSearch(final WeezeventEventSearchRequest weezeventEventSearchRequest) throws WeezeventException {
		HashMap<String, Object> params = new HashMap<String, Object>();
		if(weezeventEventSearchRequest.getDate() != null) { params.put("date", dateFormat.format(weezeventEventSearchRequest.getDate())); }
		if(weezeventEventSearchRequest.getDateStart() != null) { params.put("date_start", dateFormat.format(weezeventEventSearchRequest.getDateStart())); }
		if(weezeventEventSearchRequest.getDateEnd() != null) { params.put("date_end", dateFormat.format(weezeventEventSearchRequest.getDateEnd())); }
		if(weezeventEventSearchRequest.getCategory() != null) { params.put("category", weezeventEventSearchRequest.getCategory()); }
		if(weezeventEventSearchRequest.getCity() != null) { params.put("city", weezeventEventSearchRequest.getCity()); }
		if(weezeventEventSearchRequest.getZipCode() != null) { params.put("zip_code", weezeventEventSearchRequest.getZipCode()); }
		if(weezeventEventSearchRequest.getCountry() != null) { params.put("country", weezeventEventSearchRequest.getCountry()); }
		if(weezeventEventSearchRequest.getProvince() != null) { params.put("province", weezeventEventSearchRequest.getProvince()); }
		if(weezeventEventSearchRequest.getOrganizer() != null) { params.put("organizer", weezeventEventSearchRequest.getOrganizer()); }
		if(weezeventEventSearchRequest.getMaxResult() != null) { params.put("max_result", weezeventEventSearchRequest.getMaxResult()); }
		return weezeventClient.get("/event/search/", WeezeventEventSearchResponse.class);
	}
	
	/**
	 * This resource Is used for retrieving ours event categories. Access for this list is public. 
	 * So no need for API key and access token.
	 * 
	 * @return WeezeventEventCategoriesResponse
	 * @throws WeezeventException 
	 */
	public WeezeventEventCategoriesResponse getEventCategories() throws WeezeventException {
		return weezeventClient.getAnonymously("/event/categories/", WeezeventEventCategoriesResponse.class);
	}
}
