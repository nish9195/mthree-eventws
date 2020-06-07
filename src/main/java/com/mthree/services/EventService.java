package com.mthree.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.models.Event;
import com.mthree.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;
	
	public List<Event> findEvents()
	{
		return eventRepository.findAll();
	}
	
	public Event getEvent(int id)
	{
		Optional<Event> tmp=eventRepository.findById(id);
		if(tmp.isPresent())
			return tmp.get();
		else
			return null;
	}
	
	public void deleteEvent(int id)
	{
		eventRepository.deleteById(id);
	}
	
	public Event insertEvent(Event e)
	{
		return eventRepository.save(e);
	}
	
	public boolean editEvent(int id,String name)
	{
		int i=eventRepository.updateEventNameByEventId(id, name);
		if(i>0)
			return true;
		else
			return false;
	}
	
}
