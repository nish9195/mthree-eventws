package com.mthree.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.dto.UserEventDTO;
import com.mthree.models.User;
import com.mthree.services.UserService;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> users()
	{
		return userService.findUsers();
	}
	
	@PostMapping("/users/insert")
	public String insertUser(@RequestBody User u)
	{
		User tmp=userService.insertUser(u);
		String s="";
		if(tmp!=null)
			s="User Inserted Successfully";
		else
			s="Couldn't Insert";
		return s;
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable("id") int id)
	{
		return userService.getUser(id);
	}
	
	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable("id") int id)
	{
		userService.deleteUser(id);
		return "User deleted successfully";
	}
	
	@GetMapping("/events/{id}/users")
	public List<User> getUsers(@PathVariable("id") int id)
	{
		return userService.getUsers(id);
	}
	
	@PostMapping("/users/edit")
	public String editUser(@RequestBody User u)
	{
		boolean b=userService.editUser(u.getUserId(), u.getUserName(), u.getEventId());
		if(b)
			return "Edit Successful";
		else
			return "Couldn't Edit";
	}
	
	@GetMapping("/usersWithEventDetails")
	public List<UserEventDTO> getUserDetails()
	{
		return userService.getUserDetails();
	}
	
}
