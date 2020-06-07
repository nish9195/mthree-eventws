package com.mthree.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.models.Event;
import com.mthree.models.User;
import com.mthree.services.EventService;

@RestController
public class EventRestController {
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private UserRestController userRestController;
	
	@GetMapping("/events")
	public List<Event> events()
	{
		return eventService.findEvents();
	}
	
	@GetMapping("/events/{id}")
	public Event getEvent(@PathVariable("id") int id)
	{
		return eventService.getEvent(id);
	}
	
	@PostMapping("/events/insert")
	public String insertEvent(@RequestBody Event e)
	{
		Event tmp=eventService.insertEvent(e);
		String s="";
		if(tmp!=null)
			s="Event Inserted Successfully";
		else
			s="Couldn't Insert";
		return s;
	}
	
	@GetMapping("/events/delete/{id}")
	public String deleteEvent(@PathVariable("id") int id)
	{
		eventService.deleteEvent(id);
		return "Event deleted successfully";
	}
	
	@GetMapping("/users/{id}/eventDetails")
	public Event getEventDetails(@PathVariable("id")int id)
	{
		User u=userRestController.getUser(id);
		int eid=u.getEventId();
		Event e=getEvent(eid);
		return e;
	}
	
	@PostMapping("events/edit")
	public String editEvent(@RequestBody Event e)
	{
		boolean b=eventService.editEvent(e.getEventId(), e.getEventName());
		if(b)
			return "Edit Successful";
		else
			return "Couldn't Edit";
	}
	
	@PostMapping("events/{id}/addUser")
	public String addUser(@RequestBody User u,@PathVariable("id") int id)
	{
		User tmp = new User(u.getUserId(),u.getUserName(),id);
		return userRestController.insertUser(tmp);
	}
	
	@GetMapping("events/{id}/deleteUser/{userId}")
	public String addUser(@PathVariable("id") int id,@PathVariable("userId") int userId)
	{
		User u=userRestController.getUser(userId);
		if(u.getEventId()==id)
			return userRestController.deleteUser(userId);
		else
			return "User not part of this event";
	}

}
