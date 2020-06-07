package com.mthree.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private int userId;
	
	private String userName;
	
	@Column(name="event_id")
	private int eventId;
	
	public User() {}

	public User(int userId, String userName, int eventId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.eventId = eventId;
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

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", eventId=" + eventId + "]";
	}

}
