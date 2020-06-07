package com.mthree.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mthree.models.Event;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer>
{
	@Query("UPDATE Event e SET e.eventName=:name WHERE e.eventId=:id")
	@Modifying
	@Transactional
	public int updateEventNameByEventId(@Param("id") int id,@Param("name") String name);
}
