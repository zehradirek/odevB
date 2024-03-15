package com.tobeto.service;

import com.tobeto.dto.rack.RackRequestDTO;
import com.tobeto.entity.Rack;
import com.tobeto.repository.RackRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RackService {
    @Autowired
    private RackRepository rackRepository;

    //method for listing all the racks
    public List<Rack> getAllRacks() {
        return rackRepository.findAll();
    }

    //method for creating racks
    @Transactional
    public int createRacks(RackRequestDTO dto) {
        int rackCapacity = dto.getRackCapacity();
        int rackCount = dto.getRackCount();

        // Ensure capacity and count are within limits
        if (rackCapacity > 5) {
            rackCapacity = 5;
        }
        if (rackCount > 50) {
            rackCount = 50;
        }

        int createdRackCount = 0;
        for (int i = 0; i < rackCount; i++) {
            Rack rack = new Rack();
            rack.setRackCapacity(rackCapacity);
            rackRepository.save(rack); // Save rack to generate ID
            rackRepository.flush(); // Ensure changes are flushed to the database

            // Ensure rack ID is set before assigning column and row
            if (rack.getId() != 0) { // Assuming default ID value is 0
                autoAssignColumnAndRow(rack); // Assign column and row based on ID
                createdRackCount++;
            } else {
                // Handle case where rack ID is not set (if necessary)
            }
        }
        return createdRackCount;
    }












    //auto assigning column and row values sequentially
    private void autoAssignColumnAndRow(Rack rack) {
        int rackId = rack.getId();

        if (rackId != 0) { // Assuming default ID value is 0
            // Calculate column: 'A' + ((rackId - 1) / 9) to increment column every 9 racks and go up to 'Z'
            char column = (char) ('A' + Math.min((rackId - 1) / 9, 25));
            // Calculate row: '1' + (((rackId - 1) % 9) + 1) to generate row values from '1' to '9' and reset to '1' after reaching '9'
            char row = (char) ('0' + (((rackId - 1) % 9) + 1));
            rack.setRackColumn(column); // Set column
            rack.setRackRow(row);       // Set row
        } else {
            // Handle case where rack ID is not set (if necessary)
        }
    }




























    //save rack for assigning a rack to product
//        public Rack saveRack(Rack rack) {
//            return rackRepository.save(rack);
//       }

        //delete a rack
        public void deleteRack(int id) {
        rackRepository.deleteById(id);
        }

        //update a rack
        public void updateRack(int id, int capacity) {
            Optional<Rack> oRack = rackRepository.findById(id);
            if (oRack.isPresent()) {
                Rack rack = oRack.get();
                rack.setRackCapacity(capacity);
                rackRepository.save(rack);
            }
        }
    }

