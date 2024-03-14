package com.tobeto.service;

import com.tobeto.entity.Rack;
import com.tobeto.repository.RackRepository;
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
    public int createRacks(int rackCapacity, int rackCount) {
        if (rackCapacity > 5) {
            rackCapacity = 5;
        }
        if (rackCount > 50) {
            rackCount = 50;
        }
        for (int i = 0; i < rackCount; i++) {
            Rack rack = new Rack();
            rack.setRackCapacity(rackCapacity);
            autoAssingColumnandRow(rack);
            rackRepository.save(rack);
        }
        return rackCount;
        }

        //auto assigning column and row values sequentially
        private void autoAssingColumnandRow(Rack rack) {
        int rackId = rack.getId();
        rack.setRackColumn((char) ('A' + (rackId / 26)));
        rack.setRackRow((char) ('1' + (rackId % 26)));
        }

        //save rack for assigning a rack to product
        public Rack saveRack(Rack rack) {
            return rackRepository.save(rack);
        }

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

