package com.mthree.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.dto.UserEventDTO;
import com.mthree.models.User;
import com.mthree.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findUsers()
	{
		return userRepository.findAll();
	}
	
	public void deleteUser(int id)
	{
		userRepository.deleteById(id);
	}
	
	public User getUser(int id)
	{
		Optional<User> tmp=userRepository.findById(id);
		if(tmp.isPresent())
			return tmp.get();
		else
			return null;
	}
	
	public User insertUser(User u)
	{
		return userRepository.save(u);
	}
	
	public List<User> getUsers(int id)
	{
		return userRepository.findUserByEventId(id);
	}
	
	public boolean editUser(int id,String name,int eventId)
	{
		int i=userRepository.updateUserByUserId(id, name, eventId);
		if(i>0)
			return true;
		else
			return false;
	}
	
	public List<UserEventDTO> getUserDetails()
	{
		return userRepository.getUserDetails();
	}

}
