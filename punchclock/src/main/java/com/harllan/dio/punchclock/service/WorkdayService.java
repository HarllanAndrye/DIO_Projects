package com.harllan.dio.punchclock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harllan.dio.punchclock.entity.Workday;
import com.harllan.dio.punchclock.repository.WorkdayRepository;

@Service
public class WorkdayService {
	
	@Autowired
	WorkdayRepository workdayRepository;

	public List<Workday> findAll() {
		return workdayRepository.findAll();
	}

	public Workday save(Workday workday) {
		return workdayRepository.save(workday);
	}

	public Optional<Workday> getById(Long id) {
		return workdayRepository.findById(id);
	}

	public Workday update(Workday workday) {
		return workdayRepository.save(workday);
	}

	public void delete(Long id) {
		workdayRepository.deleteById(id);
	}

}
