package com.harllan.dio.meetingroom.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harllan.dio.meetingroom.exception.ResourceNotFoundException;
import com.harllan.dio.meetingroom.model.Room;
import com.harllan.dio.meetingroom.repository.RoomRepository;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RoomController {

	@Autowired
	private RoomRepository roomRepository;
	
	@GetMapping("/rooms")
	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}
	
	@GetMapping("/rooms/{id}")
	public ResponseEntity<Room> getRoomById(@PathVariable("id") long roomId) throws ResourceNotFoundException {
		Room room = roomRepository.findById(roomId)
				.orElseThrow(() -> new ResourceNotFoundException("Room not found for this id:: " + roomId));
		
		return ResponseEntity.ok().body(room);
	}
	
	@PostMapping("/rooms")
	public Room createRoom(@Valid @RequestBody Room room) {
		return roomRepository.save(room);
	}
	
	@PutMapping("/rooms/{id}")
	public ResponseEntity<Room> updateRoom(@PathVariable("id") long roomId, @Valid @RequestBody Room roomToUpdate) throws ResourceNotFoundException {
		Room room = roomRepository.findById(roomId)
				.orElseThrow(() -> new ResourceNotFoundException("Room not found for this id:: " + roomId));
		
		room.setName(roomToUpdate.getName());
		room.setDate(roomToUpdate.getDate());
		room.setEndHour(roomToUpdate.getEndHour());
		room.setStartHour(roomToUpdate.getStartHour());
		
		final Room roomUpdated = roomRepository.save(room);
		
		return ResponseEntity.ok(roomUpdated);
	}
	
	@DeleteMapping("/rooms/{id}")
	public Map<String, Boolean> deleteRoom(@PathVariable("id") long roomId) throws ResourceNotFoundException {
		Room room = roomRepository.findById(roomId)
				.orElseThrow(() -> new ResourceNotFoundException("Room not found for this id:: " + roomId));
		
		roomRepository.delete(room);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
	
}
