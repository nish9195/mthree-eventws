package com.mthree.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Event {
	
	@Id
	private int eventId;
	
	private String eventName;
	
	public Event() {}

	public Event(int eventId, String eventName) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + "]";
	}
	
	

}
