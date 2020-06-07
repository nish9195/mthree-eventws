package com.mthree.dto;

public class UserEventDTO {
	
	private int userId;
	
	private String userName;
	
	private int eventId;
	
	private String eventName;

	public UserEventDTO(int userId, String userName, int eventId, String eventName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.eventId = eventId;
		this.eventName = eventName;
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

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@Override
	public String toString() {
		return "UserEventDTO [userId=" + userId + ", userName=" + userName + ", eventId=" + eventId + ", eventName="
				+ eventName + "]";
	}

}
