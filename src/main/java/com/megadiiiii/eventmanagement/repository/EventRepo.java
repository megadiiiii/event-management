package com.megadiiiii.eventmanagement.repository;

import com.megadiiiii.eventmanagement.models.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EventRepo extends JpaRepository<EventEntity, Long> {
    Optional<EventEntity> findByEventName(String eventName);

    //Search by eventName
    @Query("select e from events e where e.eventName like concat('%', :query, '%') ")
    List<EventEntity> searchEvent(String query);
}
