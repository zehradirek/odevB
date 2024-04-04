package com.tobeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tobeto.entity.Rack;

public interface RackRepository extends JpaRepository<Rack, Integer> {

	Optional<Rack> findByIdAndRackCount(int id, int rackCount);
}
