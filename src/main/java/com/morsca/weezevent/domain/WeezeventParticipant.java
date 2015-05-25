package com.morsca.weezevent.domain;

import java.util.Date;

public class WeezeventParticipant {

	private long idParticipant;
	
	private long idEvent;
	
	private long idDate;
	
	private long idTicket;
	
	private String barcode;
	
	private String idWeezTicket;
	
	private long deleted;
	
	private String comment;
	
	private Date createDate;
	
	private String origin;
	
	private long idTransaction;
	
	private WeezeventParticipantControlStatus controlStatus;
	
	private WeezeventParticipantOwner owner;

	public long getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(long idParticipant) {
		this.idParticipant = idParticipant;
	}

	public long getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(long idEvent) {
		this.idEvent = idEvent;
	}

	public long getIdDate() {
		return idDate;
	}

	public void setIdDate(long idDate) {
		this.idDate = idDate;
	}

	public long getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(long idTicket) {
		this.idTicket = idTicket;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getIdWeezTicket() {
		return idWeezTicket;
	}

	public void setIdWeezTicket(String idWeezTicket) {
		this.idWeezTicket = idWeezTicket;
	}

	public long getDeleted() {
		return deleted;
	}

	public void setDeleted(long deleted) {
		this.deleted = deleted;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public long getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(long idTransaction) {
		this.idTransaction = idTransaction;
	}

	public WeezeventParticipantControlStatus getControlStatus() {
		return controlStatus;
	}

	public void setControlStatus(WeezeventParticipantControlStatus controlStatus) {
		this.controlStatus = controlStatus;
	}

	public WeezeventParticipantOwner getOwner() {
		return owner;
	}

	public void setOwner(WeezeventParticipantOwner owner) {
		this.owner = owner;
	}

}
