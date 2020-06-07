package com.mthree.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="event")
public class EventDTO {
	
	@Id
	private int eventId;
	
	private String eventName;
	
	@OneToMany(mappedBy="eventDto")
	private List<UserDTO> userDto;
	
	public EventDTO() {}

	public EventDTO(int eventId, String eventName, List<UserDTO> userDto) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.userDto = userDto;
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

	public List<UserDTO> getUserDto() {
		return userDto;
	}

	public void setUserDto(List<UserDTO> userDto) {
		this.userDto = userDto;
	}

	@Override
	public String toString() {
		return "EventDTO [eventId=" + eventId + ", eventName=" + eventName + ", userDto=" + userDto + "]";
	}
	
	

}
