package com.mthree.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserDTO {
	
	@Id
	private int userId;
	
	private String userName;
	
	@ManyToOne
	@JoinColumn(name="event_id")
	private EventDTO eventDto;
	
	public UserDTO() {}

	public UserDTO(int userId, String userName, EventDTO eventDto) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.eventDto = eventDto;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public EventDTO getEventDto() {
		return eventDto;
	}

	public void setEventDto(EventDTO eventDto) {
		this.eventDto = eventDto;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", eventDto=" + eventDto + "]";
	}

}
