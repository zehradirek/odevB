package com.tobeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.Rack;
import com.tobeto.repository.RackRepository;

@Service
public class RackService {
	@Autowired
	private RackRepository rackRepository;

	public List<Rack> getAllRacks() {
		return rackRepository.findAll();
	}

	public Optional<Rack> getAllRacksAndCapacity(int id, int rackCount) {
		return rackRepository.findByIdAndRackCount(id, rackCount);
	}

}
