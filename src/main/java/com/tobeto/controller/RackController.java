package com.tobeto.controller;

import com.tobeto.dto.SuccessResponseDTO;
import com.tobeto.dto.rack.DeleteRackRequestDTO;
import com.tobeto.dto.rack.RackRequestDTO;
import com.tobeto.dto.rack.RackResponseDTO;
import com.tobeto.dto.rack.UpdateRackRequestDTO;
import com.tobeto.entity.Rack;
import com.tobeto.service.RackService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rack")
public class RackController {
    @Autowired
    private RackService rackService;

    @Autowired
    @Qualifier("requestMapper")
    private ModelMapper requestMapper;

    @Autowired
    @Qualifier("responseMapper")
    private ModelMapper responseMapper;

    //creating racks
    @PostMapping("/create")
    public SuccessResponseDTO createRacks(@RequestBody RackRequestDTO dto) {
        int count = rackService.createRacks(dto);
        return new SuccessResponseDTO(String.valueOf(count));
    }


    //get all racks
    @GetMapping("/get")
    public List<RackResponseDTO> getAllRacks() {
        List<Rack> racks = rackService.getAllRacks();
        return racks.stream().map(r -> responseMapper.map(r, RackResponseDTO.class)).toList();
    }

    //delete a rack by id
    @PostMapping("/delete")
    public SuccessResponseDTO deleteRack(@RequestBody DeleteRackRequestDTO dto) {
        rackService.deleteRack(dto.getId());
        return new SuccessResponseDTO();
    }

    //update a rack by id
    @PostMapping("/update")
    public SuccessResponseDTO updateRack(@RequestBody UpdateRackRequestDTO dto) {
        rackService.updateRack(dto.getId(), dto.getCapacity());
        return new SuccessResponseDTO();
    }
}
