package com.mthree.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mthree.services.EventService;

@Controller
public class EventController {

	@Autowired
	private EventService eventService;
	
}