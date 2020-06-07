package com.mthree.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mthree.dto.UserEventDTO;
import com.mthree.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	public List<User> findUserByEventId(int id);
	
	@Query("UPDATE User u SET u.userName=:name, u.eventId=:eventId WHERE u.userId=:id")
	@Modifying
	@Transactional
	public int updateUserByUserId(@Param("id") int id,@Param("name") String name,@Param("eventId") int eventId);
	
	@Query("SELECT new com.mthree.dto.UserEventDTO(u.userId,u.userName,e.eventId,e.eventName) FROM User u inner join Event e ON u.eventId=e.eventId")
	public List<UserEventDTO> getUserDetails();
	
}
