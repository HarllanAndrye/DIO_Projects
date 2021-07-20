package com.harllan.dio.meetingroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harllan.dio.meetingroom.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
